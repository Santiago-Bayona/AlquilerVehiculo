package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'RegistroCliente.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ClienteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextField;
 
 public class CrudClienteVC {

    ClienteController clienteController;

    @FXML
    private App app;
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="clnNombre"
     private TableColumn<?, ?> clnNombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblNombre"
     private Label lblNombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnEdad"
     private TableColumn<?, ?> clnEdad; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnLimpiar"
     private Button btnLimpiar; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtEdad"
     private TextField txtEdad; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnActualizarCliente"
     private Button btnActualizarCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblClientes"
     private TableView<?> tblClientes; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtCedula"
     private TextField txtCedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtNombre"
     private TextField txtNombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblEdad"
     private Label lblEdad; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminar"
     private Button btnEliminar; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblCedula"
     private Label lblCedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnCedula"
     private TableColumn<?, ?> clnCedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnAgregarCliente"
     private Button btnAgregarCliente; // Value injected by FXMLLoader
 
     @FXML
     void agregarAction(ActionEvent event) {
 
     }
 
     @FXML
     void actualizarAction(ActionEvent event) {
 
     }
 
     @FXML
     void limpiarAction(ActionEvent event) {
 
     }
 
     @FXML
     void eliminarAction(ActionEvent event) {
 
     }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
        clienteController = new ClienteController(app.empresa);
      
     }

     public void setApp(App app) {
        this.app = app;
    }
 }
 