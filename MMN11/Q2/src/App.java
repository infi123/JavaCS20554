import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Button button = new Button("Draw Shapes");
        Controller controller = new Controller(canvas.getGraphicsContext2D());
        button.setOnAction(event -> controller.drawRandomShapes());

        VBox vbox = new VBox(button, canvas);
        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}