package co.edu.uniquindio.poo.model;

public class appi {

        public static void main(String[] args) {
            // Crear una instancia de Empresa
            Empresa empresa = new Empresa("Alquiler de Vehículos XYZ");
    
            // Crear vehículos de diferentes tipos
            Auto auto = new Auto("ABC123", "Toyota", "Corolla", 2020, 4);
            Moto moto = new Moto("XYZ789", "Yamaha", "MT-07", 2019, Moto.TipoCaja.Automatica); 
            Camioneta camioneta = new Camioneta("LMN456", "Ford", "F-150", 2021, 150);
    
            // Agregar vehículos a la empresa
            empresa.agregarVehiculo(auto);
            empresa.agregarVehiculo(moto);
            empresa.agregarVehiculo(camioneta);
    
            // Crear clientes
            Cliente cliente1 = new Cliente("Juan Pérez",18, "12345");
            Cliente cliente2 = new Cliente("María López",35, "67890");

            Reserva reserva1 =new Reserva(10,"1204",camioneta);
    
            // Agregar clientes a la empresa
            empresa.agregarCliente(cliente1);
            empresa.agregarCliente(cliente2);

            
            System.out.println(moto.CalcularCosto(10));
    
            // Crear reservas usando polimorfismo
            empresa.agregarReserva(reserva1);

            
            System.out.println(reserva1.calcularCostoTotal());
    
            // Mostrar las reservas y el costo total
            
        }
    }

