package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo{

    TipoCaja caja;
    private int TarifaBase;

    public enum TipoCaja{
        Automatica, Manual
    }

    public Moto(String placa, String marca, String modelo, int AñoFabricacion, TipoCaja caja) {
        super(placa, marca, modelo, AñoFabricacion);
        this.caja = caja;
        this.TarifaBase=2000;
    }
    public TipoCaja getCaja() {
    return caja;
    }

    public void setCaja(TipoCaja caja) {
        this.caja = caja;
    }

    public int getTarifaBase(){
        return TarifaBase;
    }

    public void setTarifaBase(int tarifabase){
        this.TarifaBase=tarifabase;
    }

    public int CalcularCosto(int dias){
        getCaja();
        if(getCaja() == TipoCaja.Automatica){
            int resultado= 2000+getTarifaBase();
            return resultado;
        }else{
            return getTarifaBase();
        }
    }

  @Override
    public String toString() {
        return "Moto" + super.toString() +" [caja=" + caja + "]";}


}







