package com.project;

import java.io.*;

/*El programa haurà d'acceptar com a entrada la ruta d'un arxiu de text com
a argument a l'hora d'executar-lo. La ruta del fitxer es passarà com a paràmetre en executar el programa.
Si la ruta proporcionada correspon a un fitxer de text:
Llegeix el contingut del fitxer en codificació UTF-8.
Mostra el contingut del fitxer per pantalla.
Si la ruta proporcionada correspon a una carpeta, mostra el missatge:
"El path no correspon a un arxiu, sinó a una carpeta.".
Si la ruta proporcionada no correspon a un fitxer existent o es produeix
qualsevol altre error, mostra el missatge: "El fitxer no existeix o no és accessible.".
Nota: Gestiona adequadament possibles errors de lectura del fitxer i assegura
que el programa no falli de manera abrupta. Assegura't que el contingut dels fitxers es llegeix amb la codificació UTF-8.
 */

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        File file = new File(rutaArxiu);
        if (!file.exists()) {
            System.out.println("El fitxer no existeix o no és accessible.");
            return;
        }
        if (file.isDirectory()) {
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
            return;
        }
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
        }



    }
}
