
import java.awt.*;
import javax.swing.*;

public class StudentForm extends JFrame {

    StudentForm() {
        setTitle("Student Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(5, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(new JLabel("Name:"));
        p.add(new JTextField(15));

        p.add(new JLabel("ID:"));
        p.add(new JTextField(15));

        p.add(new JLabel("Department:"));
        p.add(new JTextField(15));

        p.add(new JLabel("Email:"));
        p.add(new JTextField(15));

        p.add(new JLabel(""));

        JButton b = new JButton("Submit");
        p.add(b);

        b.addActionListener(e
                -> JOptionPane.showMessageDialog(this, "Form Submitted!"));

        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
