package ru.breev.se.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    final static Operation operation = new Operation();
    final JTextField display = new JTextField("0.0", 1);

    public Window() {
        setTitle("Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panelMain = new JPanel(new GridLayout(3, 1));
//        final JSeparator separator = new JSeparator();
//        panelMain.add(separator);
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

        for (int i = 0; i < btn.length; i++) btn[i].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        display.setText(e.getActionCommand());
    }
}
