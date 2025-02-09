package fronEnd;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener {
//    private JButton deleteButton = new JButton("clear all passwords");
    private JButton addButton;
    private JTextField login;
    private JTextField password;
    private final ImageIcon icon = new ImageIcon("malinki.jpg");
    private String enteredLogin;
    private String enteredPassword;

    public AppFrame() {
        Color backgroundColor = new Color(240, 240, 240);
        ImageIcon image = new ImageIcon("appLogo.png"); // creates imageIcon
        this.setTitle("My wonderful password manager!"); // sets title of this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(750, 750); // sets the x,y dimensions
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(backgroundColor); // change color of background
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void launchApp() {
        this.setLayout(null);
        JLabel sakura = new JLabel(icon);
        sakura.setBounds(0, 0, 750, 200);
        sakura.setOpaque(true);
        this.add(sakura);


        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 200, 175, 100);
        panel1.setLayout(null);
        panel1.setBackground(Color.green);
        JLabel enterLogin = new JLabel("Enter Login:");
        JLabel enterPassword = new JLabel("Enter Password:");
        enterLogin.setBounds(0, 0, 175, 50);
        enterPassword.setBounds(0, 50, 175, 50);
        enterLogin.setFont(new Font("Arial", Font.BOLD, 20));
        enterPassword.setFont(new Font("Arial", Font.BOLD, 20));
        panel1.add(enterPassword);
        panel1.add(enterLogin);

        this.add(panel1);


        JPanel panel2 = new JPanel();
        addButton = new JButton("add");
        addButton.setBounds(400, 0, 175, 100);
        addButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        addButton.setForeground(Color.RED);
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        panel2.setBounds(175, 200, 575, 100);
        panel2.setLayout(null);
        panel2.setBackground(Color.red);
        login = new JTextField();
        password = new JTextField();
        login.setBounds(0, 0, 400, 50);
        enterPassword.setBorder(new LineBorder(Color.BLACK, 4));
        enterLogin.setBorder(new LineBorder(Color.BLACK, 4));
        login.setBorder(new LineBorder(Color.BLACK, 4));
        password.setBorder(new LineBorder(Color.BLACK, 4));
        password.setBounds(0, 50, 400, 50);
        panel2.add(login);
        panel2.add(password);
        panel2.add(addButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AppFrame().launchApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            enteredLogin = login.getText();
            enteredPassword = password.getText();
            System.out.println(enteredLogin + " " + enteredPassword);
        }
    }
}
