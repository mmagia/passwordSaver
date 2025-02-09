package fronEnd;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchFrame extends JFrame {
    private final Color backgroundColor = new Color(240, 240, 240);
    transient private String insertedMasterPassword;
    private int attempts = 3;
    transient private AppFrame appFrame;

    public LaunchFrame() {
        ImageIcon image = new ImageIcon("appLogo.png"); // creates imageIcon
        this.setTitle("My wonderful password manager!");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(backgroundColor);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
    }

    public void startExecution() {
        JLabel label = new JLabel("Enter your master password: ");
        label.setOpaque(true);
        label.setFont(new Font("Serif", Font.ITALIC, 25));
        label.setPreferredSize(new Dimension(500, 50));
        label.setForeground(Color.BLACK);
        this.add(label, BorderLayout.NORTH);
        JTextField textBox = new JTextField();
        textBox.setFont(new Font("Serif", Font.PLAIN, 25));
        textBox.setForeground(Color.BLACK);
        textBox.setBorder(new LineBorder(Color.BLACK, 4));
        textBox.setPreferredSize(new Dimension(100, 50));
        textBox.setVisible(true);
        textBox.setBackground(backgroundColor);
        textBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertedMasterPassword = textBox.getText();
                if (insertedMasterPassword.equals("223011")) {
                    LaunchFrame.this.dispose();
                    appFrame = new AppFrame();
                    appFrame.launchApp();
                } else {
                    JOptionPane.showOptionDialog(null, "You have " + attempts + " attempts left!", "", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                    attempts--;
                    if (attempts < 0) {
                        JOptionPane.showMessageDialog(null, "Hacking detected!", "", JOptionPane.ERROR_MESSAGE);
                        LaunchFrame.this.dispose();
                    }
                }
            }
        });
        this.add(textBox, BorderLayout.CENTER);
        this.setLocation(600, 375);
        this.pack();
        this.setVisible(true);
    }
}
