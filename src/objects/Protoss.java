package objects;

public class Protoss extends Unidad{
   private int pilones;

    public Protoss() {
    }

    public Protoss(String nombre, int victorias, double ataque, double defensa,int pilones) {
        super(nombre, victorias, ataque, defensa);
        this.pilones = pilones;
    }

    public int getPilones() {
        return pilones;
    }

    public void setPilones(int pilones) {
        this.pilones = pilones;
    }
   
   
   
    @Override
    public double atkTotal() {
        return this.getAtaque() * (1+(0.5*this.pilones));
    }

    @Override
    public double defTotal() {
        return this.getDefensa()* (1+(0.5*this.pilones));
    }

    @Override
    public String toString() {
        return "Protoss{Nombre="+getNombre()+ ", Victorias="+ getVictorias()+ ", Ataque="+getAtaque()+", Defensa="+getDefensa()+ "pilones=" + pilones + '}';
    }
   
   
}
