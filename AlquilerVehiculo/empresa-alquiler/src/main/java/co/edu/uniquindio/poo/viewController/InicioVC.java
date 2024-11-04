package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InicioVC {

    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_reserva;

    @FXML
    private Label lbl_inicio;

    @FXML
    private Button btt_cliente;

    @FXML
    private Button btt_vehiculo;

    @FXML
    void AdministrarReservas(ActionEvent event) {

    }

    @FXML
    void AdministraClientes(ActionEvent event) {
        try {
            app.openCliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AdministrarVehiculos(ActionEvent event) {

    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        assert btt_reserva != null : "fx:id=\"btt_reserva\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert lbl_inicio != null : "fx:id=\"lbl_inicio\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert btt_cliente != null : "fx:id=\"btt_cliente\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert btt_vehiculo != null : "fx:id=\"btt_vehiculo\" was not injected: check your FXML file 'Inicio.fxml'.";

    }
}

