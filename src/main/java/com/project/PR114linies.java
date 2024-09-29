package com.project;

import java.io.*;
import java.util.Random;

/*El fitxer es guardarà dins del directori data, situat a la ruta del projecte
(String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";)

El programa ha de generar exactament 10 números aleatoris, cada un en una línia separada.

Utilitza la codificació UTF-8 per escriure els números en el fitxer.

Cada número ha de ser un valor enter aleatori generat entre 0 i 99 (ambdós inclosos).

Assegura't que cada número estigui separat per un salt de línia.

En aquest cas, després del darrer número no hi ha un salt de línia.*/

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        File file = new File(camiFitxer);
        PrintWriter pw = null;
        BufferedWriter bw = null;
        try {
            pw = new PrintWriter(file, "UTF-8");
            bw = new BufferedWriter(pw);
            for (int i = 0; i < 10; i++) {
                int numeroAleatori = new Random().nextInt(100);
                bw.write(String.valueOf(numeroAleatori));
                if (i < 9) {
                    bw.newLine();
                }
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
