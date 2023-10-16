package Telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class loginDAO {
    public void adicionar(cadastro1 obj) throws Exception {
        String sql = "INSERT INTO cliente(nome, sobrenome, sexo, dataNascimento, email, senha) VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = TestaConexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getnome());
            pstm.setString(6, obj.getsenha());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados " + e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao salvar dados " + e.getMessage().toLowerCase());
            }
        }
    }

    public static void main(String[] args) {
        try {
            cadastro1 cadastro = new cadastro1();
            cadastro.getnome("João");
            cadastro.setSenha("senha123");

            loginDAO dao = new loginDAO();
            dao.adicionar(cadastro);
        } catch (Exception e) {
        }
    }

    private static class cadastro1 {

        public cadastro1() {
        }

        private void getnome(String joão) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void setSenha(String senha123) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getsenha() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getnome() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
