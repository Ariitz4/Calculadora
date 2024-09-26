package es.aritzherrero.scenebuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CalculadoraControl {

    @FXML
    private Button btBorrar;

    @FXML
    private Button btCalcular;

    @FXML
    private RadioButton btDivide;

    @FXML
    private RadioButton btMultiplica;

    @FXML
    private RadioButton btResta;

    @FXML
    private RadioButton btSuma;

    @FXML
    private TextField menuResult;

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    void borrar(ActionEvent event) {
        menuResult.setText("0");
        num1.setText("");
        num2.setText("");
        btSuma.setSelected(false);
        btResta.setSelected(false);
        btMultiplica.setSelected(false);
        btDivide.setSelected(false);
    }

    @FXML
    void calcular(ActionEvent event){
        Alert alerta= new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Porfavor utiliza solamente numeros");
        try {
            int numA= Integer.parseInt(num1.getText());
            int numB= Integer.parseInt(num2.getText());
            if(btSuma.isSelected()){
                menuResult.setText((numA+numB)+"");
            } else if (btResta.isSelected()) {
                menuResult.setText((numA-numB)+"");
            }else if (btMultiplica.isSelected()) {
                menuResult.setText((numA*numB)+"");
            }else if (btDivide.isSelected()) {
                if(numB==0){
                    alerta.setContentText("El divisor no puede ser 0");
                    alerta.showAndWait();
                }else{
                    menuResult.setText((numA/numB)+"");
                }
            }else{
                alerta.setContentText("Por Favor Selecciona un tipo de operacion");
                alerta.showAndWait();
            }
        }catch (NumberFormatException e){
            alerta.showAndWait();
        }


    }

}
