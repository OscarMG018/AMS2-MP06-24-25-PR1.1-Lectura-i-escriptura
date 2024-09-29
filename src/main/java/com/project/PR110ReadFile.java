package com.project;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
Des dins del programa, realitza les següents tasques:

Llegeix el contingut del fitxer GestioTasques.java, que es troba dins del directori data.
La ruta del fitxer serà System.getProperty("user.dir") + "/data/GestioTasques.java".

Mostra per pantalla tot el contingut del fitxer, afegint el número de línia davant de cada línia de text.

El format del número de línia serà el següent: cada línia ha d'estar precedida per un
número seguit de dos punts (:) i un espai abans del contingut de la línia. Ex.: 1: Aquesta és una línia de prova.

Si el fitxer no existeix o es produeix un error de lectura, el programa ha de gestionar
l'error i mostrar un missatge adequat, evitant que l'execució es finalitzi de manera abrupta.
 */

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
        FileReader lector = null;
        BufferedReader buffer = null;
        try {
            lector = new FileReader(camiFitxer);
            buffer = new BufferedReader(lector);
            String linea;
            int numLinea = 1;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(numLinea + ": " + linea);
                numLinea++;
            }
        } catch (IOException e) {
            System.out.println("Error al llegir el fitxer: " + e.getMessage());
        }
        finally {
            try {
                if (lector != null) {
                    lector.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException e) {
                System.out.println("Error al tancar el fitxer: " + e.getMessage());
            }
        }
    }
}
