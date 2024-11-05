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
        private Button btt_Camioneta;
    
        @FXML
        private Label lbl_inicio;
    
        @FXML
        private Button btt_cliente;
    
        @FXML
        private Button btt_Moto;
    
        @FXML
        private Button btt_Auto;
    
        @FXML
        void AdministrarReservas(ActionEvent event) {
            try {
                app.openReserva();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        void AbrirCamioneta(ActionEvent event) {
            try {
                app.openCamioneta();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        @FXML
        void abrirMoto(ActionEvent event) {
            try {
                app.openMoto();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        @FXML
        void AbrirAuto(ActionEvent event) {
            try {
                app.openAuto();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        public void setApp(App app) {
            this.app = app;
        }
    
        @FXML
        void initialize() {
            assert btt_reserva != null : "fx:id=\"btt_reserva\" was not injected: check your FXML file 'Inicio.fxml'.";
            assert btt_Camioneta != null : "fx:id=\"btt_Camioneta\" was not injected: check your FXML file 'Inicio.fxml'.";
            assert lbl_inicio != null : "fx:id=\"lbl_inicio\" was not injected: check your FXML file 'Inicio.fxml'.";
            assert btt_cliente != null : "fx:id=\"btt_cliente\" was not injected: check your FXML file 'Inicio.fxml'.";
            assert btt_Moto != null : "fx:id=\"btt_Moto\" was not injected: check your FXML file 'Inicio.fxml'.";
            assert btt_Auto != null : "fx:id=\"btt_Auto\" was not injected: check your FXML file 'Inicio.fxml'.";
    
        }
    }
    

