package eeditura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Client implements Serializable {
    private final String nume;
    private final String prenume;
    private final String adresa;
    private String username;
    private String parola;
    private String rol;
    private final List<Carte> cosCumparaturi = new ArrayList<Carte>();

    public Client(String nume, String prenume, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
    }

    public String getUsername() { return username; }
    public String getParola() { return parola; }
    public String getRol() { return rol; }
    public void setUsername(String username) { this.username = username; }
    public void setParola(String parola) { this.parola = parola; }
    public void setRol(String rol) { this.rol = rol; }
    public java.util.List<Carte> getCosCumparaturi() { return cosCumparaturi; }
    public void adaugaInCos(Carte carte) { cosCumparaturi.add(carte); }

    @Override
    public String toString() {
        return nume + " " + prenume + ", " + adresa + " (" + rol + ")";
    }
}