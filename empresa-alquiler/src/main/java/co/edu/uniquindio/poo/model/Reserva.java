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

   public Vehiculo getPlaca(){
      return getPlaca();
   }

   public void setVehiculo(Vehiculo vehiculo) {
      this.vehiculo = vehiculo;
   }
   public int calcularCostoTotal() {
      return vehiculo.CalcularCosto(diasAlquiler);
  }

   public Object getCosto() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCosto'");
   }

public Object getReserva() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReserva'");
}
}