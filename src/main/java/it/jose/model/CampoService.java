package it.jose.model;

import java.util.ArrayList;
import java.util.List;

public class CampoService {

    public static void riempiCaselle(Campo c, String nomeFile) {
        List<String> parole = getParole(nomeFile);
        int y, x;
        for (int i = 0; i < parole.size(); i++) {
            for (int k = 0; k < 2; k++) {
                x = RandomReturn.getRandomInt(3);
                y = RandomReturn.getRandomInt(3);
                if (c.getCaselle()[x][y] == null) {
                    c.getCaselle()[x][y] = new Casella(parole.get(i));
                } else {
                    k--;
                }
            }

        }

    }

    public static Boolean tutteIndovinate(Campo c){
        Boolean risultato=true;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(!c.getCaselle()[i][j].getIndovinata()){
                    risultato=false;
                    break;
                }
            }
        }
        return risultato;

    }

    public static List<Punto> cordinatePulsantiGiaIndovinati(Campo c){
        List<Punto> p= new ArrayList<>();
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(c.getCaselle()[i][j].getIndovinata()){
                    p.add(new Punto(i, j));
                }
            }
        }
        return p;


    }

    public static void setParolaIndovinata(Campo c, String parola) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (c.getCaselle()[i][j].getParola() == parola) {
                    c.getCaselle()[i][j].setIndovinata(true);

                }
            }
        }
    }

    public static String StringaNellaCasella(Campo c, int x, int y) {
        String s = c.getCaselle()[x][y].getParola();
        return s;
    }

    public static List<String> getParole(String nomeFile) {
        return GestoreFile.leggiFile(nomeFile);

    }

}
