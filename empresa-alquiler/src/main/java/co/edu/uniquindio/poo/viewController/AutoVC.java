package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'Auto.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.Controller.AutoController;
import co.edu.uniquindio.poo.model.Auto;
import javafx.beans.property.SimpleObjectProperty;
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
 
 public class AutoVC {

    AutoController autoController;
    ObservableList<Auto> listaAutos = FXCollections.observableArrayList();
    Auto selectedAuto;
    App app;

    public String getMatricula() {
        return txtPlaca.getText();
    }

    public String getMarca() {
        return txtMarca.getText();
    }

    public String getModelo() {
        return txtModelo.getText();
    }

    public int getAnio() {
        return Integer.parseInt(txtAnioFabricacion.getText());
    }

    public int getCantidadPuertas() {
        return Integer.parseInt(txtNumeroPuertas.getText());
    }
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="btnActualizarAuto"
     private Button btnActualizarAuto; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnMarca"
     private TableColumn<Auto, String> clnMarca; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblAnioFabricacion"
     private Label lblAnioFabricacion; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtModelo"
     private TextField txtModelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnAgregarAuto"
     private Button btnAgregarAuto; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnLimpiar"
     private Button btnLimpiar; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnAnioFabricacion"
     private TableColumn<Auto, String> clnAño; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtNumeroPuertas"
     private TextField txtNumeroPuertas; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnPuertas"
     private TableColumn<Auto, String> clnPuertas; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblNumeroPuertas"
     private Label lblNumeroPuertas; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblPlaca"
     private Label lblPlaca; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtAnioFabricacion"
     private TextField txtAnioFabricacion; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblMarca"
     private Label lblMarca; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblAuto"
     private TableView<Auto> tblAuto; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtPlaca"
     private TextField txtPlaca; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminarAuto"
     private Button btnEliminarAuto; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnModelo"
     private TableColumn<Auto, String> clnModelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="clnPlaca"
     private TableColumn<Auto, String> clnPlaca; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtMarca"
     private TextField txtMarca; // Value injected by FXMLLoader
 
     @FXML // fx:id="lblModelo"
     private Label lblModelo; // Value injected by FXMLLoader

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
     void agregarAuto(ActionEvent event) {
        agregarAuto();
     }
 
     @FXML
     void actualizarAuto(ActionEvent event) {
        actualizarAuto(); 
     }
 
     @FXML
     void limpiar(ActionEvent event) {
        limpiar(event);
     }
 
     @FXML
     void eliminarAuto(ActionEvent event) {
        eliminarAuto();
     }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert btnActualizarAuto != null : "fx:id=\"btnActualizarAuto\" was not injected: check your FXML file 'Auto.fxml'.";
         assert clnMarca != null : "fx:id=\"clnMarca\" was not injected: check your FXML file 'Auto.fxml'.";
         assert lblAnioFabricacion != null : "fx:id=\"lblAnioFabricacion\" was not injected: check your FXML file 'Auto.fxml'.";
         assert txtModelo != null : "fx:id=\"txtModelo\" was not injected: check your FXML file 'Auto.fxml'.";
         assert btnAgregarAuto != null : "fx:id=\"btnAgregarAuto\" was not injected: check your FXML file 'Auto.fxml'.";
         assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'Auto.fxml'.";
         assert clnAño != null : "fx:id=\"clnAnioFabricacion\" was not injected: check your FXML file 'Auto.fxml'.";
         assert txtNumeroPuertas != null : "fx:id=\"txtNumeroPuertas\" was not injected: check your FXML file 'Auto.fxml'.";
         assert clnPuertas != null : "fx:id=\"clnPuertas\" was not injected: check your FXML file 'Auto.fxml'.";
         assert lblNumeroPuertas != null : "fx:id=\"lblNumeroPuertas\" was not injected: check your FXML file 'Auto.fxml'.";
         assert lblPlaca != null : "fx:id=\"lblPlaca\" was not injected: check your FXML file 'Auto.fxml'.";
         assert txtAnioFabricacion != null : "fx:id=\"txtAnioFabricacion\" was not injected: check your FXML file 'Auto.fxml'.";
         assert lblMarca != null : "fx:id=\"lblMarca\" was not injected: check your FXML file 'Auto.fxml'.";
         assert tblAuto != null : "fx:id=\"tblAuto\" was not injected: check your FXML file 'Auto.fxml'.";
         assert txtPlaca != null : "fx:id=\"txtPlaca\" was not injected: check your FXML file 'Auto.fxml'.";
         assert btnEliminarAuto != null : "fx:id=\"btnEliminarAuto\" was not injected: check your FXML file 'Auto.fxml'.";
         assert clnModelo != null : "fx:id=\"clnModelo\" was not injected: check your FXML file 'Auto.fxml'.";
         assert clnPlaca != null : "fx:id=\"clnPlaca\" was not injected: check your FXML file 'Auto.fxml'.";
         assert txtMarca != null : "fx:id=\"txtMarca\" was not injected: check your FXML file 'Auto.fxml'.";
         assert lblModelo != null : "fx:id=\"lblModelo\" was not injected: check your FXML file 'Auto.fxml'.";
         autoController = new AutoController(App.empresa);
         initView();
     }

     private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerAutos();

        // Limpiar la tabla
        tblAuto.getItems().clear();

        // Agregar los elementos a la tabla
        tblAuto.setItems(listaAutos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        clnPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        clnMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        clnModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        clnAño.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAñoFabricacion()));
        clnPuertas.setCellValueFactory(celldata -> new SimpleObjectProperty(celldata.getValue().getPuertas()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerAutos() {
        listaAutos.addAll(autoController.obtenerListaAutos());
    }

    private void listenerSelection() {
        tblAuto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAuto = newSelection;
            mostrarInformacionAuto(selectedAuto);
        });
    }

    private void mostrarInformacionAuto(Auto auto) {
        if (auto != null) {
            txtPlaca.setText(auto.getPlaca());
            txtMarca.setText(auto.getMarca());
            txtModelo.setText(auto.getModelo());
            txtAnioFabricacion.setText(String.valueOf(auto.getAñoFabricacion()));
            txtNumeroPuertas.setText(String.valueOf(auto.getPuertas()));
        }
    }

    private void agregarAuto() {
        Auto auto = buildAuto();
        if (autoController.crearAuto(auto)) {
            listaAutos.add(auto);
            limpiarCamposAuto();
        }
    }

    private Auto buildAuto() {
        int anioFabricacion = Integer.parseInt(txtAnioFabricacion.getText());
        int puertas = Integer.parseInt(txtNumeroPuertas.getText());
    
        Auto auto = new Auto(txtPlaca.getText(),txtMarca.getText(),txtModelo.getText(),anioFabricacion,puertas);
    
        return auto;
    }
    

    private void eliminarAuto() {
        if (autoController.eliminarAuto(txtPlaca.getText())) {
            listaAutos.remove(selectedAuto);
            limpiarCamposAuto();
            limpiarSeleccion();
        }
    }

    private void actualizarAuto() {

        if (selectedAuto != null &&
                autoController.actualizarAuto(selectedAuto.getPlaca(), buildAuto())) {

            int index = listaAutos.indexOf(selectedAuto);
            if (index >= 0) {
                listaAutos.set(index, buildAuto());
            }

            tblAuto.refresh();
            limpiarSeleccion();
            limpiarCamposAuto();
        }
    }

    private void limpiarSeleccion() {
        tblAuto.getSelectionModel().clearSelection();
        limpiarCamposAuto();
    }

    private void limpiarCamposAuto() {
        txtPlaca.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtAnioFabricacion.clear();
        txtNumeroPuertas.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
 