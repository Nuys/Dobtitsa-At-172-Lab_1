package sample.Controllers;

import javafx.fxml.FXML;

import java.awt.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputPlaceNumberController {

    public static String placeNumber;
    public static boolean IsCancel = false;

    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtPlaceNumber;

    public boolean OnClickedCancel(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        return IsCancel = true;
    }
        public boolean onClickedOk (MouseEvent mouseEvent){
            if (!txtPlaceNumber.getText().isEmpty()&&txtPlaceNumber.getText().matches("[0-9]{1,2}")) {
                placeNumber = txtPlaceNumber.getText();
                OnClickedCancel(mouseEvent);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Некорректный ввод!");
                alert.setContentText("Просто вводите месте на стоянке");
                alert.showAndWait();
            }
            return IsCancel = false;
        }
    }

