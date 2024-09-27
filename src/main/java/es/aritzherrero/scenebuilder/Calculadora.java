package es.aritzherrero.scenebuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación "Calculadora" que hereda de la clase
 * {@link javafx.application.Application}. Esta clase lanza una interfaz gráfica
 * definida en un archivo FXML.
 *
 * @author Aritz Herrero
 * @version 1.0
 */
public class Calculadora extends Application {

    /**
     * Metodo principal de la aplicación. Se encarga de configurar la ventana
     * principal y cargar la interfaz desde el archivo FXML.
     *
     * @param stage El escenario principal de la aplicación, que actúa como contenedor
     *              para la escena
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML que contiene la descripción de la interfaz
        FXMLLoader fxmlLoader = new FXMLLoader(Calculadora.class.getResource("calculadora-view.fxml"));

        // Crear una nueva escena con el contenido del archivo FXML y especificar su tamaño
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Establecer la escena en el escenario
        stage.setScene(scene);

        // Establecer el tamaño mínimo de la ventana
        stage.setMinHeight(300);
        stage.setMinWidth(600);

        // Mostrar la ventana
        stage.show();
    }

    /**
     * Método main que lanza la aplicación JavaFX.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        launch();
    }
}