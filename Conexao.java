package Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/medlink";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(URL, USER, PASS);
        return conexao;
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("Conexão fechada com sucesso");
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) throws SQLException {
        closeConnection(conn);
        if (stmt != null) {
            stmt.close();
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) throws SQLException {
        closeConnection(conn, stmt);
        if (rs != null) {
            rs.close();
        }
    }

    public static void main(String[] args) {
        try {
            // Estabelece uma conexão com o banco de dados
            Connection conexao = getConnection();
            System.out.println("Conexão obtida com sucesso");

            // Execute suas operações de banco de dados aqui

            // Fecha a conexão com o banco de dados quando terminar
            closeConnection(conexao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
