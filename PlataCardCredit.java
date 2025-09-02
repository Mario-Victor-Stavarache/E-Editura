package eeditura;

public class PlataCardCredit implements Plata {
    private final String tipCard;
    private final String numarCard;
    private final String dataExpirare; // ex: "05/25"

    public PlataCardCredit(String tipCard, String numarCard, String dataExpirare) {
        this.tipCard = tipCard;
        this.numarCard = numarCard;
        this.dataExpirare = dataExpirare;
    }

    @Override
    public boolean verifica() {
        // Aici poți pune validările reale pentru card
        // exemplu simplificat: verificăm că numărul cardului are 16 cifre
        if (numarCard == null || numarCard.length() != 16) return false;
        if (tipCard == null || tipCard.isEmpty()) return false;
        return dataExpirare != null && dataExpirare.matches("\\d{2}/\\d{2}");
        // validare suplimentară, ex: data expirării
    }

    @Override
    public String toString() {
        return "Plata cu card " + tipCard + ", nr: " + numarCard;
    }
}
