import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountSettingsWindow extends JFrame {
    private JLabel nameLabel;
    private JLabel birthDateLabel;
    private JLabel sexLabel;
    private JLabel emailLabel;

    private JTextField nameField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;
    private JTextField sexField;
    private JTextField emailField;

    private JButton editNameButton;
    private JButton editSexButton;
    private JButton editEmailButton;

    private JButton saveButton;

    private String name;
    private String day;
    private String month;
    private String year;
    private String sex;
    private String email;

    public AccountSettingsWindow(String name, String birthDate, String sex, String email) {
        this.name = name;
        String[] dateParts = birthDate.split("/");
        if (dateParts.length == 3) {
            this.day = dateParts[0];
            this.month = dateParts[1];
            this.year = dateParts[2];
        }
        this.sex = sex;
        this.email = email;

        setTitle("Configurações da Conta");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Nome:");
        birthDateLabel = new JLabel("Data de Nascimento:");
        sexLabel = new JLabel("Sexo:");
        emailLabel = new JLabel("Email:");

        nameField = new JTextField(name);
        dayField = new JTextField(day);
        monthField = new JTextField(month);
        yearField = new JTextField(year);
        sexField = new JTextField(sex);
        emailField = new JTextField(email);

        editNameButton = new JButton("Editar Nome");
        editNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editName();
            }
        });

        editSexButton = new JButton("Editar Sexo");
        editSexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editSex();
            }
        });

        editEmailButton = new JButton("Editar Email");
        editEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editEmail();
            }
        });

        saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAccountInfo();
            }
        });

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(editNameButton);
        panel.add(birthDateLabel);
        panel.add(dayField);
        panel.add(new JLabel("/"));
        panel.add(monthField);
        panel.add(new JLabel("/"));
        panel.add(yearField);
        panel.add(sexLabel);
        panel.add(sexField);
        panel.add(editSexButton);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(editEmailButton);

        add(panel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    private void editName() {
        String newName = JOptionPane.showInputDialog(this, "Digite o novo nome:");
        if (newName != null && !newName.isEmpty()) {
            name = newName;
            nameField.setText(name);
        }
    }

    private void editSex() {
        String newSex = JOptionPane.showInputDialog(this, "Digite o novo sexo:");
        if (newSex != null && !newSex.isEmpty()) {
            sex = newSex;
            sexField.setText(sex);
        }
    }

    private void editEmail() {
        String newEmail = JOptionPane.showInputDialog(this, "Digite o novo email:");
        if (newEmail != null && !newEmail.isEmpty()) {
            email = newEmail;
            emailField.setText(email);
        }
    }

    private void saveAccountInfo() {
        // Obtém os valores dos campos de texto
        name = nameField.getText();
        day = dayField.getText();
        month = monthField.getText();
        year = yearField.getText();
        sex = sexField.getText();
        email = emailField.getText();

        // Formata a data
        String birthDate = day + "/" + month + "/" + year;

        // Exibe as informações da conta
        nameLabel.setText("Nome: " + name);
        birthDateLabel.setText("Data de Nascimento: " + birthDate);
        sexLabel.setText("Sexo: " + sex);
        emailLabel.setText("Email: " + email);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String name = "Seu Nome";
                String birthDate = "01/01/2000";
                String sex = "Masculino";
                String email = "seu@email.com";
                AccountSettingsWindow window = new AccountSettingsWindow(name, birthDate, sex, email);
                window.setVisible(true);
            }
        });
    }
}
