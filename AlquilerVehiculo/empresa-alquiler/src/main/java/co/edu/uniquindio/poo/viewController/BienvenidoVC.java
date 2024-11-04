package co.edu.uniquindio.poo.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class BienvenidoVC {
    App app;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_gestion;

    @FXML
    private Button btt_ingresa;

    @FXML
    void Abrir(ActionEvent event) {
        try {
            app.openCrudCliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        assert lbl_gestion != null : "fx:id=\"lbl_gestion\" was not injected: check your FXML file 'BotonBienvenido.fxml'.";
        assert btt_ingresa != null : "fx:id=\"btt_ingresa\" was not injected: check your FXML file 'BotonBienvenido.fxml'.";

    }
}
