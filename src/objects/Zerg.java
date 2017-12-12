package objects;

public class Zerg extends Unidad{
    private int esbirros;
    private int overlords;

    public Zerg() {
    }

    public Zerg(String nombre, int victorias, double ataque, double defensa,int esbirros, int overlords){
        super(nombre, victorias, ataque, defensa);
        this.esbirros = esbirros;
        this.overlords = overlords;
    }

    public int getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(int esbirros) {
        this.esbirros = esbirros;
    }

    public int getOverlords() {
        return overlords;
    }

    public void setOverlords(int overlords) {
        this.overlords = overlords;
    }
    
    @Override
    public double atkTotal() {
        return this.getAtaque() * (1+(0.15 * this.esbirros)+(0.4 * this.overlords));
    }

    @Override
    public double defTotal() {
        return this.getDefensa() * (1+(0.3*this.esbirros));
    }

    @Override
    public String toString() {
        return "Zerg{Nombre="+getNombre()+ ", Victorias="+ getVictorias()+ ", Ataque="+getAtaque()+", Defensa="+getDefensa() + "esbirros=" + esbirros + ", overlords=" + overlords + '}';
    }    
}
