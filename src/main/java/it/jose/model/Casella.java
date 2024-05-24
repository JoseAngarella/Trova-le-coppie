package it.jose.model;

public class Casella {
    private String parola;
    private Boolean indovinata;

    public Casella(String parola) {
        this.parola = parola;
        this.indovinata = false;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Boolean getIndovinata() {
        return indovinata;
    }

    public void setIndovinata(Boolean indovinata) {
        this.indovinata = indovinata;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((parola == null) ? 0 : parola.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Casella other = (Casella) obj;
        if (parola == null) {
            if (other.parola != null)
                return false;
        } else if (!parola.equals(other.parola))
            return false;
        return true;
    }

}
