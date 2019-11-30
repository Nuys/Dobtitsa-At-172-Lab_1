package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import sample.Classes.Driver;
import sample.Classes.Drivers;
import sample.Controllers.InputDriverController;
import sample.Controllers.InputPlaceNumberController;
import sample.Controllers.InputSurnameController;
import sample.Classes.Serialization;
import sample.Classes.BackUp;
import javafx.stage.*;
import java.io.File;
import java.io.IOException;
import javafx.beans.value.ChangeListener;

public class Controller {
    private String pathname = null;
    private static Drivers drivers;
    private ObservableList<Driver> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Driver> tableDrivers;

    @FXML
    private TableColumn<Driver, String> placeNumberColumn;

    @FXML
    private TableColumn<Driver, String> fullNameColumn;

    @FXML
    private TableColumn<Driver, String> carModelColumn;

    @FXML
    private TableColumn<Driver, String> availabilityOfCarColumn;

    @FXML
    private TableColumn<Driver, String> paymentColumn;

    @FXML
    private void initialize() {
        drivers = new Drivers();

        placeNumberColumn.setCellValueFactory(new PropertyValueFactory<Driver, String>("placeNumber"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<Driver, String>("fullName"));
        carModelColumn.setCellValueFactory(new PropertyValueFactory<Driver, String>("carModel"));
        availabilityOfCarColumn.setCellValueFactory(new PropertyValueFactory<Driver, String>("availabilityOfCar"));
        paymentColumn.setCellValueFactory(new PropertyValueFactory<Driver, String>("payment"));
        addToTable();
    }

    private void addToTable() {
        list.addAll(drivers.getList());
        tableDrivers.setItems(list);
    }

    public void addToList(ActionEvent actionEvent) {
        Main.inputPlaceNumber();
        if (InputPlaceNumberController.placeNumber != null && !InputPlaceNumberController.IsCancel) {
            if (drivers.addToList(InputPlaceNumberController.placeNumber) != null) {
                list.add(drivers.getList().get(drivers.getList().size() - 1));
            } else {
                AlertInformation("Добавление места на парковку", "Место уже существует", "Место уже существует, проверьте правильность ввода!", Alert.AlertType.INFORMATION);
            }
        }
    }

    private void AlertInformation(String title, String header, String content, Alert.AlertType typeAlert) {
        Alert alert = new Alert(typeAlert);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void onAddDriver(ActionEvent actionEvent) {

        Driver selectedItem = tableDrivers.getSelectionModel().getSelectedItem();
        Main.inputDriver();
        if (InputDriverController.fullName != null && !InputDriverController.IsCancel) {
            list.setAll(drivers.getNewDriver(InputDriverController.place_numberCheck, InputDriverController.fullName, InputDriverController.carModel, InputDriverController.availabilityOfCar, InputDriverController.paymentCont));
        }
        else {
            AlertInformation("Добавления водителя в базу","Место уже занято","Место уже кем-то занято , посмотрите список свободных мест и добавте водителя на свободное место",Alert.AlertType.INFORMATION);
        }
    }

    public void listOfAvailablePlaceNumber(ActionEvent actionEvent) {
        list.setAll(drivers.getDaraByFreePlace());
    }

    public void printList(ActionEvent actionEvent) {
        list.setAll(drivers.getList());
    }

    public void findBySurname(ActionEvent actionEvent) {
        Main.inputSurname();
        if (InputSurnameController.surname != null && !InputSurnameController.IsCancel) {
            list.setAll(drivers.getDataBySurname(InputSurnameController.surname));
            if (list.size() == 0) {
                AlertInformation("Поиск водителя по фамилии", "Не найден", "Такого водителя не существует в базе ", Alert.AlertType.INFORMATION);
            }
        }
    }

    public void removeOfList(ActionEvent actionEvent) {
        Main.inputSurname();
        if (InputSurnameController.surname != null && !InputSurnameController.IsCancel) {
            Driver driver = drivers.deleteDriver(InputSurnameController.surname);
            if ((driver != null)) {
                list.remove(driver);
            } else {
                AlertInformation("Удаление водителя из списка", "Фамилия не найдена", "Такой фамилии нет в базе, проверте правильность ввода!", Alert.AlertType.INFORMATION);
            }
        }
    }

    private boolean FileOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие файла");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Текстовый документ", "*.txt", "*.ser", "*.bcp"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Window mainStage = null;
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            pathname = selectedFile.toString();
            return true;
        } else {
            return false;
        }
    }
    public void openFile(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        boolean isWantSave = FileOpen();
        if (isWantSave) {
            Serialization serialization = new Serialization(pathname);
            serialization.Deserialization(drivers);
            refresh();
        }
    }

        private void refresh(){
            tableDrivers.getItems().clear();
            addToTable();
        }
        public void exit(ActionEvent actionEvent){
        System.exit(0);
        }
        public static void BackUp(){
        BackUp backUp = new BackUp("Drivers.bcp",drivers);
        backUp.start();
        }
        private boolean FileSave() {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Сохранение файла");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Текстовый документ", ".txt"),
                    new FileChooser.ExtensionFilter("Сериализованный файл", ".ser"),
                    new FileChooser.ExtensionFilter("Резервный файл", "*.bcp"));
            Window mainStage = null;
            File nameFile = fileChooser.showSaveDialog(mainStage);
            if (nameFile != null) {
                pathname = nameFile.toString();
                return true;
            } else {
                return false;
            }
        }
        public void saveFile(ActionEvent actionEvent) throws IOException{
        boolean isWantSave = FileSave();
        if(isWantSave){
            Serialization serialization = new Serialization(pathname);
            serialization.Serialization(drivers);
        }
    }
    public void about(ActionEvent actionEvent){
        AlertInformation("О программе","License","Все права на лицензию пренадлежат компании InterNuys 2019©", Alert.AlertType.INFORMATION);
    }
    public void help(ActionEvent actionEvent){
        AlertInformation("Помощь","Помощь в использовании программы","Руководство к использованию. '\n'1)Прежде чем добавлять водителей добавте место ! '\n'2)После удаления водителя из базы добавте место которое удалили. '\n'3)Для открытые файла очистите поле ! '\n'4)Методы работы со списком находяться во вкладке Edit. '\n'5)Программа не добавит водителя на уже занятое место", Alert.AlertType.INFORMATION);
    }
    public void clearAll(ActionEvent actionEvent){
        drivers.getList().clear();
        tableDrivers.getItems().clear();
        list.clear();
    }
}




