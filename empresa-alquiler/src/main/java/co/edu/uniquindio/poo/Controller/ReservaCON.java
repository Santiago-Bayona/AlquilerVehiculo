package co.edu.uniquindio.poo.Controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;

public class ReservaCON {
    Empresa empresa;
    Reserva reserva;

    public ReservaCON(Empresa empresa,Reserva reserva){
        this.empresa=empresa;
        this.reserva=reserva;
    }

    public boolean crearReserva(Reserva reserva){
        return empresa.agregarReserva(reserva);
    }

    public Collection<Reserva> obetenerListaReserva() {
        return empresa.getReservas();
    }

    public boolean eliminarreserva(String codigo) {
       return empresa.eliminarreserva(codigo);
    }

    public boolean ActualizarReserrva(String codigo, Reserva reserva) {
       return empresa.ActualizarReserva(codigo, reserva);
    }
}
