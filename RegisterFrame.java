package eeditura;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

class RegisterFrame extends JFrame {
    private static final String USERS_FILE = "utilizatori.dat";

    public RegisterFrame() {
        setTitle("Inregistrare - E-Editura");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNume = new JLabel("Nume:");
        JTextField tfNume = new JTextField();
        JLabel lblPrenume = new JLabel("Prenume:");
        JTextField tfPrenume = new JTextField();
        JLabel lblAdresa = new JLabel("Adresa:");
        JTextField tfAdresa = new JTextField();
        JLabel lblUser = new JLabel("Username:");
        JTextField tfUser = new JTextField();
        JLabel lblPass = new JLabel("Parola:");
        JPasswordField tfPass = new JPasswordField();

        JButton btnRegister = new JButton("Inregistreaza");
        JButton btnCancel = new JButton("Anuleaza");

        panel.add(lblNume); panel.add(tfNume);
        panel.add(lblPrenume); panel.add(tfPrenume);
        panel.add(lblAdresa); panel.add(tfAdresa);
        panel.add(lblUser); panel.add(tfUser);
        panel.add(lblPass); panel.add(tfPass);
        panel.add(btnRegister); panel.add(btnCancel);

        add(panel);

        btnCancel.addActionListener(e -> dispose());

        btnRegister.addActionListener(e -> {
            String nume = tfNume.getText().trim();
            String prenume = tfPrenume.getText().trim();
            String adresa = tfAdresa.getText().trim();
            String user = tfUser.getText().trim();
            String pass = new String(tfPass.getPassword()).trim();

            if (nume.isEmpty() || prenume.isEmpty() || adresa.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Toate campurile sunt obligatorii!");
                return;
            }

            HashMap<String, Client> utilizatori = incarcaUtilizatori();

            if (utilizatori.containsKey(user)) {
                JOptionPane.showMessageDialog(this, "Username deja folosit!");
                return;
            }

            // Creez clientul cu 6 parametri (trebuie sa modifici clasa Client sa aiba acest constructor)
            Client client = new Client(nume, prenume, adresa);
            utilizatori.put(user, client);

            if (salveazaUtilizatori(utilizatori)) {
                JOptionPane.showMessageDialog(this, "Cont inregistrat cu succes!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Eroare la salvare!");
            }
        });
    }

    private HashMap<String, Client> incarcaUtilizatori() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            return (HashMap<String, Client>) in.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    private boolean salveazaUtilizatori(HashMap<String, Client> utilizatori) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            out.writeObject(utilizatori);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
