package com.project;

import java.io.*;
import java.util.Arrays;
/*Crea una carpeta anomenada myFiles dins del directori data/pr111,
la qual es troba a la ruta del projecte. La ruta del directori serà System.getProperty("user.dir") + "/data/pr111/myFiles".

Dins d'aquesta carpeta, crea dos arxius: file1.txt i file2.txt.

Renombra l'arxiu file2.txt a renamedFile.txt.

Mostra un llistat dels arxius dins de la carpeta myFiles amb el missatge: “Els arxius de la carpeta són:”.

Elimina l'arxiu file1.txt.

Torna a mostrar un llistat dels arxius dins de la carpeta myFiles amb el missatge: “Els arxius de la carpeta són:”.
*/

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        File carpeta = new File(camiFitxer + "/myFiles");
        carpeta.mkdirs();
        File file1 = new File(carpeta, "file1.txt");
        File file2 = new File(carpeta, "file2.txt");
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear el fitxer: " + e.getMessage());
        }
        file2.renameTo(new File(carpeta, "renamedFile.txt"));
        System.out.println("Els arxius de la carpeta són: " + Arrays.toString(carpeta.list()));
        file1.delete();
        System.out.println("Els arxius de la carpeta són: " + Arrays.toString(carpeta.list()));
    }
}
