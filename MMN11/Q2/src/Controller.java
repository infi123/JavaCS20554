import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

/**
 * The Controller class is responsible for drawing random shapes on a canvas.
 */
public class Controller {
    // Constants for the width and height of the canvas
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    // Maximum size for the shapes
    private static final int MAX_SHAPE_SIZE = WIDTH / 4;
    // Random number generator
    private final Random random = new Random();
    // Graphics context for drawing on the canvas
    private final GraphicsContext gc;
    // Number of shapes to draw
    private final int NUMBER_OF_SHAPES = 10;
    // Number of different shape types
    private final int NUMBER_OF_SHAPES_TYPES = 3;

    // Enum for the different shape types
    enum ShapeType {
        RECTANGLE,
        OVAL,
        LINE
    }

    /**
     * Constructor for the Controller class.
     * @param gc The graphics context for drawing on the canvas.
     */
    public Controller(GraphicsContext gc) {
        this.gc = gc;
    }

    /**
     * This method draws a number of random shapes on the canvas.
     */
    public void drawRandomShapes() {
        // Clear the canvas
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Draw the shapes
        for (int i = 0; i < NUMBER_OF_SHAPES; i++) {
            // Set a random color
            gc.setFill(new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0));
            // Determine the size and position of the shape
            int size = random.nextInt(MAX_SHAPE_SIZE);
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);

            // Draw the shape
            switch (ShapeType.values()[random.nextInt(NUMBER_OF_SHAPES_TYPES)]) {
                case RECTANGLE:
                    gc.fillRect(x, y, size, size);
                    break;
                case OVAL:
                    gc.fillOval(x, y, size, size);
                    break;
                case LINE:
                    gc.strokeLine(x, y, x + size, y + size);
                    break;
            }
        }
    }
}