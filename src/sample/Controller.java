package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Classes.Driver;
import sample.Classes.Drivers;
import sample.Controllers.InputDriverController;
import sample.Controllers.InputPlaceNumberController;
import sample.Controllers.InputSurnameController;

import java.io.File;
import java.io.IOException;

public class Controller {
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

    private static Drivers drivers;

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
                AlertInformation("Добавление водителя в список", "Место уже занято", "Место уже занято, проверьте правильность ввода!", Alert.AlertType.INFORMATION);
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
    }
    public void listOfAvailablePlaceNumber(ActionEvent actionEvent){
        list.setAll(drivers.getDaraByFreePlace());
    }
    public void printList(ActionEvent actionEvent){
        list.setAll(drivers.getList());
    }
    public void findBySurname(ActionEvent actionEvent){
Main.inputSurname();
if(InputSurnameController.surname!=null && !InputSurnameController.IsCancel){
    list.setAll(drivers.getDataBySurname(InputSurnameController.surname));
   if(list.size()==0){
       AlertInformation("Поиск водителя по фамилии","Не найден","Такого водителя не существует в базе ",Alert.AlertType.INFORMATION);
            }
        }
    }
    public void removeOfList(ActionEvent actionEvent){
        Main.inputSurname();
        if(InputSurnameController.surname!=null && !InputSurnameController.IsCancel){
            Driver driver = drivers.deleteDriver(InputSurnameController.surname);
            if((driver !=null)){
                list.remove(driver);
            }else{
                AlertInformation("Удаление водителя из списка","Фамилия не найдена","Такой фамилии нет в базе, проверте правильность ввода!", Alert.AlertType.INFORMATION);
            }
        }
    }
}
