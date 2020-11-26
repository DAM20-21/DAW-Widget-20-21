package canalo_dominguez_angel;

public class Dinosaurio {

    String nombre, significado, periodo, dieta, peligroso;
    double longitud, altura, peso;

    public Dinosaurio(String nombre, String significado, String periodo, double longitud, double altura, double peso,
            String dieta, String peligroso) {
        this.nombre = nombre;
        this.significado = significado;
        this.periodo = periodo;
        this.dieta = dieta;
        this.peligroso = peligroso;
        this.longitud = longitud;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getPeligroso() {
        return peligroso;
    }

    public void setPeligroso(String peligroso) {
        this.peligroso = peligroso;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}