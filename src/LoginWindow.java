import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class LoginWindow extends JPanel {
    private JButton loginButton;
    private JButton registerButton;
    private JButton forgotPasswordButton;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;

    public LoginWindow() {
        // Construct components
        loginButton = new JButton("Login");
        registerButton = new JButton("Cadastrar");
        forgotPasswordButton = new JButton("Recuperar senha");
        usernameLabel = new JLabel("Usuário");
        usernameField = new JTextField(5);
        passwordLabel = new JLabel("Senha");
        passwordField = new JPasswordField(5);

        // Adjust size and set layout
        setPreferredSize(new Dimension(292, 354));
        setLayout(null);
        setBackground(new Color(107, 237, 125)); // RGB para verde claro


        // Add components
        add(loginButton);
        add(registerButton);
        add(forgotPasswordButton);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);

        // Set component bounds (only needed by Absolute Positioning)
        loginButton.setBounds(25, 235, 100, 25);
        registerButton.setBounds(165, 235, 100, 24);
        forgotPasswordButton.setBounds(75, 275, 140, 25);
        usernameLabel.setBounds(30, 60, 100, 25);
        usernameField.setBounds(115, 60, 130, 25);
        passwordLabel.setBounds(30, 105, 100, 25);
        passwordField.setBounds(115, 105, 130, 25);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LoginWindow());
        frame.pack();
        frame.setVisible(true);
    }
}
