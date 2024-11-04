package co.edu.uniquindio.poo.Controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;

public class CamionetaCON {

    Empresa empresa;

    public CamionetaCON(Empresa empresa){
        this.empresa=empresa;
    }

    public boolean crearCamioneta(Camioneta camioneta){
        return empresa.agregarCamioneta(camioneta);
    }

    public Collection<Camioneta> obtenerLisCamionetas() {
        return empresa.getCamionetas();
    }

    public boolean eliminarCamioneta(String placa) {
       return empresa.eliminarCamioneta(placa);
    }

    public boolean actualizarCamioneta(String placa, Camioneta camioneta) {
       return empresa.actualizarCamioneta(placa, camioneta);
    }
    
}
