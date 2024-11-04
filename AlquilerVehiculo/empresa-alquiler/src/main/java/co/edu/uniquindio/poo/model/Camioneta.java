package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo{

    private int CapacidadCarga;
    private int TarifaBase;
    private double PORCENTAJE_EXTRA;

    public Camioneta(String placa, String marca, String modelo, int AñoFabricacion, int capacidadCarga) {
        super(placa, marca, modelo, AñoFabricacion);
        this.CapacidadCarga = capacidadCarga;
        this.TarifaBase=10000;
        this.PORCENTAJE_EXTRA=0.05;
    }

    public int getCapacidadCarga() {
        return CapacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        CapacidadCarga = capacidadCarga;
    }
    public int getTarifaBase(){
        return TarifaBase;
    }

    public void setTarifaBase(int tarifabase){
        this.TarifaBase=tarifabase;
    }

    public int CalcularCosto(int dias){
        int costo = TarifaBase * dias;
        costo += (TarifaBase * PORCENTAJE_EXTRA * CapacidadCarga) * dias;
        return costo;
    }

    @Override
    public String toString() {
        return "Camioneta" + super.toString() + "[CapacidadCarga=" + CapacidadCarga + "]";
    }
}
