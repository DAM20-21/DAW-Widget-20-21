package crespo_cobos_alejandro;

public class Tiempo {

    //private String [] nombre = {"Tornavacas", "jerte","Cabezuela del valle","Navaconcejo","Rebollar","Las Casa del Castañar","El Torno","El Cabrero","Piornal" };
    private int temperaturaMax;
    private int temperaturaMin;
    private String [] clima = {"Soleado", "NUblado", "Lluvioso", "Nieve", "Nubes y claros"};


    public Tiempo( int temperaturaMax, int temperaturaMin, String[] clima) {
        
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMin = temperaturaMin;
        this.clima = clima;
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

    public String[] getClima() {
        return this.clima;
    }

    public void setClima(String[] clima) {
        this.clima = clima;
    }
    
}