package co.edu.uniquindio.poo.Controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import java.util.Collection;

public class ClienteCon {

    Empresa empresa;

    public ClienteCon(Empresa empresa) {
        this.empresa = empresa;
    }


    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }

    public boolean eliminarCliente(String cedula) {
       return empresa.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
       return empresa.actualizarCliente(cedula, cliente);
    }

    
}
