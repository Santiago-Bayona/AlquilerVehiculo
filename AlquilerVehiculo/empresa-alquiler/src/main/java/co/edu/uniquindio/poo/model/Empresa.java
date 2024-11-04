package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    public Collection<Vehiculo>vehiculos;
    public Collection<Cliente>clientes;
    public Collection<Reserva>reservas;

    public Empresa(String nombre){
        this.nombre=nombre;
        this.clientes=new LinkedList<>();
        this.reservas=new LinkedList<>();
        this.vehiculos=new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean verificarVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (placa.equals(vehiculo.getPlaca())) {
                return false;
            }
        }
        return true;
    }

    public void agregarVehiculo(Vehiculo  vehiculo){
        if(verificarVehiculo(vehiculo.getPlaca())){
            vehiculos.add(vehiculo);
        }
    }

    public boolean eliminarVehiculo(String placa) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculos.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    // Start Cliente

    public boolean verificarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cedula.equals(cliente.getCedula())) {
                return false;
            }
        }
        return true;
    }

    public void agregarCliente(Cliente  cliente){
        if(verificarCliente(cliente.getCedula())){
            clientes.add(cliente);
        }
    }
    
    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setnombre(actualizado.getnombre());
                cliente.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // End Cliente

    public boolean verificarReserva(String codigo) {
        for (Reserva reserva : reservas) {
            if (codigo.equals(reserva.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    public void agregarReserva(Reserva  reserva){
        if(verificarReserva(reserva.getCodigo())){
            reservas.add(reserva);
        }
    }
    
    public boolean eliminarreserva(String codigo) {
        boolean centinela = false;
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                reservas.remove(reserva);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
}
