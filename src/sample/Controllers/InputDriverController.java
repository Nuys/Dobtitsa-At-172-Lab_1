package sample.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InputDriverController {
    public static boolean IsCancel = false;
    public static String place_numberCheck;
    public static String fullName;
    public static String carModel;
    public static String availabilityOfCar = null;
    public static String paymentCont = null;
    @FXML
    private Button btnCancel;
    @FXML
    private  MenuItem yepItemAdd;
    @FXML
    private MenuItem noYepItemAdd;
    @FXML
    private MenuButton btnMenuAvailabilityOfCarAdd;
    @FXML
    private MenuButton btnMenuPaymentAdd;
    @FXML
    private MenuItem payment;
    @FXML
    private MenuItem noPayment;
    @FXML
    private TextField txtFullNameAdd;
    @FXML
    private TextField txtCarModelAdd;
    @FXML
    private TextField txtPlaceNumberCheck;


    public void setItemMenuAddAvail(){
         yepItemAdd.setOnAction((e) -> btnMenuAvailabilityOfCarAdd.setText("Есть"));
        noYepItemAdd.setOnAction((e) -> btnMenuAvailabilityOfCarAdd.setText("Нету"));
    }
    public void setItemMenuAddPay(){
       payment.setOnAction((e) -> btnMenuPaymentAdd.setText("Оплачено"));
       noPayment.setOnAction((e) -> btnMenuPaymentAdd.setText("Неоплачено"));
    }
    public boolean OnClickedOk(MouseEvent mouseEvent) {
    if (!btnMenuAvailabilityOfCarAdd.getText().equals("Наличие авто на стоянке")
            && !btnMenuPaymentAdd.getText().isEmpty() && !btnMenuPaymentAdd.getText().equals("Оплата")
            && !txtFullNameAdd.getText().isEmpty() && txtFullNameAdd.getText().matches("[А-Я][а-я]{2,}[ ][А-Я][а-я]{2,}[ ][А-Я][а-я]{2,}")
            && !txtCarModelAdd.getText().isEmpty() && txtCarModelAdd.getText().matches("[А-Я][а-я]{2,}")
            && !txtPlaceNumberCheck.getText().isEmpty() && txtPlaceNumberCheck.getText().matches("[0-9]{1,2}")) {
        availabilityOfCar = btnMenuAvailabilityOfCarAdd.getText();
        paymentCont = btnMenuPaymentAdd.getText();
        fullName = txtFullNameAdd.getText();
        carModel = txtCarModelAdd.getText();
        place_numberCheck = txtPlaceNumberCheck.getText();
        OnClickedCancel(mouseEvent);
    }else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Некорректный ввод!");
        alert.setContentText("Проверте правильность вводимых данных , первые буквы - заглавные!");
        alert.showAndWait();
    }
return IsCancel = false;
}

    public boolean OnClickedCancel(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        return IsCancel=true;
    }
}
