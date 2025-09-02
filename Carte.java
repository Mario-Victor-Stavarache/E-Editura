package eeditura;
import java.io.Serializable;
import java.util.List;

class Carte implements Serializable {
    private String titlu;
    private java.util.List<String> autori;
    private int anAparitie;
    private int nrPagini;
    private double pret;
    private int durataLivrare;
    private List<String> recenzii;

    public Carte(String titlu, List<String> autori, int anAparitie, int nrPagini,
                 double pret, int durataLivrare, List<String> recenzii) {
        this.titlu = titlu;
        this.autori = autori;
        this.anAparitie = anAparitie;
        this.nrPagini = nrPagini;
        this.pret = pret;
        this.durataLivrare = durataLivrare;
        this.recenzii = recenzii;
    }

    public String getTitlu() { return titlu; }
    public java.util.List<String> getAutori() { return autori; }
    public int getAnAparitie() { return anAparitie; }
    public int getNrPagini() { return nrPagini; }
    public double getPret() { return pret; }
    public int getDurataLivrare() { return durataLivrare; }
    public java.util.List<String> getRecenzii() { return recenzii; }

    @Override
    public String toString() {
        return "Titlu: " + titlu +
                "\nAutori: " + String.join(", ", autori) +
                "\nAn apariție: " + anAparitie +
                "\nNumăr pagini: " + nrPagini +
                "\nPreț: " + pret + " lei" +
                "\nDurată livrare: " + durataLivrare + " zile" +
                "\nRecenzii: " + String.join(" | ", recenzii);
    }
}