package eeditura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class CosCumparaturi implements Serializable {
    private final List<Carte> carti = new ArrayList<>();

    public void adaugaCarte(Carte carte) { carti.add(carte); }
    public double getTotal() { return carti.stream().mapToDouble(Carte::getPret).sum(); }
    public List<Carte> getCarti() { return carti; }
}
