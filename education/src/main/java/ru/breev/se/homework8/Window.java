package ru.breev.se.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private final static Operation operation = new Operation();
    private final JTextField display = new JTextField("", 1);
    private String a = "";
    private String b = "";
    private final String OP_ADD = "+";
    private final String OP_SUB = "-";
    private final String OP_MUL = "*";
    private final String OP_DEV = "/";
    private final String OP_EQU = "=";
    private String resultValue = display.getText();
    private String command = "";

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
        btn[3] = new JButton(OP_ADD);
        panelBtn.add(btn[3]);
        btn[4] = new JButton(String.valueOf(4));
        panelBtn.add(btn[4]);
        btn[5] = new JButton(String.valueOf(5));
        panelBtn.add(btn[5]);
        btn[6] = new JButton(String.valueOf(6));
        panelBtn.add(btn[6]);
        btn[7] = new JButton(OP_SUB);
        panelBtn.add(btn[7]);
        btn[8] = new JButton(String.valueOf(1));
        panelBtn.add(btn[8]);
        btn[9] = new JButton(String.valueOf(2));
        panelBtn.add(btn[9]);
        btn[10] = new JButton(String.valueOf(3));
        panelBtn.add(btn[10]);
        btn[11] = new JButton(OP_MUL);
        panelBtn.add(btn[11]);
        btn[12] = new JButton(String.valueOf(0));
        panelBtn.add(btn[12]);
        btn[13] = new JButton(".");
        panelBtn.add(btn[13]);
        btn[14] = new JButton(OP_EQU);
        panelBtn.add(btn[14]);
        btn[15] = new JButton(OP_DEV);
        panelBtn.add(btn[15]);

        setContentPane(panelMain);

        for (JButton jb: btn) jb.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String clickBtn = e.getActionCommand();

        resultValue = (OP_EQU.equals(clickBtn)) ? "" : resultValue + clickBtn;

        if (OP_ADD.equals(clickBtn)) {
            a = display.getText();
            resultValue = "";
            command = OP_ADD;
        }
        if (OP_SUB.equals(clickBtn)) {
            a = display.getText();
            resultValue = "";
            command = OP_SUB;
        }
        if (OP_MUL.equals(clickBtn)) {
            a = display.getText();
            resultValue = "";
            command = OP_MUL;
        }
        if (OP_DEV.equals(clickBtn)) {
            a = display.getText();
            resultValue = "";
            command = OP_DEV;
        }
        if (OP_EQU.equals(clickBtn)) {
            b = display.getText();
            switch (command) {
                case OP_ADD:
                    System.out.println(operation.add(Float.parseFloat(a), Float.parseFloat(b)));
                    resultValue = String.valueOf(operation.add(Float.parseFloat(a), Float.parseFloat(b)));
                    break;
                case OP_SUB:
                    System.out.println(operation.substract(Float.parseFloat(a), Float.parseFloat(b)));
                    resultValue = String.valueOf(operation.substract(Float.parseFloat(a), Float.parseFloat(b)));
                    break;
                case OP_MUL:
                    System.out.println(operation.multiply(Float.parseFloat(a), Float.parseFloat(b)));
                    resultValue = String.valueOf(operation.multiply(Float.parseFloat(a), Float.parseFloat(b)));
                    break;
                case OP_DEV:
                    System.out.println(operation.devide(Float.parseFloat(a), Float.parseFloat(b)));
                    resultValue = String.valueOf(operation.substract(Float.parseFloat(a), Float.parseFloat(b)));
                    break;
            }
        }
        display.setText(resultValue);
    }
}
