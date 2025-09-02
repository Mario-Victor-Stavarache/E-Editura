package eeditura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Catalog catalog;
    private final CosCumparaturi cos;

    public MainFrame(Client client, Catalog catalog) {
        this.cos = new CosCumparaturi();
        this.catalog = catalog;

        setTitle("E-Editura - Bine ai venit, " + client.getUsername());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnVizualizareCatalog = new JButton("Vizualizeaza Catalog");
        JButton btnPlaseazaComanda = new JButton("Plaseaza Comanda");
        JButton btnLogout = new JButton("Logout");

        panel.add(btnVizualizareCatalog);
        panel.add(btnPlaseazaComanda);

        if ("admin".equals(client.getRol())) {
            JButton btnAdaugaCarte = new JButton("Adauga Carte in Catalog");
            btnAdaugaCarte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AdaugaCarteFrame(catalog).setVisible(true);
                }
            });
            panel.add(btnAdaugaCarte);
        }

        panel.add(btnLogout);

        add(panel);

        btnVizualizareCatalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, catalog.toString());
            }
        });

        btnPlaseazaComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlasareComandaFrame(client, catalog, cos).setVisible(true);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame(catalog).setVisible(true);
            }
        });
    }

    public void adaugaCarteInCos(Carte carte) {
        cos.adaugaCarte(carte);
    }
}
