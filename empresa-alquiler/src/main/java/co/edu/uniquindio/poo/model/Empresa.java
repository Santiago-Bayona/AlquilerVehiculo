package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    public Collection<Vehiculo>vehiculos;
    public Collection<Cliente>clientes;
    public Collection<Reserva>reservas;
    public Collection<Camioneta>camionetas;

    public Empresa(String nombre){
        this.nombre=nombre;
        this.clientes=new LinkedList<>();
        this.reservas=new LinkedList<>();
        this.vehiculos=new LinkedList<>();
        this.camionetas=new LinkedList<>();
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

    public Collection<Camioneta> getCamionetas() {
        return camionetas;
    }

    public void setCamionetas(Collection<Camioneta> camioneta) {
        this.camionetas = camioneta;
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

    public boolean verfificarCamioneta(String placa) {
        for (Camioneta camioneta : camionetas) {
            if (placa.equals(camioneta.getPlaca())) {
                return false;
            }
        }
        return true;
    }

    public boolean agregarCamioneta(Camioneta  camioneta){
        boolean centinela = false;
        if(verfificarCamioneta(camioneta.getPlaca())){
            camionetas.add(camioneta);
            centinela=true;
        }
        return centinela;
    }

    public boolean eliminarCamioneta(String placa) {
        boolean centinela = false;
        for (Camioneta camioneta : camionetas) {
            if (camioneta.getPlaca().equals(placa)) {
                camionetas.remove(camioneta);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCamioneta(String placa, Camioneta actualizado) {
        boolean centinela = false;
        for (Camioneta camioneta : camionetas) {
            if (camioneta.getPlaca().equals(placa)) {
                camioneta.setPlaca(actualizado.getPlaca());
                camioneta.setModelo(actualizado.getModelo());
                camioneta.setAñoFabricacion(actualizado.getAñoFabricacion());
                camioneta.setCapacidadCarga(actualizado.getCapacidadCarga());
                camioneta.setMarca(actualizado.getMarca());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cedula.equals(cliente.getCedula())) {
                return false;
            }
        }
        return true;
    }

    public boolean agregarCliente(Cliente  cliente){
        
        boolean centinela = false;
        if(verificarCliente(cliente.getCedula())){
            clientes.add(cliente);
            centinela=true;
        }
        return centinela;
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
