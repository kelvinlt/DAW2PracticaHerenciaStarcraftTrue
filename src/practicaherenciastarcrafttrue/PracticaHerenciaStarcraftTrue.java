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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Comparator;

public class PracticaHerenciaStarcraftTrue {

    static HashMap<String, Unidad> escuadrones = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = "";
        try {
            System.out.println("Intro");
            opcion = br.readLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] splitOpcion = splitStringX(opcion);
        while (!splitOpcion[0].equalsIgnoreCase("s")) {
            switch (splitOpcion[0].toLowerCase()) {
                case "c":
                    try {
                        clasificacion();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "r":
                    try {
                        registrarBatalla(splitOpcion);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "a":
                    try {
                        altaEscuadron(splitOpcion);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "mt":
                    try {
                        mostrarTodo();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    try {
                        salir();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "ct":{
                    try {
                        String algo="terran1";
                        checkTerran(algo);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                default:
                    try {
                        throw new StarCraftException("<Operacion incorrecta>");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

            }
            try {
                System.out.println("Intro");
                opcion = br.readLine();
                splitOpcion = splitStringX(opcion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    //Metodo para hace split
    public static String[] splitStringX(String algo) {
        String conversor = algo;
        String[] splitString = conversor.split(" ");
        return splitString;
    }

    public static void altaEscuadron(String[] n) {
        try {
            switch (n[1].toLowerCase()) {
                case "terran":
                    if (n.length != 7) {
                        throw new StarCraftException("< ERROR 001: Nº de argumentos invalido >");
                    }
                    if(checkTerran(n[2]) == false){
                            altaTerran(n);
                    }else{
                        throw new StarCraftException("<Ya existe un terran con ese nombre>");
                    }
                    break;
                case "protoss":
                    if (n.length != 6) {
                        throw new StarCraftException("< ERROR 001: Nº de argumentos invalido >");
                    }
                    if(checkProtoss(n[2]) == false){
                            altaProtoss(n);
                    }else{
                        throw new StarCraftException("<Ya existe un protoss con ese nombre>");
                    }
                    break;
                case "zerg":
                    if (n.length != 7) {
                        throw new StarCraftException("< ERROR 001: Nº de argumentos invalido >");
                    }
                    if(checkZerg(n[2]) == false){
                        altaZerg(n);
                    }else{
                        throw new StarCraftException("<Ya existe un zerg con ese nombre>");
                    }
                    break;
                default:
                    System.out.println("< ERROR 002: Especie incorrecta >");
                    break;
            }
        } catch (StarCraftException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void altaTerran(String[] n) {
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
    
    public static boolean checkTerran(String s){
        boolean aux = false;
        
        for (Map.Entry<String, Unidad> entry : escuadrones.entrySet()) {
            if(entry.getValue() instanceof Terran){
                if(entry.getKey().equals(s)){
                    aux=true;
                }
            } 
        }
        return aux;
    }

    public static void altaProtoss(String[] n) {
        int victorias = 0;
        /*===============*/
        String nombre = n[2];
        double atk = Double.parseDouble(n[3]);
        double def = Double.parseDouble(n[4]);
        int var1 = Integer.parseInt(n[5]);
        /*===============*/
        Protoss protos = new Protoss(nombre, victorias, atk, def, var1);
        escuadrones.put(nombre, protos);
        System.out.println("<OK: Escuadrón registrado>");
    }
    
        public static boolean checkProtoss(String s){
        boolean aux = false;
        
        for (Map.Entry<String, Unidad> entry : escuadrones.entrySet()) {
            if(entry.getValue() instanceof Protoss){
                if(entry.getKey().equals(s)){
                    aux=true;
                }
            } 
        }
        return aux;
    }

    public static void altaZerg(String[] n) throws StarCraftException {
        int victorias = 0;
        /*===============*/
        String nombre = n[2];
        double atk = Double.parseDouble(n[3]);
        double def = Double.parseDouble(n[4]);
        int var1 = Integer.parseInt(n[5]);
        int var2 = Integer.parseInt(n[6]);
        /*===============*/
        Zerg zerg = new Zerg(nombre, victorias, atk, def, var1, var2);
        escuadrones.put(nombre, zerg);
        System.out.println("<OK: Escuadrón registrado>");
    }
    
    public static boolean checkZerg(String s){
        boolean aux = false;
        
        for (Map.Entry<String, Unidad> entry : escuadrones.entrySet()) {
            if(entry.getValue() instanceof Zerg){
                if(entry.getKey().equals(s)){
                    aux=true;
                }
            } 
        }
        return aux;
    }

    public static void clasificacion() {
        int contador = 0;
        ArrayList<Unidad> escuadronOrdenado = new ArrayList<Unidad>(escuadrones.values());
        Collections.sort(escuadronOrdenado, new comparatorRanking().reversed());
        for (Unidad escuadron : escuadronOrdenado) {
            if (contador < 3) {
                System.out.println(escuadron);
            }
            contador++;
        }
    }

    public static void registrarBatalla(String[] n) throws StarCraftException {

        if (n.length < 3) {
            throw new StarCraftException("<Error: numero de argumentos incorrecto>");
        } else {
            int rondaActual = 0;
            Unidad teamA = searchTeam(n[1]);
            Unidad teamB = searchTeam(n[2]);
            int asaltosA = 0;
            int asaltosB = 0;
            System.out.println("<Inicio de batalla... >");

            while (rondaActual < 5) {
                rondaActual++;
                double temp1 = randomNumber();
                double temp2 = randomNumber();
                double totalAtck1 = teamA.atkTotal() - teamB.defTotal() + temp1;
                double totalAtck2 = teamB.atkTotal() - teamA.defTotal() + temp2;
                System.out.println("Asalto nº" + rondaActual);
                System.out.println("Ataca " + teamA.getNombre() + " - Nº Aleatorio: " + temp1 + " - Valor de su ataque: " + totalAtck1);
                System.out.println("Ataca " + teamB.getNombre() + " - Nº Aleatorio: " + temp2 + " - Valor de su ataque: " + totalAtck2);
                if (totalAtck1 > totalAtck2) {
                    System.out.println("Ganador del asalto:" + teamA.getNombre());
                    asaltosA++;
                }
                if (totalAtck1 < totalAtck2) {
                    System.out.println("Ganador del asalto:" + teamB.getNombre());
                    asaltosB++;
                }
                if (totalAtck1 == totalAtck2) {
                    System.out.println("Empate de ronda");
                }
            }
            System.out.println("<Fin de batalla...>");
            if (asaltosA > asaltosB) {
                System.out.println("<OK: La batalla la ha ganado el escuadron " + teamA.getNombre() + " con " + asaltosA + " asaltos>");
                updateUnidadVictorias(teamA);
            }
            if (asaltosA < asaltosB) {
                System.out.println("<OK: La batalla la ha ganado el escuadron " + teamB.getNombre() + " con " + asaltosB + " asaltos>");
                updateUnidadVictorias(teamB);
            } else {
                System.out.println("Empate Total");
            }
        }
    }

    public static void updateUnidadVictorias(Unidad n) {
        n.setVictorias(n.getVictorias() + 1);
        escuadrones.put(n.getNombre(), n);

    }

    public static Unidad searchTeam(String n) throws StarCraftException {
        if (!escuadrones.containsKey(n)) {
            throw new StarCraftException("<Error: No se ha encontrado el equipo>");
        }

        Unidad value = escuadrones.get(n);
        return value;
    }

    public static int randomNumber() {
        int random = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        return random;
    }

    public static void salir() {
        System.exit(0);
    }

    public static void mostrarTodo() {
        for (Map.Entry<String, Unidad> entry : escuadrones.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void countLength(String[] n) {
        int count = n.length;
        System.out.println(count);
    }
}
