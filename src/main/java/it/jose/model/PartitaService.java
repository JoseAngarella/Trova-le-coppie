package it.jose.model;

import java.util.List;

public class PartitaService {
    private static Partita p;
    private static String casellaGiaScoperta;

    public static Partita getP() {
        return p;
    }

    public static void setP(Partita p) {
        PartitaService.p = p;
    }

    public static void inizioPartita(String nomeFile) {
        setP(new Partita(new Campo()));
        CampoService.riempiCaselle(p.getC(), nomeFile);

    }

    public static String casellaScoperta(int x, int y) {
        String parola = CampoService.StringaNellaCasella(p.getC(), x, y);
        return parola;
    }

    public static boolean indovinato(int x, int y) {
        Boolean indovinato = false;
        p.setNumeroTentativi(p.getNumeroTentativi()-1);
        if (casellaGiaScoperta != null) {
            if (casellaScoperta(x, y).equals(casellaGiaScoperta)) {
                CampoService.setParolaIndovinata(p.getC() ,casellaGiaScoperta);
                indovinato = true;
            }
        }
        return indovinato;
    }

    public static String getCasellaGiaScoperta() {
        return casellaGiaScoperta;
    }

    public static void setCasellaGiaScoperta(String casellaGiaScoperta) {
        PartitaService.casellaGiaScoperta = casellaGiaScoperta;
    }

    public static List<Punto> cordinatePulsantiGiaIndovinati(){
       return CampoService.cordinatePulsantiGiaIndovinati(p.getC());

    }

    public static Boolean vittoria(){
        if(CampoService.tutteIndovinate(p.getC())){
            p.setVittoria(true);
        }
        return CampoService.tutteIndovinate(p.getC());      
    }

}
