package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo{

    private int Puertas;
    private int TarifaBase;

    public Auto(String placa, String marca, String modelo, int AñoFabricacion, int puertas) {
        super(placa, marca, modelo, AñoFabricacion);
        this.Puertas = puertas;
        this.TarifaBase=5000;
    }

    public int getPuertas(){
        return Puertas;
    }

    public void setPuertas(int puertas){
        this.Puertas=puertas;
    }

    public int getTarifaBase(){
        return TarifaBase;
    }

    public void setTarifaBase(int tarifabase){
        this.TarifaBase=tarifabase;
    }

    public int CalcularCosto(int dias){
        int resultado= getTarifaBase()*dias;
        return resultado;
    }

    @Override
    public String toString() {
        return "Auto" + super.toString() +" [Puertas=" + Puertas + "]";
    }
}
