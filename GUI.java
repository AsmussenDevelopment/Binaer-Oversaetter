package dev.asmussen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class GUI implements ActionListener {

    JFrame frame;

    JTextField field;

    JLabel label;

    JButton buttonTranslate, buttonSwap;

    String mode = "Tekst";

    GUI() {

        frame = new JFrame("Binær Oversætter");

        field = new JTextField();

        label = new JLabel(mode.toUpperCase() + ":");

        field.setEditable(true);

        buttonTranslate = new JButton("OVERSÆT");
        buttonSwap = new JButton("SKIFT");

        buttonTranslate.setBackground(Color.WHITE);
        buttonSwap.setBackground(Color.WHITE);

        field.setBounds(30, 40, 280, 30);

        buttonTranslate.setBounds(50, 100, 100, 50);
        buttonSwap.setBounds(190, 100, 100, 50);

        label.setBounds(30, -20, 100, 100);

        frame.add(field);

        frame.add(buttonTranslate);
        frame.add(buttonSwap);

        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        for (JButton buttons : Arrays.asList(buttonTranslate, buttonSwap)) {

            buttons.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonTranslate) {

            if(mode.equals("Binær")) {

                String translated = Translator.toText(field.getText());
                field.setText(translated);
                System.out.println(translated);

            } else {

                String translated = Translator.toBinary(field.getText());
                field.setText(translated);
                System.out.println(translated);
            }
        }

        if(e.getSource() == buttonSwap) {

            if(mode.equals("Binær")) {

                mode = "Tekst";
                label.setText(mode.toUpperCase() + ":");

                field.setText("");

            } else {

                mode = "Binær";
                label.setText(mode.toUpperCase() + ":");

                field.setText("");
            }
        }
    }
}
