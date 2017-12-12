package objects;

public abstract class Unidad {
    private String nombre;
    private int victorias;
    private double ataque;
    private double defensa;

    public abstract double atkTotal();
    public abstract double defTotal();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public Unidad() {
    }

    public Unidad(String nombre, int victorias, double ataque, double defensa) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Unidad{" + "nombre=" + nombre + ", victorias=" + victorias + ", ataque=" + ataque + ", defensa=" + defensa + '}';
    }
    
    
}
