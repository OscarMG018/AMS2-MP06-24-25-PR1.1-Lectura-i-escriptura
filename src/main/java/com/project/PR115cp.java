package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
L'usuari haurà de passar dues rutes com a arguments:
El primer argument serà la ruta de l'arxiu origen que es vol copiar.
El segon argument serà la ruta de destinació on es vol guardar la còpia.
Funcionalitat:
Verificació de l'existència del fitxer:
El programa ha de comprovar si el fitxer d'origen existeix i si és un fitxer de text.
Còpia del contingut:
El contingut del fitxer origen es copiarà línia a línia a l'arxiu de destinació.
Codificació UTF-8:
Totes les operacions de lectura i escriptura han de fer-se amb codificació UTF-8.
Línia en blanc final:
Si el fitxer d'origen acaba amb una línia en blanc, s'ha de copiar tal com està, afegint també la línia en blanc al fitxer de destinació.
Advertències:
Si l'arxiu de destinació ja existeix, el programa ha de mostrar un missatge d'advertència indicant que l'arxiu serà sobreescrit.
Comportament final:
El programa ha de mostrar un missatge indicant que la còpia s'ha realitzat correctament, o un missatge d'error si la còpia falla.
 */

public class PR115cp {

    public static void main(String[] args) {
        /*if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];*/

        String rutaOrigen = System.getProperty("user.dir") + "/data/numeros.txt";
        String rutaDesti = System.getProperty("user.dir") + "/data/numeros_copia.txt";

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        File origen = new File(rutaOrigen);
        File desti = new File(rutaDesti);
        if (!origen.exists()) {
            System.out.println("Error: L'arxiu d'origen no existeix.");
            return;
        }
        if (!origen.isFile()) {
            System.out.println("Error: L'arxiu d'origen no és un fitxer.");
            return;
        }
        if (desti.exists()) {
            System.out.println("Atenció: L'arxiu de destí ja existeix.");
            while (true) {
                System.out.println("Vols sobreescriure l'arxiu? (s/n)");
                Scanner scanner = new Scanner(System.in);
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    break;
                } else if (resposta.equalsIgnoreCase("n")) {
                    scanner.close();
                    System.out.println("Còpia cancelada per l'usuari.");
                    return;
                } else {
                    System.out.println("Resposta no vàlida. Torna a intentar.");
                }
                scanner.close();
            }
        }

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(origen), StandardCharsets.UTF_8));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desti), StandardCharsets.UTF_8));
            int charapter;
            while ((charapter = br.read()) != -1) {
                bw.write(charapter);
            }
            System.out.println("Còpia realitzada correctament.");
        } catch (IOException e) {
            System.out.println("Error: No s'ha pogut copiar l'arxiu.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error: No s'ha pogut tancar l'arxiu.");
                e.printStackTrace();
            }
        }

    }
}
