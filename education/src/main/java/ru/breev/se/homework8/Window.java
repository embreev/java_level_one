package ru.breev.se.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private final JTextField display = new JTextField("0", 10);

    public static float doOperation(float a, float b, String operation) {
        float c = 0;
        switch (operation) {
            case "add":
                c = a + b;
                break;
            case "subtrack":
                c = a - b;
                break;
            case "multiply":
                c = a * b;
                break;
            case "devide":
                if (b != 0) c = a / b;
                break;
            default:
                System.out.println("Command not found!");
                break;
        }
        return c;
    }

    public Window() {
        setTitle("Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panelMain = new JPanel(new GridLayout(3, 1));
        final JLabel label = new JLabel("MY CALCULATOR");
        label.setHorizontalAlignment(JLabel.CENTER);
        panelMain.add(label);

        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Dialog", Font.PLAIN, 32));
        display.setEditable(false);
        display.setBackground(Color.white);
        panelMain.add(display);

        final JPanel panelBtn = new JPanel();
        panelMain.add(panelBtn, BorderLayout.CENTER);
        final JButton[] btn = new JButton[16];
        panelBtn.setLayout(new GridLayout(4, 4));
        btn[0] = new JButton(String.valueOf(7));
        panelBtn.add(btn[0]);
        btn[1] = new JButton(String.valueOf(8));
        panelBtn.add(btn[1]);
        btn[2] = new JButton(String.valueOf(9));
        panelBtn.add(btn[2]);
        btn[3] = new JButton("+");
        panelBtn.add(btn[3]);
        btn[4] = new JButton(String.valueOf(4));
        panelBtn.add(btn[4]);
        btn[5] = new JButton(String.valueOf(5));
        panelBtn.add(btn[5]);
        btn[6] = new JButton(String.valueOf(6));
        panelBtn.add(btn[6]);
        btn[7] = new JButton("-");
        panelBtn.add(btn[7]);
        btn[8] = new JButton(String.valueOf(1));
        panelBtn.add(btn[8]);
        btn[9] = new JButton(String.valueOf(2));
        panelBtn.add(btn[9]);
        btn[10] = new JButton(String.valueOf(3));
        panelBtn.add(btn[10]);
        btn[11] = new JButton("*");
        panelBtn.add(btn[11]);
        btn[12] = new JButton(String.valueOf(0));
        panelBtn.add(btn[12]);
        btn[13] = new JButton(".");
        panelBtn.add(btn[13]);
        btn[14] = new JButton("=");
        panelBtn.add(btn[14]);
        btn[15] = new JButton("/");
        panelBtn.add(btn[15]);

        setContentPane(panelMain);

        final String valueDisplay = display.getText();
        for (int i = 0; i < btn.length; i++) {
            btn[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final String valueBtn = actionEvent.getActionCommand();
        final String valueDisplay = display.getText();
        float resultValue = 0;
        float valueInMemmory = Float.parseFloat(display.getText());

        switch (valueBtn) {
            case "+":
                final float tempFloat = Float.parseFloat(valueDisplay);
                final String operation = "add";
                resultValue = doOperation(tempFloat, valueInMemmory, operation);
                break;
        }

        display.setText(String.valueOf(resultValue));

    }
}
