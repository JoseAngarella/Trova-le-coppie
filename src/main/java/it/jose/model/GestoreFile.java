package it.jose.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GestoreFile {

    public static List<String> leggiFile(String nomeFile) {
        List<String> parole = new ArrayList<>();
        try {
            FileReader fr = new FileReader(nomeFile);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                parole.add(linea);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Errore Lettura File");
        }
        return parole;

    }
}
