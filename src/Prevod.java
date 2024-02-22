import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Prevod extends JFrame implements ActionListener, FocusListener{
    private JTextField textovePole;
    private JComboBox comboBox;
    private JButton button;
    private JLabel label;

    public Prevod() {
        init();
        JPanel okno = new JPanel();
        okno.setPreferredSize(new Dimension(500, 350));
        okno.setLayout(new GridLayout(4, 1));

        textovePole = new JTextField("Tu zadaj text");
        textovePole.addFocusListener(this);
        okno.add(textovePole);

        String[] moznosti = {"Na veľké písmená", "Na malé písmená", "Odstrániť biele znaky", "Invertovať poradie písmen"};
        comboBox = new JComboBox(moznosti);
        comboBox.setBackground(new Color(224,224,224));
        okno.add(comboBox);

        button = new JButton("Prevod");
        button.setBackground(new Color(192,192,192));
        button.addActionListener(this);
        okno.add(button);

        label = new JLabel("Výsledný text");
        okno.add(label);

        add(okno);
        pack();     //prisposobenie rozmerov komponent
    }

    public void init() {
        setTitle("Prevodovník");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String vstup = textovePole.getText();
        String vybranaMoznost = (String) comboBox.getSelectedItem();
        String vysledok = "";

        switch (vybranaMoznost) {
            case "Na veľké písmená":
                vysledok = vstup.toUpperCase();
                break;
            case "Na malé písmená":
                vysledok = vstup.toLowerCase();
                break;
            case "Odstrániť biele znaky":
                vysledok = vstup.replaceAll("\\s+", "");
                break;
            case "Invertovať poradie písmen":
                vysledok = new StringBuilder(vstup).reverse().toString();
                break;
        }
        label.setText(vysledok);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(textovePole.getText().equals("Tu zadaj text")){
            textovePole.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
