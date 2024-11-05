package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.Controller.ReservaCON;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReservaVC {
    App app;
    ReservaCON reservaCON;
    ObservableList<Reserva> listrReservas = FXCollections.observableArrayList();
    Reserva selectedReserva;

    private CamionetaVC camionetaVC;
    private AutoVC autoVC;
    private MotoVC motoVC;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Reserva, String> tbcCodigo;

    @FXML
    private TableView<Reserva> tblistReserva;

    @FXML
    private TableColumn<Reserva, Vehiculo> tbcVehiculo;

    @FXML
    private Label lbl_titReserva;

    @FXML
    private TextField txt_codigo;

    @FXML
    private TextField txt_dias;

    @FXML
    private TableColumn<Reserva, Integer> tbcCosto;

    @FXML
    private Button btn_Eliminar;

    @FXML
    private Button btn_Agregar;

    @FXML
    private Button btn_Actualizar;

    @FXML
    private Button btn_volver;

    @FXML
    private TableColumn<Reserva, Integer> tbcDias;

    @FXML
    private TextField txt_Placa;

    

    @FXML
    void volver(ActionEvent event) {
        try {
            app.openCrudCliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    @FXML
    void agregarReserva(ActionEvent event) {
        agregarReserva();
    }

    @FXML
    void EliminarReserva(ActionEvent event) {
        EliminarReserva();
    }

    @FXML
    void Actualizarreserrva(ActionEvent event) {
        Actualizarreserrva();
    }

    @FXML
    void initialize() {
        assert btn_Eliminar != null : "fx:id=\"btn_Eliminar\" was not injected: check your FXML file 'reserva.fxml'.";
        assert tbcVehiculo != null : "fx:id=\"tbcVehiculo\" was not injected: check your FXML file 'reserva.fxml'.";
        assert lbl_titReserva != null : "fx:id=\"lbl_titReserva\" was not injected: check your FXML file 'reserva.fxml'.";
        assert btn_Agregar != null : "fx:id=\"btn_Agregar\" was not injected: check your FXML file 'reserva.fxml'.";
        assert txt_codigo != null : "fx:id=\"txt_codigo\" was not injected: check your FXML file 'reserva.fxml'.";
        assert tbcDias != null : "fx:id=\"tbcDias\" was not injected: check your FXML file 'reserva.fxml'.";
        assert tbcCodigo != null : "fx:id=\"tbcCodigo\" was not injected: check your FXML file 'reserva.fxml'.";
        assert tblistReserva != null : "fx:id=\"tblistReserva\" was not injected: check your FXML file 'reserva.fxml'.";
        assert btn_Actualizar != null : "fx:id=\"btn_Actualizar\" was not injected: check your FXML file 'reserva.fxml'.";
        assert txt_dias != null : "fx:id=\"txt_dias\" was not injected: check your FXML file 'reserva.fxml'.";
               
        reservaCON = new ReservaCON(App.empresa, null);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obetenerListaReserva();

        // Limpiar la tabla
        tblistReserva.getItems().clear();

        // Agregar los elementos a la tabla
        tblistReserva.setItems(listrReservas);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbcDias.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDiasAlquiler()));
        tbcVehiculo.setCellValueFactory(celldata -> new SimpleObjectProperty(celldata.getValue().getVehiculo()));
        tbcCosto.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().calcularCostoTotal()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obetenerListaReserva() {
        listrReservas.addAll(reservaCON.obetenerListaReserva());
    }

    private void listenerSelection() {
        tblistReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReserva = newSelection;
            mostrarInformacionReserva(selectedReserva);
        });
    }

    private void mostrarInformacionReserva(Reserva reserva) {
        if (reserva != null) {
            txt_codigo.setText(reserva.getCodigo());
            txt_dias.setText(String.valueOf(reserva.getDiasAlquiler()));
            
            // Asume que txt_vehiculo es el TextField que muestra la placa del vehículo
            txt_Placa.setText(reserva.getVehiculo().getPlaca());
        }
    }
    

    private void agregarReserva() {
        Reserva reserva = buildReserva();
        if (reservaCON.crearReserva(reserva)) {
            listrReservas.add(reserva);
            limpiarCamposReserva();
        }
    }

    private Reserva buildReserva() {
        int diasAlquiler = Integer.parseInt(txt_dias.getText());
        String codigo = txt_codigo.getText();
        String matricula = txt_Placa.getText().trim();
    
        Vehiculo vehiculo = null;
    
        if (app.empresa.buscarAuto(matricula) != null) {
            vehiculo = app.empresa.buscarAuto(matricula);
        } else if (app.empresa.buscarMoto(matricula) != null) {
            vehiculo = app.empresa.buscarMoto(matricula);
        } else if (app.empresa.buscarCamioneta(matricula) != null) {
            vehiculo = app.empresa.buscarCamioneta(matricula);
        } else {
            throw new IllegalArgumentException("Vehículo no encontrado para la matrícula: " + matricula);
        }
    
        return new Reserva(diasAlquiler, codigo, vehiculo);
    }
    

    private void EliminarReserva() {
        if (reservaCON.eliminarreserva(txt_codigo.getText())) {
            listrReservas.remove(selectedReserva);
            limpiarCamposReserva();
            limpiarSeleccion();
        }
    }

    private void Actualizarreserrva() {

        if (selectedReserva != null &&
                reservaCON.ActualizarReserrva(selectedReserva.getCodigo(), buildReserva())) {

            int index = listrReservas.indexOf(selectedReserva);
            if (index >= 0) {
                listrReservas.set(index, buildReserva());
            }

            tblistReserva.refresh();
            limpiarSeleccion();
            limpiarCamposReserva();
        }
    }

    private void limpiarSeleccion() {
        tblistReserva.getSelectionModel().clearSelection();
        limpiarCamposReserva();
    }

    private void limpiarCamposReserva() {
        txt_codigo.clear();
        txt_dias.clear();
        txt_Placa.clear();
    }
    public void setApp(App app) {
        this.app = app;
    }

}

