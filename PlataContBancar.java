package eeditura;

public class PlataContBancar implements Plata {
    private final String banca;
    private final String numarCont;

    public PlataContBancar(String banca, String numarCont) {
        this.banca = banca;
        this.numarCont = numarCont;
    }

    @Override
    public boolean verifica() {
        // Validare simplă
        if (banca == null || banca.isEmpty()) return false;
        return numarCont != null && !numarCont.isEmpty();
    }

    @Override
    public String toString() {
        return "Plata prin cont bancar la banca " + banca;
    }
}
