package practicaherenciastarcrafttrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import objects.Protoss;
import objects.Terran;
import objects.Unidad;
import objects.Zerg;
import Exception.StarCraftException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
                    case "r":
                        
                        break;
                    case "a":
                        altaEscuadron(splitOpcion);
                        break;
                    case "mt":
                        mostrarTodo();
                        break;
                    case "s":
                        salir();
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
        try {
            switch (n[1].toLowerCase()) {
                case "terran":
                    if(n.length!=7){
                        throw new StarCraftException("< ERROR 001: Nº de argumentos invalido >");
                    }
                    altaTerran(n);
                    break;
                case "protoss":
                    if(n.length!=6){
                        throw new StarCraftException("< ERROR 001: Nº de argumentos invalido >");
                    }
                    altaProtoss(n);
                    break;
                case "zerg":
                    if(n.length!=7){
                        throw new StarCraftException("< ERROR 001: Nº de argumentos invalido >");
                    }
                    altaZerg(n);
                    break;  
                default:
                    System.out.println("< ERROR 002: Especie incorrecta >");
                    break;
            }
        } catch (StarCraftException ex) {
            System.out.println(ex.getMessage());
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
    
    public static void altaZerg(String[] n) throws StarCraftException{
        int victorias = 0;
        /*===============*/
        String nombre = n[2];
        double atk = Double.parseDouble(n[3]);
        double def = Double.parseDouble(n[4]);
        int var1 = Integer.parseInt(n[5]);
        if(var1<0){
        }else{
            throw new StarCraftException("<>");
        }
        int var2 = Integer.parseInt(n[6]);
        /*===============*/
        Zerg zerg = new Zerg(nombre, victorias, atk, def, var1, var2);
        escuadrones.put(nombre, zerg);
        System.out.println("<OK: Escuadrón registrado>");
    }
    
    public static void countLength(String[] n){
        int count = n.length;
        System.out.println(count);
    }
    
    public static void clasificacion(){
        
        
    }
    
    public static void registrarBatalla(String n){
       
        
    }
    
    public static int randomNumber(){
        int random = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        return random;
    }
    
    public static void salir(){
        System.exit(0);
    }
}
