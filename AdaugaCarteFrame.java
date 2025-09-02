package eeditura;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AdaugaCarteFrame extends JFrame {
    public AdaugaCarteFrame(Catalog catalog) {
        setTitle("Adaugă carte nouă");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitlu = new JTextField();
        JTextField tfAutori = new JTextField();
        JTextField tfAn = new JTextField();
        JTextField tfPagini = new JTextField();
        JTextField tfPret = new JTextField();
        JTextField tfLivrare = new JTextField();
        JTextField tfRecenzii = new JTextField();

        JButton btnAdauga = new JButton("Adaugă carte");

        panel.add(new JLabel("Titlu:")); panel.add(tfTitlu);
        panel.add(new JLabel("Autori (virgulă):")); panel.add(tfAutori);
        panel.add(new JLabel("An apariție:")); panel.add(tfAn);
        panel.add(new JLabel("Număr pagini:")); panel.add(tfPagini);
        panel.add(new JLabel("Preț:")); panel.add(tfPret);
        panel.add(new JLabel("Durată livrare (zile):")); panel.add(tfLivrare);
        panel.add(new JLabel("Recenzii (virgulă):")); panel.add(tfRecenzii);
        panel.add(new JLabel("")); panel.add(btnAdauga);

        add(panel);

        btnAdauga.addActionListener(e -> {
            try {
                String titlu = tfTitlu.getText().trim();
                java.util.List<String> autori = Arrays.asList(tfAutori.getText().trim().split("\\s*,\\s*"));
                int an = Integer.parseInt(tfAn.getText().trim());
                int pagini = Integer.parseInt(tfPagini.getText().trim());
                double pret = Double.parseDouble(tfPret.getText().trim());
                int livrare = Integer.parseInt(tfLivrare.getText().trim());

                List<String> recenzii = new ArrayList<>();
                if (!tfRecenzii.getText().trim().isEmpty()) {
                    recenzii = Arrays.asList(tfRecenzii.getText().trim().split("\\s*,\\s*"));
                }

                Carte carte = new Carte(titlu, autori, an, pagini, pret, livrare, recenzii);
                catalog.adaugaCarte(carte);

                JOptionPane.showMessageDialog(this, "Cartea a fost adăugată cu succes!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Eroare: Verifică toate câmpurile!", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}