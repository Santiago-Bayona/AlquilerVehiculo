package co.edu.uniquindio.poo.model;

public class Reserva{

   private int diasAlquiler;
   private String codigo;
   private Vehiculo vehiculo;
   
   public Reserva(int diasAlquiler, String codigo,Vehiculo vehiculo){
    this.diasAlquiler=diasAlquiler;
    this.codigo=codigo;
    this.vehiculo=vehiculo;
   }

   public int getDiasAlquiler() {
      return diasAlquiler;
   }

   public void setDiasAlquiler(int diasAlquiler) {
      this.diasAlquiler = diasAlquiler;
   }

   public String getCodigo() {
      return codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public Vehiculo getVehiculo() {
      return vehiculo;
   }

   public void setVehiculo(Vehiculo vehiculo) {
      this.vehiculo = vehiculo;
   }
   public int calcularCostoTotal() {
      // Aquí se utiliza polimorfismo. Llamamos al método de cálculo de costo del vehículo
      return vehiculo.CalcularCosto(diasAlquiler);
  }
}