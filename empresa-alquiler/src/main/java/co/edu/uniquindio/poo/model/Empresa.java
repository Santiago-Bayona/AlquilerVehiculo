package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    public Collection<Vehiculo>vehiculos;
    public Collection<Cliente>clientes;
    public Collection<Reserva>reservas;
    public Collection<Camioneta>camionetas;
    public Collection<Moto>motos;
    public Collection<Auto>autos;

    public Empresa(String nombre){
        this.nombre=nombre;
        this.clientes=new LinkedList<>();
        this.reservas=new LinkedList<>();
        this.vehiculos=new LinkedList<>();
        this.camionetas=new LinkedList<>();
        this.motos=new LinkedList<>();
        this.autos=new LinkedList<>();

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

    public Collection<Moto> getMotos() {
        return motos;
    }

    public void setAutos(Collection<Auto> autos) {
        this.autos = autos;
    }

    public Collection<Auto> getAutos() {
        return autos;
    }

    public void setMotos(Collection<Moto> motos) {
        this.motos = motos;
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

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setnombre(actualizado.getnombre());
                cliente.setApellido(actualizado.getApellido());
                cliente.setCedula(actualizado.getCedula());
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

    public boolean agregarReserva(Reserva  reserva){
        boolean centinela=false;
        if(verificarReserva(reserva.getCodigo())){
            reservas.add(reserva);
            centinela=true;
        }
        return centinela;
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

    public boolean ActualizarReserva(String codigo, Reserva actualizado) {
        boolean centinela = false;
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                reserva.setCodigo(actualizado.getCodigo());
                reserva.setDiasAlquiler(actualizado.getDiasAlquiler());
                reserva.setVehiculo(actualizado.getVehiculo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

public boolean verficarMoto(String placa) {
    for (Moto moto : motos) {
        if (placa.equals(moto.getPlaca())) {
            return false;
        }
    }
    return true;
}

public boolean agregarMoto(Moto moto) {
    boolean centinela = false;
    if(verficarMoto(moto.getPlaca())){
        motos.add(moto);
        centinela=true;
    }
    return centinela;
}

public boolean eliminarmoto(String placa) {
    boolean centinela = false;
    for (Moto moto : motos) {
        if (moto.getPlaca().equals(placa)) {
            motos.remove(moto);
            centinela = true;
            break;
        }
    }
    return centinela;
}

public boolean actualizarmoto(String placa, Moto actualizado) {
    boolean centinela = false;
    for (Moto moto : motos) {
        if (moto.getPlaca().equals(placa)) {
            moto.setPlaca(actualizado.getPlaca());
            moto.setModelo(actualizado.getModelo());
            moto.setAñoFabricacion(actualizado.getAñoFabricacion());
            moto.setTarifaBase(actualizado.getTarifaBase());
            moto.setMarca(actualizado.getMarca());
            centinela = true;
            break;
        }
    }
    return centinela;
}
public boolean verfificarAuto (String placa) {
    for (Auto auto : autos) {
        if (placa.equals(auto.getPlaca())) {
            return false;
        }
    }
    return true;
}

public boolean agregarAuto(Auto auto){
    boolean centinela = false;
    if(verfificarAuto(auto.getPlaca())){
        autos.add(auto);
        centinela=true;
    }
    return centinela;
}

public boolean eliminarAuto(String placa) {
    boolean centinela = false;
    for (Auto auto : autos) {
        if (auto.getPlaca().equals(placa)) {
            autos.remove(auto);
            centinela = true;
            break;
        }
    }
    return centinela;
}

public boolean actualizarAuto(String placa, Auto actualizado) {
    boolean centinela = false;
    for (Auto auto : autos) {
        if (auto.getPlaca().equals(placa)) {
            auto.setPlaca(actualizado.getPlaca());
            auto.setModelo(actualizado.getModelo());
            auto.setAñoFabricacion(actualizado.getAñoFabricacion());
            auto.setPuertas(actualizado.getPuertas());
            auto.setMarca(actualizado.getMarca());
            centinela = true;
            break;
        }
    }
    return centinela;
}
}
