import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private TextField tftitle;

    @FXML
    void btnOkClicked(ActionEvent event) {
        Stage mainWindow = (Stage) tftitle.getScene().getWindow();
        String title = tftitle.getText();
        mainWindow.setTitle(title);
    }

}
