package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReservaVC {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tbcCodigo;

    @FXML
    private TableView<?> tblistReserva;

    @FXML
    private TableColumn<?, ?> tbcVehiculo;

    @FXML
    private Label lbl_titReserva;

    @FXML
    private TextField txt_codigo;

    @FXML
    private TextField txt_dias;

    @FXML
    private Button btn_Costo;

    @FXML
    private TextField txt_vehiculo;

    @FXML
    private TextField txt_costo1;

    @FXML
    private TableColumn<?, ?> tbcDias;

    @FXML
    void CalcularCosto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tbcCodigo != null : "fx:id=\"tbcCodigo\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert tblistReserva != null : "fx:id=\"tblistReserva\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert tbcVehiculo != null : "fx:id=\"tbcVehiculo\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert lbl_titReserva != null : "fx:id=\"lbl_titReserva\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert txt_codigo != null : "fx:id=\"txt_codigo\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert txt_dias != null : "fx:id=\"txt_dias\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert btn_Costo != null : "fx:id=\"btn_Costo\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert txt_vehiculo != null : "fx:id=\"txt_vehiculo\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert txt_costo1 != null : "fx:id=\"txt_costo1\" was not injected: check your FXML file 'Reserva.fxml'.";
        assert tbcDias != null : "fx:id=\"tbcDias\" was not injected: check your FXML file 'Reserva.fxml'.";

    }
}

