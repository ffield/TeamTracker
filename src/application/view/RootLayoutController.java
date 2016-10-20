package application.view;

import application.Main;
import javafx.fxml.FXML;

public class RootLayoutController {
	private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
