package eeditura;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlasareComandaFrame extends JFrame {
    public PlasareComandaFrame(Client client, Catalog catalog, CosCumparaturi cos) {
        setTitle("Plasare Comanda");
        setSize(500, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Selectie carte
        JLabel lblCarte = new JLabel("Selecteaza carte:");
        List<Carte> carti = catalog.getCarti();
        String[] titluri = carti.stream().map(Carte::getTitlu).toArray(String[]::new);
        JComboBox<String> cbCarti = new JComboBox<>(titluri);
        JButton btnAdaugaInCos = new JButton("Adauga in cos");
        JLabel lblTotal = new JLabel("Total curent: " + cos.getTotal() + " RON");

        JLabel lblLivrare = new JLabel("Tip livrare:");
        String[] optiuniLivrare = {"Posta obisnuita", "Posta rapida (24h)"};
        JComboBox<String> cbLivrare = new JComboBox<>(optiuniLivrare);

        JLabel lblTipPlata = new JLabel("Tip plata:");
        String[] tipuriPlata = {"Card de credit", "Cont bancar"};
        JComboBox<String> cbTipPlata = new JComboBox<>(tipuriPlata);

        JLabel lbl1 = new JLabel("Detaliu 1:");
        JTextField tf1 = new JTextField();
        JLabel lbl2 = new JLabel("Detaliu 2:");
        JTextField tf2 = new JTextField();
        JLabel lbl3 = new JLabel("Detaliu 3:");
        JTextField tf3 = new JTextField();

        JButton btnPlaseaza = new JButton("Plaseaza comanda");

        panel.add(lblCarte); panel.add(cbCarti);
        panel.add(new JLabel()); panel.add(btnAdaugaInCos);
        panel.add(new JLabel()); panel.add(lblTotal);
        panel.add(lblLivrare); panel.add(cbLivrare);
        panel.add(lblTipPlata); panel.add(cbTipPlata);
        panel.add(lbl1); panel.add(tf1);
        panel.add(lbl2); panel.add(tf2);
        panel.add(lbl3); panel.add(tf3);
        panel.add(new JLabel()); panel.add(btnPlaseaza);

        add(panel);

        btnAdaugaInCos.addActionListener(e -> {
            int idx = cbCarti.getSelectedIndex();
            if (idx >= 0 && idx < carti.size()) {
                cos.adaugaCarte(carti.get(idx));
                lblTotal.setText("Total curent: " + cos.getTotal() + " RON");
                JOptionPane.showMessageDialog(this, "Carte adaugata in cos.");
            } else {
                JOptionPane.showMessageDialog(this, "Selectati o carte valida!");
            }
        });

        cbTipPlata.addActionListener(e -> {
            String tip = (String) cbTipPlata.getSelectedItem();
            if ("Card de credit".equals(tip)) {
                lbl1.setText("Tip card:");
                lbl2.setText("Numar card:");
                lbl3.setText("Data expirare (MM/YY):");
                tf3.setEditable(true);
            } else {
                lbl1.setText("Banca:");
                lbl2.setText("Numar cont:");
                lbl3.setText("");
                tf3.setText("");
                tf3.setEditable(false);
            }
        });

        btnPlaseaza.addActionListener(e -> {
            String tipLivrare = (String) cbLivrare.getSelectedItem();
            String tipPlata = (String) cbTipPlata.getSelectedItem();

            Plata plata = null;

            if ("Card de credit".equals(tipPlata)) {
                plata = new PlataCardCredit(tf1.getText(), tf2.getText(), tf3.getText());
            } else if ("Cont bancar".equals(tipPlata)) {
                plata = new PlataContBancar(tf1.getText(), tf2.getText());
            }

            if (plata == null) {
                JOptionPane.showMessageDialog(this, "Selectati o metoda valida de plata!");
                return;
            }

            Comanda comanda = new Comanda(client, cos, tipLivrare, plata);
            if (comanda.proceseaza()) {
                JOptionPane.showMessageDialog(this, "Comanda a fost procesata cu succes!\n" + comanda);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Eroare la procesarea platii.");
            }
        });
    }
}
