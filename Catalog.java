package eeditura;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Catalog implements Serializable {
    private List<Carte> carti = new ArrayList<>();

    public void adaugaCarte(Carte carte) {
        carti.add(carte);
        salveazaInFisier("catalog.dat");
    }

    public List<Carte> getCarti() {
        return carti;
    }

    public void salveazaInFisier(String numeFisier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Catalog incarcaDinFisier() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catalog.dat"))) {
            return (Catalog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Catalog();
        }
    }

    @Override
    public String toString() {
        if (carti.isEmpty()) return "Catalogul este gol.\n";
        StringBuilder sb = new StringBuilder();
        for (Carte carte : carti) {
            sb.append(carte).append("\n");
        }
        return sb.toString();
    }
}
