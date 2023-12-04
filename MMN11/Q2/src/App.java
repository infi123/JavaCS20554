import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The App class is the main entry point for the JavaFX application.
 */
public class App extends Application {
    // Constants for the width and height of the application window
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /**
     * This method is called when the application is launched.
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Create a new canvas and button
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Button button = new Button("Draw Shapes");
        // Create a new controller and set it to handle button actions
        Controller controller = new Controller(canvas.getGraphicsContext2D());
        button.setOnAction(event -> controller.drawRandomShapes());

        // Create a new VBox layout and set it as the scene of the primary stage
        VBox vbox = new VBox(button, canvas);
        primaryStage.setScene(new Scene(vbox));
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