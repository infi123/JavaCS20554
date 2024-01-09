package Q1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main entry point for the JavaFX application.
 * This class extends from Application and sets up the primary stage (window)
 * for the user interface.
 */
public class QuizApp extends Application {
    
    /**
     * The start method is the main entry point for all JavaFX applications.
     * @param primaryStage The primary stage for this application, onto which
     * the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file located in the same package as this class.
        // The FXML file defines the layout of the user interface.
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml")); 

        // Set the title that appears on the application window
        primaryStage.setTitle("Multiple Choice Test");

        // Create a scene with the loaded FXML layout and set it on the primary stage.
        primaryStage.setScene(new Scene(root));

        // Display the primary stage. This is what shows the window to the user.
        primaryStage.show();
    }

    /**
     * The main method is called when the application starts. It delegates to Application.launch().
     * @param args Command line arguments passed to the application. Not used in this application.
     */
    public static void main(String[] args) {
        // Launch the JavaFX application. This method does not return until the application has exited.
        launch(args);
    }
}
