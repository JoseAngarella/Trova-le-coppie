package it.jose.model;

public class Campo {
    private Casella[][] caselle = new Casella[4][4]; // 4*4

    public Campo() {

    }

    public Casella[][] getCaselle() {
        return caselle;
    }

    public void setCaselle(Casella[][] caselle) {
        this.caselle = caselle;
    }

}
