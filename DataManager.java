package eeditura;
import java.awt.*;
import java.io.*;

class DataManager {
    private static List lista;
    private static String numeFisier;

    public static <T> void salvareLista(List lista, String numeFisier) {
        DataManager.lista = lista;
        DataManager.numeFisier = numeFisier;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List incarcareLista(String numeFisier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(numeFisier))) {
            return (List) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new List();
        }
    }
}