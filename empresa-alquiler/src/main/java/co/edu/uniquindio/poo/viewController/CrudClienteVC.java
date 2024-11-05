package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'RegistroCliente.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.Controller.ClienteCon;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextField;
 
 public class CrudClienteVC {

    ClienteCon clienteController;

    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;

    App app;
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="clnNombre"
     private TableColumn<Cliente, String> clnNombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblNombre"
     private Label lblNombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnApellido"
     private TableColumn<Cliente, String> clnApellido; // Value injected by FXMLLoader
     
 
     @FXML // fx:id="btnLimpiar"
     private Button btnLimpiar; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtApellido"
     private TextField txt_apellido; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnActualizarCliente"
     private Button btnActualizarCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblClientes"
     private TableView<Cliente> tblClientes; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtCedula"
     private TextField txtCedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtNombre"
     private TextField txtNombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblApellido"
     private Label lblApellido; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminar"
     private Button btnEliminar; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblCedula"
     private Label lblCedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnCedula"
     private TableColumn<Cliente, String> clnCedula; // Value injected by FXMLLoader
     
 
     @FXML // fx:id="btnAgregarCliente"
     private Button btnAgregarCliente; // Value injected by FXMLLoader

     @FXML
    private Button btn_volver;


    @FXML
    void volver(ActionEvent event) {
        try {
            app.openCrudCliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     @FXML
    void agregarCliente(ActionEvent event) {
        agregarCliente(); 
    }

    @FXML
    void eliminarCliente(ActionEvent event) {
        eliminarCliente();
    }

    @FXML
    void actualizarCliente(ActionEvent event) {
        actualizarCliente();
    }

    
       
        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert clnNombre != null : "fx:id=\"clnNombre\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert lblNombre != null : "fx:id=\"lblNombre\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert btnActualizarCliente != null : "fx:id=\"btnActualizarCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert tblClientes != null : "fx:id=\"tblClientes\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert txtCedula != null : "fx:id=\"txtCedula\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert lblApellido != null : "fx:id=\"lblApellido\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert lblCedula != null : "fx:id=\"lblCedula\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert txt_apellido != null : "fx:id=\"txtApellido\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert clnApellido != null : "fx:id=\"clnApellido\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert clnCedula != null : "fx:id=\"clnCedula\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
            assert btnAgregarCliente != null : "fx:id=\"btnAgregarCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
    
        clienteController = new ClienteCon(App.empresa);
        initView();
      
     }

     private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tblClientes.getItems().clear();

        // Agregar los elementos a la tabla
        tblClientes.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        clnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getnombre()));
        clnApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        clnCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerClientes() {
        listClientes.addAll(clienteController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tblClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }



     private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtNombre.setText(cliente.getnombre());
            txt_apellido.setText(cliente.getApellido());
            txtCedula.setText(cliente.getCedula());
        }
    }


   private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (clienteController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }


    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txtNombre.getText(), txt_apellido.getText(), txtCedula.getText());
        return cliente;
    }


    private void eliminarCliente() {
        if (clienteController.eliminarCliente(txtCedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    private void actualizarCliente() {

        if (selectedCliente != null &&
                clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }

            tblClientes.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }


    private void limpiarSeleccion() {
        tblClientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txt_apellido.clear();
    }



     public void setApp(App app) {
        this.app = app;
    }
 }