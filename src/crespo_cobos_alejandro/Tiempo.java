package crespo_cobos_alejandro;

/**
 * Clase tiempo.
 * @author Alejnadro Crespo Cobos
 */

public class Tiempo {

    private String nombre ;
    private int temperaturaMax;
    private int temperaturaMin;
    private String clima ;



    public Tiempo(String nombre, int temperaturaMax, int temperaturaMin, String clima) {
        this.nombre = nombre;
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMin = temperaturaMin;
        this.clima = clima;
    }

    public Tiempo() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getTemperaturaMax() {
        return this.temperaturaMax;
    }

    public void setTemperaturaMax(int temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public int getTemperaturaMin() {
        return this.temperaturaMin;
    }

    public void setTemperaturaMin(int temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public String getClima() {
        return this.clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
    
}