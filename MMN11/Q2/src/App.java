import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The App class is the main entry point for the JavaFX application.
 */
public class App extends Application {

    /**
     * This method is called when the application is launched.
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
        primaryStage.setTitle("Shapes drewing application");

        // Set the scene of the primary stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * The main method for the application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}