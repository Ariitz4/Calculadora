package es.aritzherrero.scenebuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Controlador de la interfaz gráfica de la calculadora. Maneja los eventos
 * generados por los botones y las operaciones seleccionadas por el usuario.
 *
 * Esta clase está vinculada al archivo FXML que define la interfaz de la calculadora.
 *
 * @author Aritz Herrero
 * @version 1.0
 */
public class CalculadoraControl {

    // Botones y campos de texto que se definen en el archivo FXML
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

    /**
     * Metodo que se ejecuta cuando el usuario presiona el botón de "Borrar".
     * Limpia todos los campos de la interfaz, incluyendo el resultado y los números,
     * y deselecciona todas las operaciones.
     *
     * @param event El evento de acción generado al presionar el botón.
     */
    @FXML
    void borrar(ActionEvent event) {
        // Reiniciar el campo de resultado a "0"
        menuResult.setText("0");

        // Limpiar los campos de entrada de números
        num1.setText("");
        num2.setText("");

        // Deseleccionar todos los botones de operación
        btSuma.setSelected(false);
        btResta.setSelected(false);
        btMultiplica.setSelected(false);
        btDivide.setSelected(false);
    }

    /**
     * Metodo que se ejecuta cuando el usuario presiona el botón de "Calcular".
     * Dependiendo de la operación seleccionada (suma, resta, multiplicación, división),
     * realiza la operación correspondiente entre los dos números ingresados.
     *
     * Si el usuario intenta dividir por cero o introduce valores no numéricos,
     * se muestra una alerta con un mensaje de error.
     *
     * @param event El evento de acción generado al presionar el botón.
     */
    @FXML
    void calcular(ActionEvent event) {
        // Crear una alerta para mostrar en caso de errores
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null); // No mostrar encabezado en la alerta
        alerta.setContentText("Por favor utiliza solamente números");

        try {
            // Convertir los textos de los campos num1 y num2 a enteros
            int numA = Integer.parseInt(num1.getText());
            int numB = Integer.parseInt(num2.getText());

            // Verificar qué operación ha seleccionado el usuario
            if (btSuma.isSelected()) {
                // Suma de los números
                menuResult.setText((numA + numB) + "");
            } else if (btResta.isSelected()) {
                // Resta de los números
                menuResult.setText((numA - numB) + "");
            } else if (btMultiplica.isSelected()) {
                // Multiplicación de los números
                menuResult.setText((numA * numB) + "");
            } else if (btDivide.isSelected()) {
                // Verificar si el divisor es 0
                if (numB == 0) {
                    alerta.setContentText("El divisor no puede ser 0");
                    num2.setText(""); // Limpiar el segundo número
                    alerta.showAndWait(); // Mostrar la alerta y esperar que el usuario la cierre
                } else {
                    // División de los números
                    menuResult.setText((numA / numB) + "");
                }
            } else {
                // Si no se selecciona ninguna operación, mostrar un mensaje de error
                alerta.setContentText("Por favor selecciona un tipo de operación");
                alerta.showAndWait();
            }
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir los números, mostrar la alerta de error
            alerta.showAndWait();
        }
    }

}
