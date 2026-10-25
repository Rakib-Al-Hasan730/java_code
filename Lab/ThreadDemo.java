
import javax.swing.*;

public class ThreadDemo extends JFrame {

    Thread t;
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    JLabel l = new JLabel("Thread Running");

    ThreadDemo() {
        JButton b1 = new JButton("Suspend");
        JButton b2 = new JButton("Resume");
        JButton b3 = new JButton("Stop");

        setLayout(new java.awt.FlowLayout());

        add(l);
        add(b1);
        add(b2);
        add(b3);

        t = new Thread(() -> {
            int i = 1;

            while (!stopped) {
                synchronized (this) {
                    while (suspended && !stopped) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }

                if (stopped) {
                    break;
                }

                l.setText("Count: " + i++);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
            l.setText("Thread Stopped");
        });

        b1.addActionListener(e -> suspended = true);

        b2.addActionListener(e -> {
            synchronized (this) {
                suspended = false;
                notifyAll();
            }
        });

        b3.addActionListener(e -> {
            stopped = true;
            synchronized (this) {
                suspended = false;
                notifyAll();
            }
            t.interrupt();
        });

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        t.start();
    }

    public static void main(String[] args) {
        new ThreadDemo();
    }
}
