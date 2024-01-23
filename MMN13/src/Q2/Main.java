package Q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main entry point for the JavaFX application.
 * This class extends the Application class and sets up the primary stage (window)
 * for the user interface.
 */
public class Main extends Application {

    /**
     * The start method is the main entry point for all JavaFX applications.
     * This method is called after the application has been initialized.
     * 
     * @param primaryStage The primary stage for this application, onto which
     *                     the application scene can be set.
     * @throws Exception Throws an exception if there is an issue loading the FXML file
     *                   or setting up the primary stage.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file. This file defines the layout of the user interface.
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Set the title of the window (stage) to "Simple Calculator".
        primaryStage.setTitle("Simple Calculator");

        // Create a new scene with the loaded FXML layout and set it on the primary stage.
        primaryStage.setScene(new Scene(root));

        // Show the primary stage. This makes the application window visible to the user.
        primaryStage.show();
    }

    /**
     * The main method is the entry point to the JavaFX application.
     * It is called when the application starts.
     * 
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Launch the JavaFX application.
        // This method does not return until the application has exited.
        launch(args);
    }
}
