package sample.Controll;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class InputFreePlaceController {
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtPlace_number;
    public static String place_number;
    public static boolean IsCancel;
    public void WhenClickedCancel(MouseEvent mouseEvent){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        IsCancel = true;
    }
    public void WhenClickedOK(MouseEvent mouseEvent){
        if(!txtPlace_number.getText().isEmpty()&&txtPlace_number.getText().matches("[0-1]{1,2}")){
            place_number = txtPlace_number.getText();
            WhenClickedCancel(mouseEvent);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка ! ");
            alert.setHeaderText("Неужели так сложно ввести место !");
            alert.setContentText("Введите свободное место!");
            alert.showAndWait();
        }
        IsCancel = false;

    }
}
