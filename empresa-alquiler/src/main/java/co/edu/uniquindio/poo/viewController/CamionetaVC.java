package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.Controller.CamionetaCON;
import co.edu.uniquindio.poo.model.Camioneta;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CamionetaVC {

    CamionetaCON camionetaCON;
    ObservableList<Camioneta> listCamioneta = FXCollections.observableArrayList();
    Camioneta selectedCamioneta;
    App app;


    public String getPlacaCamioneta() {
        return txt_PlacaCamioneta.getText();
    }
    
    public String getMarcaCamioneta() {
        return txt_MarcaCamioneta.getText();
    }
    
    public String getModeloCamioneta() {
        return txt_ModeloCamioneta.getText();
    }
    
    public int getAnioCamioneta() {
        return Integer.parseInt(txt_AñoCamioneta.getText());
    }
    
    public int getCapacidadCarga() {
        return Integer.parseInt(txt_capacidad.getText());
    }
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Camioneta, String> tbc_ModeloCamioenta;

    @FXML
    private TableView<Camioneta> tb_listCamioneta;

    @FXML
    private Button txt_eliminarCamioneta;

    @FXML
    private Button btn_ActualizarCamioneta;

    @FXML
    private TextField txt_AñoCamioneta;

    @FXML
    private TextField txt_PlacaCamioneta;

    @FXML
    private TextField txt_capacidad;

    @FXML
    private TextField txt_ModeloCamioneta;

    @FXML
    private TextField txt_MarcaCamioneta;

    @FXML
    private TableColumn<Camioneta, String> tbc_MarcaCamioneta;

    @FXML
    private TableColumn<Camioneta, Integer> tbc_Año;

    @FXML
    private TableColumn<Camioneta, Integer> tbc_Capacidad;

    @FXML
    private Button btn_agregar;

    @FXML
    private Button btn_volver;

    @FXML
    private TableColumn<Camioneta, String> tbc_PlacaCamioneta;
    public Object txt_placaCamioneta;
    public Object txt_marcaCamioneta;
    public Object txt_modeloCamioneta;
    public Object txt_capacidadCamioneta;
    public Object txt_anioCamioneta;

    @FXML
    void volver(ActionEvent event) {
        try {
            app.openCrudCliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AgregarCamioneta(ActionEvent event) {
        agregarCamioneta();
        
    }

    @FXML
    void EliminarCamioneta(ActionEvent event) {
        eliminarCliente();
    }

    @FXML
    void ActualizarCamioneta(ActionEvent event) {
        actualizarCamioneta();
    }

    @FXML
    void initialize() {
        assert tbc_ModeloCamioenta != null : "fx:id=\"tbc_ModeloCamioenta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert tb_listCamioneta != null : "fx:id=\"tb_listCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert txt_eliminarCamioneta != null : "fx:id=\"txt_eliminarCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert btn_ActualizarCamioneta != null : "fx:id=\"btn_ActualizarCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert txt_AñoCamioneta != null : "fx:id=\"txt_AñoCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert txt_PlacaCamioneta != null : "fx:id=\"txt_PlacaCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert txt_capacidad != null : "fx:id=\"txt_capacidad\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert txt_ModeloCamioneta != null : "fx:id=\"txt_ModeloCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert txt_MarcaCamioneta != null : "fx:id=\"txt_MarcaCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert tbc_MarcaCamioneta != null : "fx:id=\"tbc_MarcaCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert tbc_Año != null : "fx:id=\"tbc_Año\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert tbc_Capacidad != null : "fx:id=\"tbc_Capacidad\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert btn_agregar != null : "fx:id=\"btn_agregar\" was not injected: check your FXML file 'Camioneta.fxml'.";
        assert tbc_PlacaCamioneta != null : "fx:id=\"tbc_PlacaCamioneta\" was not injected: check your FXML file 'Camioneta.fxml'.";
        camionetaCON = new CamionetaCON(App.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerCamionetas();

        // Limpiar la tabla
        tb_listCamioneta.getItems().clear();

        // Agregar los elementos a la tabla
        tb_listCamioneta.setItems(listCamioneta);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void initDataBinding() {
        tbc_PlacaCamioneta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tbc_MarcaCamioneta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbc_ModeloCamioenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbc_Año.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAñoFabricacion()));
        tbc_Capacidad.setCellValueFactory(celldata -> new SimpleObjectProperty(celldata.getValue().getCapacidadCarga()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerCamionetas() {
        listCamioneta.addAll(camionetaCON.obtenerLisCamionetas());
    }

    private void listenerSelection() {
        tb_listCamioneta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCamioneta = newSelection;
            mostrarInformacionCamioneta(selectedCamioneta);
        });
    }

    private void mostrarInformacionCamioneta(Camioneta camioneta) {
        if (camioneta != null) {
            txt_PlacaCamioneta.setText(camioneta.getPlaca());
            txt_MarcaCamioneta.setText(camioneta.getMarca());
            txt_ModeloCamioneta.setText(camioneta.getModelo());
            txt_AñoCamioneta.setText(String.valueOf(camioneta.getAñoFabricacion()));
            txt_capacidad.setText(String.valueOf(camioneta.getCapacidadCarga()));
        }
    }

    private void agregarCamioneta() {
        Camioneta camioneta = buildCamioneta();
        if (camionetaCON.crearCamioneta(camioneta)) {
            listCamioneta.add(camioneta);
            limpiarCamposCamioneta();
        }
    }

    private Camioneta buildCamioneta() {
        int año = Integer.parseInt(txt_AñoCamioneta.getText());
        int capacidad = Integer.parseInt(txt_capacidad.getText());
    
        Camioneta camioneta = new Camioneta(txt_PlacaCamioneta.getText(),txt_MarcaCamioneta.getText(),txt_ModeloCamioneta.getText(),año,capacidad);
    
        return camioneta;
    }
    

    private void eliminarCliente() {
        if (camionetaCON.eliminarCamioneta(txt_PlacaCamioneta.getText())) {
            listCamioneta.remove(selectedCamioneta);
            limpiarCamposCamioneta();
            limpiarSeleccion();
        }
    }

    private void actualizarCamioneta() {

        if (selectedCamioneta != null &&
                camionetaCON.actualizarCamioneta(selectedCamioneta.getPlaca(), buildCamioneta())) {

            int index = listCamioneta.indexOf(selectedCamioneta);
            if (index >= 0) {
                listCamioneta.set(index, buildCamioneta());
            }

            tb_listCamioneta.refresh();
            limpiarSeleccion();
            limpiarCamposCamioneta();
        }
    }

    private void limpiarSeleccion() {
        tb_listCamioneta.getSelectionModel().clearSelection();
        limpiarCamposCamioneta();
    }

    private void limpiarCamposCamioneta() {
        txt_PlacaCamioneta.clear();
        txt_MarcaCamioneta.clear();
        txt_ModeloCamioneta.clear();
        txt_AñoCamioneta.clear();
        txt_capacidad.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}