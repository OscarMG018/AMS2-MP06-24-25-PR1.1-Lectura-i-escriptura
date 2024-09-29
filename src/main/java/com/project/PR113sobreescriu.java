package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {
        String frases = "I can only show you the door\nYou're the one that has to walk through it\n";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(camiFitxer));
            bw.write(frases);
            System.out.println("Frases afegides correctament.");
        } catch (IOException e) {
            System.out.println("Error: No s'ha pogut afegir les frases.");
            e.printStackTrace();
        }
        finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error: No s'ha pogut tancar el fitxer.");
                e.printStackTrace();
            }
        }
    }
}
