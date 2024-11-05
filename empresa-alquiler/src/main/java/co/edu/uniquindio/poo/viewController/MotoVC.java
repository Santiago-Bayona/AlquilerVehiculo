package co.edu.uniquindio.poo.viewController;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.MotoCON;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Moto.TipoCaja;

public class MotoVC {

    Moto selectedMoto;
    @FXML
private Text text_placa;
@FXML
private Text text_marca;
@FXML
private Text text_modelo;
@FXML
private Text text_Anio;
@FXML
private TableColumn<Moto, String> clm_placa;
@FXML
private TableColumn<Moto, String> clm_marca;
@FXML
private TableColumn<Moto, String> columnaModelo;
@FXML
private TableColumn<Moto, Integer> clm_añof;
@FXML
private ComboBox<TipoCaja> box_caja;
@FXML
private TableView<Moto> clm_modelo;
@FXML
private Button btt_agregar;
@FXML
private Button btt_actualizar;

@FXML
private Button btt_Eliminar;
@FXML
private Text text_Tipo;
@FXML
private Text field_Tipo;
@FXML
private TableColumn<Moto, Enum<TipoCaja>> clm_tipo;
@FXML
private ResourceBundle resources;

@FXML
private URL location;

private MotoCON motoCON;
private Empresa empresa;

public String getMatricula() {
    return text_placa.getText();
}

public String getMarca() {
    return text_marca.getText();
}

public String getModelo() {
    return text_modelo.getText();
}

public int getAnio() {
    return Integer.parseInt(text_Anio.getText());
}

public TipoCaja getCaja() {
    return box_caja.getValue(); // Obtiene el valor seleccionado del ComboBox
}


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
    private TextField field_Placa;
    @FXML
    private TextField field_Marca;
    @FXML
    private TextField field_Modelo;
    @FXML
    private TextField field_Anio;


  private ObservableList<Moto> motosList = FXCollections.observableArrayList();
  
  @FXML
  void eliminarmoto(ActionEvent event) {
      eliminarmoto();
  }

  @FXML
  void ActualizarMoto(ActionEvent event) {
      actualizarmoto();
  }

    

    

    @FXML
    public void initialize() {
        this.empresa = new Empresa("Alquileres");
        this.motoCON = new MotoCON(empresa);

        clm_placa.setCellValueFactory(new PropertyValueFactory<>("placa"));
        clm_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        clm_añof.setCellValueFactory(new PropertyValueFactory<>("anioFabricacion"));
        clm_tipo.setCellValueFactory(new PropertyValueFactory<>("caja"));
        
        // Configura los valores posibles del ComboBox
        box_caja.setItems(FXCollections.observableArrayList(TipoCaja.values()));

        clm_modelo.setItems(motosList);

        btt_agregar.setOnAction(event -> agregarMoto());

        btt_actualizar.setOnAction(event -> actualizarmoto());

        btt_Eliminar.setOnAction(event -> eliminarmoto());

    
        initView();
    }

    






    private void initView() {
        // Traer los datos del cliente a la tabla
       initDataBinding();

        // Obtiene la lista
        obtenerMotos();

        // Limpiar la tabla
        clm_modelo.getItems().clear();

        // Agregar los elementos a la tabla
        clm_modelo.setItems(motosList);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void initDataBinding() {
        clm_placa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        clm_marca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        columnaModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        clm_añof.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAñoFabricacion()));
       
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    @FXML
    private void agregarMoto() {
        String placa = field_Placa.getText();
        String marca = field_Marca.getText();
        String modelo = field_Modelo.getText();
        int AnioFabricacion = Integer.parseInt(field_Anio.getText());
        TipoCaja caja = box_caja.getValue();

        if (caja == null) {
            mostrarAlerta("Error", "Por favor selecciona un tipo de cilindraje");
            return;
        }

        

        Moto moto = new Moto(placa, marca, modelo, AnioFabricacion, TipoCaja.Automatica);

        boolean motoAgregada = motoCON.crearmoto(moto);
        if (motoAgregada) {
            motosList.add(moto);
            limpiarCampos();
            mostrarAlerta("Éxito", "Moto agregada correctamente");
        } else {
            mostrarAlerta("Error", "La moto con esta placa ya existe");
        }
    }

    private void agregarmoto() {
        Moto moto = buildMoto();
        if (motoCON.crearmoto(moto)) {
            motosList.add(moto);
            limpiarCampos();
        }
    }

    private void obtenerMotos() {
        motosList.addAll(motoCON.obtenerLisMotos());
    }

    private void mostrarInformacionMoto(Moto moto) {
        if (moto != null) {
            clm_placa.setText(moto.getPlaca());
            clm_marca.setText(moto.getMarca());
            columnaModelo.setText(moto.getModelo());
            clm_añof.setText(String.valueOf(moto.getAñoFabricacion()));
            
        }
    }
    private void eliminarCliente() {
        if (motoCON.eliminarmoto(clm_placa.getText())) {
            motosList.remove(selectedMoto);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    private void eliminarmoto() {
        if (motoCON.eliminarmoto(clm_placa.getText())) {
            motosList.remove(selectedMoto);
            limpiarCampos();
            limpiarSeleccion();
        }
    }


    private void listenerSelection() {
        clm_modelo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMoto = newSelection;
            mostrarInformacionMoto(selectedMoto);
        });
    }

    private void actualizarmoto() {

        if (selectedMoto != null &&
                motoCON.Actualizarmoto(selectedMoto.getPlaca(), buildMoto())) {

            int index = motosList.indexOf(selectedMoto);
            if (index >= 0) {
                motosList.set(index, buildMoto());
            }

            clm_modelo.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    private Moto buildMoto() {
        int Anio = Integer.parseInt(clm_añof.getText());
        TipoCaja tipoCaja = box_caja.getValue();
    
        Moto moto = new Moto(field_Placa.getText(),field_Marca.getText(),field_Modelo.getText(),Anio,tipoCaja);
    
        return moto;
    }
    private void limpiarSeleccion() {
        clm_modelo.getSelectionModel().clearSelection();
        limpiarCampos();
    }

      
    
    

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    

    private App app;


    private void limpiarCampos() {
        field_Placa.clear();
        field_Marca.clear();
        field_Modelo.clear();
        field_Anio.clear();
        box_caja.setValue(null);
    }

    public void setApp(App app) {
        this.app = app;
    }

}



    
