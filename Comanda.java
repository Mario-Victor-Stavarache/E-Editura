package eeditura;
import java.io.Serializable;

class Comanda implements Serializable {
    private final Client client;
    private final CosCumparaturi cos;
    private final String tipLivrare;
    private final Object plata;

    public Comanda(Client client, CosCumparaturi cos, String tipLivrare, Object plata) {
        this.client = client;
        this.cos = cos;
        this.tipLivrare = tipLivrare;
        this.plata = plata;
    }

    public boolean proceseaza() {
        if (plata == null) return false;
        System.out.println("Comanda procesata pentru " + client);
        return true;
    }

    @Override
    public String toString() {
        return "Comanda pentru: " + client + "\nLivrare: " + tipLivrare + "\nTotal: " + cos.getTotal();
    }
}