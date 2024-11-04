package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {

    private String placa,marca,modelo;
    private int AñoFabricacion;

    public Vehiculo(String placa, String marca, String modelo, int AñoFabricacion){
        this.placa=placa;
        this.marca=marca;
        this.modelo=modelo;
        this.AñoFabricacion=AñoFabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return AñoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.AñoFabricacion = añoFabricacion;
    }

    public abstract int CalcularCosto(int dias);

    

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", AñoFabricacion="
                + AñoFabricacion + "]";
    }
}
