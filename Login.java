package Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

// Inicializa os componentes da interface.
    public Login() {
        initComponents();
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
   // Método que inicializa os componentes da interface
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        entrar = new javax.swing.JButton();
        Cadastrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Senha");

        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        senha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        entrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        Cadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/logo-color (1).png"))); // NOI18N

        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea1.setRows(2);
        jTextArea1.setTabSize(2);
        jTextArea1.setText("MedLink é uma ferramenta poderosa para ajudar\n diabéticos, pré-diabéticos e pessoas em risco \nde diabetes a gerenciar sua saúde de forma mais \neficaz, fornecendo monitoramento em tempo\n real e informações relevantes sobre seus níveis \nde glicose no sangue.");
        jTextArea1.setBorder(null);
        jTextArea1.setPreferredSize(new java.awt.Dimension(100, 100));
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addComponent(email)
                                        .addComponent(senha)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(entrar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                            .addComponent(Cadastrar)))))))
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entrar)
                            .addComponent(Cadastrar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        // Abra a tela de cadastro (substitua "Cadastro" pelo nome correto da classe de cadastro)
        Cadastro telaCadastro = new Cadastro();
        telaCadastro.setVisible(true);
        this.dispose(); // Feche a tela de login, se desejar
    }//GEN-LAST:event_CadastrarActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // Obtém o email e senha digitados pelo usuário
        String emailUsuario = email.getText();
        String senhaUsuario = new String(senha.getPassword());

        // Chama o método de verificação de credenciais
        if (!verificarCredenciais(emailUsuario, senhaUsuario)) {
            // Credenciais inválidas, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Email ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        } else {
            // As credenciais são válidas, você pode fazer login ou realizar outras ações necessárias
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");

            // Obtém o ID do usuário a partir do banco de dados
            int userId = getUserIdFromDatabase(emailUsuario);

            if (userId != -1) { // Verifica se o ID do usuário é válido
                // Cria uma instância da tela de cálculo de diabetes e passa o ID do usuário
                DiabetesCalculo telaCalculo = new DiabetesCalculo(userId);
                telaCalculo.setVisible(true);

            } else {
                // Exibe uma mensagem de erro se o ID do usuário não for válido
                JOptionPane.showMessageDialog(this, "Erro ao obter o ID do usuário.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
        }
        }

        // Método para verificar as credenciais no banco de dados
        private boolean verificarCredenciais(String email, String senha) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/medlink";
                String user = "root";
                String dbPassword = "";

                try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                    String sql = "SELECT * FROM cadastro WHERE email = ? AND senha = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, email);
                    pstmt.setString(2, senha);

                    ResultSet rs = pstmt.executeQuery();

                    // Se houver correspondência no banco de dados, as credenciais são válidas
                    return rs.next();
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Erro durante a verificação de credenciais: " + e.getMessage());
                return false;
            }
    }//GEN-LAST:event_entrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JTextField email;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables

   // Método para obter o ID do usuário a partir do banco de dados
    private int getUserIdFromDatabase(String emailUsuario) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/medlink";
            String user = "root";
            String dbPassword = "";

            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String sql = "SELECT id FROM cadastro WHERE email = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, emailUsuario);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao obter o ID do usuário: " + e.getMessage());
        }
        return -1; // Retorna um valor negativo para indicar que não foi encontrado nenhum ID válido.
    }


    private static class Calculo {

        public Calculo(int userId) {
        }

        private int setVisible(boolean par) {
            return 0;
            }

    }
}

