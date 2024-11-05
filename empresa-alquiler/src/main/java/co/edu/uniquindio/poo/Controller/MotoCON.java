package co.edu.uniquindio.poo.Controller;
import java.util.Collection;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Empresa;

public class MotoCON {
      
    Empresa empresa; 
      
    public MotoCON(Empresa empresa){
        this.empresa=empresa;
    }

    public boolean crearmoto(Moto moto) {
        return empresa.agregarMoto(moto);
        
    }

    public Collection<Moto> obtenerLisMotos() {
        return empresa.getMotos();
    }

    public boolean eliminarmoto(String placa) {
       return empresa.eliminarmoto(placa);
    }

    public boolean Actualizarmoto(String placa, Moto moto) {
       return empresa.actualizarmoto(placa, moto);
    }
    
}
