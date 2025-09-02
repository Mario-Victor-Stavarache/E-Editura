package eeditura;

import javax.swing.*;
import java.awt.*;

public class CosFrame extends JFrame {
    public CosFrame() {
        setTitle("Cos de cumparaturi");
        setSize(500, 300);
        setLocationRelativeTo(null);

        JTextArea taCos = new JTextArea();
        taCos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taCos);
        add(scrollPane, BorderLayout.CENTER);

        CosCumparaturi cos = new CosCumparaturi();

        StringBuilder sb = new StringBuilder("Carti in cos:\n\n");
        for (Carte c : cos.getCarti()) {
            sb.append(c).append("\n\n");
        }
        sb.append("Total: ").append(cos.getTotal()).append(" RON");

        taCos.setText(sb.toString());
    }
}
