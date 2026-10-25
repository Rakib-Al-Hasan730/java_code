
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {

    Calculator() {
        setTitle("Simple Calculator");
        setSize(350, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(5, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();

        p.add(new JLabel("First Number:"));
        p.add(t1);

        p.add(new JLabel("Second Number:"));
        p.add(t2);

        JButton b1 = new JButton("+");
        JButton b2 = new JButton("-");
        JButton b3 = new JButton("×");
        JButton b4 = new JButton("÷");

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);

        JLabel result = new JLabel("Result: ");
        p.add(result);
        p.add(new JLabel(""));

        b1.addActionListener(e -> {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            result.setText("Result: " + (a + b));
        });

        b2.addActionListener(e -> {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            result.setText("Result: " + (a - b));
        });

        b3.addActionListener(e -> {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            result.setText("Result: " + (a * b));
        });

        b4.addActionListener(e -> {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());

            if (b != 0) {
                result.setText("Result: " + (a / b)); 
            }else {
                result.setText("Cannot divide by zero!");
            }
        });

        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
