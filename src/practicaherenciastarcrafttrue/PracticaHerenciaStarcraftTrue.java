package practicaherenciastarcrafttrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import objects.Protoss;
import objects.Terran;
import objects.Unidad;
import objects.Zerg;

public class PracticaHerenciaStarcraftTrue {

    static HashMap<String, Unidad> escuadrones = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Intro");
            String opcion = br.readLine();
            String[] splitOpcion = splitStringX(opcion);
            while (!splitOpcion[0].equalsIgnoreCase("s")) {
                switch (splitOpcion[0].toLowerCase()) {
                    case "c":
                        
                        break;
                    case "a":
                        altaEscuadron(splitOpcion);
                        break;
                    case "mt":
                        mostrarTodo();
                        break;

                }
                System.out.println("Intro");
                opcion = br.readLine();
                splitOpcion = splitStringX(opcion);
            }
        } catch (Exception e) {
        }
    }

    //Metodo para hace split
    public static String[] splitStringX(String algo) {
        String conversor = algo;
        String[] splitString = conversor.split(" ");
        return splitString;
    } 
    
    public static void mostrarTodo(){
        for (Map.Entry<String, Unidad> entry : escuadrones.entrySet()) {
            System.out.println(entry);
        }
    }
    
    public static void altaEscuadron(String[] n){
        String nombre = "";
        double atk = 0;
        double def = 0;
        int var1 = 0;
        int var2 = 0;
        int victorias = 0;
        try {
            switch (n[1].toLowerCase()) {
                case "terran":
                    altaTerran(n);
                    break;
                case "protoss":
                    altaProtoss(n);
                    break;
                case "zerg":
                    
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
        }
    }

    public static void altaTerran(String[] n){
        int victorias = 0;
        /*===============*/
        String nombre = n[2];
        double atk = Double.parseDouble(n[3]);
        double def = Double.parseDouble(n[4]);
        int var1 = Integer.parseInt(n[5]);
        int var2 = Integer.parseInt(n[6]);
        /*===============*/
        Terran terran = new Terran(nombre, victorias, atk, def, var1, var2);
        escuadrones.put(nombre, terran);
        System.out.println("<OK: Escuadrón registrado>");
    }
    
    public static void altaProtoss(String[] n){    
        int victorias = 0;
        /*===============*/
        String nombre = n[2];
        double atk = Double.parseDouble(n[3]);
        double def = Double.parseDouble(n[4]);
        int var1 = Integer.parseInt(n[5]);
        /*===============*/
        Protoss protos = new Protoss(nombre, victorias, atk, def, var1);
        escuadrones.put(nombre,protos);
        System.out.println("<OK: Escuadrón registrado>");
    }
    
    public static void altaZerg(String[] n){
        int victorias = 0;
        /*===============*/
        String nombre = n[2];
        double atk = Double.parseDouble(n[3]);
        double def = Double.parseDouble(n[4]);
        int var1 = Integer.parseInt(n[5]);
        int var2 = Integer.parseInt(n[6]);

        Zerg zerg = new Zerg(nombre, victorias, atk, def, var1, var2);
        escuadrones.put(nombre, zerg);
        System.out.println("<OK: Escuadrón registrado>");
    }
}
