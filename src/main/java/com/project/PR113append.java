package com.project;

import java.io.*;

/*Desenvolupa un programa que escrigui les següents frases en l'arxiu frasesMatrix.txt:
"I can only show you the door"
"You're the one that has to walk through it"
Requisits generals:
El fitxer frasesMatrix.txt es trobarà dins el directori data, situat a la ruta del projecte. Utilitza UTF-8 com a codificació per escriure i llegir l'arxiu.
Cada frase ha de ser escrita en una nova línia, i l'arxiu ha d'acabar amb una línia en blanc.
La ruta del fitxer es pot definir com:
String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";
Requisits específics:
PR113sobreescriu.java:
Aquesta versió sobreescriurà l'arxiu frasesMatrix.txt cada vegada que s'executi.
Escriviu les frases a l'arxiu de manera que qualsevol contingut anterior es perdi.
Recordeu afegir una línia en blanc al final de l'arxiu.
PR113append.java:
Aquesta versió afegeix les frases al final de l'arxiu frasesMatrix.txt sense esborrar el contingut anterior.
Cada execució ha d'afegir les dues frases seguides d'una línia en blanc al final del fitxer.
Comprova que el contingut existent es manté i que es van afegint correctament les noves línies.
 */

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al fitxer amb UTF-8 i línia en blanc final
    public static void afegirFrases(String camiFitxer) {
        String frases = "I can only show you the door\nYou're the one that has to walk through it\n";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(camiFitxer, true));
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
