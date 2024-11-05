package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.viewController.AutoVC;
import co.edu.uniquindio.poo.viewController.BienvenidoVC;
import co.edu.uniquindio.poo.viewController.CamionetaVC;
import co.edu.uniquindio.poo.viewController.CrudClienteVC;
import co.edu.uniquindio.poo.viewController.InicioVC;
import co.edu.uniquindio.poo.viewController.MotoVC;
import co.edu.uniquindio.poo.viewController.ReservaVC;

/**
 * JavaFX App
 */
public class App extends Application {

    Empresa empresa2;
    private Stage primaryStage;
    public static Empresa empresa = new Empresa("UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Bienvenido");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/BotonBienvenido.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            BienvenidoVC primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/Inicio.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            InicioVC clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/RegistroCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CrudClienteVC crudClienteVC = loader.getController();
            crudClienteVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCamioneta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/Camioneta.fxml"));
            Pane rootLayout = (Pane) loader.load();
            CamionetaVC camionetaVC = loader.getController();
            camionetaVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openReserva() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/Reserva.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ReservaVC reservaVc=loader.getController();
            reservaVc.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openMoto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/moto.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MotoVC motoVC=loader.getController();
            motoVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openAuto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/Auto.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AutoVC autoVC = loader.getController();
            autoVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    

    public void inicializarData(){
    }
}