import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Controller {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MAX_SHAPE_SIZE = WIDTH / 4;
    private final Random random = new Random();
    private final GraphicsContext gc;

    public Controller(GraphicsContext gc) {
        this.gc = gc;
    }

    public void drawRandomShapes() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < 10; i++) {
            gc.setFill(new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0));
            int size = random.nextInt(MAX_SHAPE_SIZE);
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);

            switch (random.nextInt(3)) {
                case 0:
                    gc.fillRect(x, y, size, size);
                    break;
                case 1:
                    gc.fillOval(x, y, size, size);
                    break;
                case 2:
                    gc.strokeLine(x, y, x + size, y + size);
                    break;
            }
        }
    }
}