package eeditura;

public class main {
    public static void main(String[] args) {
        Catalog catalog = Catalog.incarcaDinFisier();

        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginFrame(catalog).setVisible(true);
        });
    }
}
