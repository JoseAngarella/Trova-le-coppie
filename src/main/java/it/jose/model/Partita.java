package it.jose.model;

public class Partita {
    private Campo c;
    private int numeroTentativi;
    private Boolean Vittoria;

    public Partita(Campo c) {
        this.c = c;
        numeroTentativi=20;
        Vittoria=false;
    }

    

    
    public Campo getC() {
        return c;
    }

    public void setC(Campo c) {
        this.c = c;
    }



    public int getNumeroTentativi() {
        return numeroTentativi;
    }



    public void setNumeroTentativi(int numeroTentativi) {
        this.numeroTentativi = numeroTentativi;
    }




    public Boolean getVittoria() {
        return Vittoria;
    }




    public void setVittoria(Boolean vittoria) {
        Vittoria = vittoria;
    }

    

    
}
