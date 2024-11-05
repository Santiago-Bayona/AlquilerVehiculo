package co.edu.uniquindio.poo.Controller;


import java.util.Collection;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Empresa;

public class AutoController {

    Empresa empresa;

    public AutoController(Empresa empresa){
        this.empresa=empresa;
    }

    public boolean crearAuto(Auto auto){
        return empresa.agregarAuto(auto);
    }

    public Collection<Auto> obtenerListaAutos() {
        return empresa.getAutos();
    }

    public boolean eliminarAuto(String placa) {
       return empresa.eliminarAuto(placa);
    }

    public boolean actualizarAuto(String placa, Auto auto) {
       return empresa.actualizarAuto(placa, auto);
    }
    
}