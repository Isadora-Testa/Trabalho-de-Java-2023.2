package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import javax.swing.text.MaskFormatter;

public class DiabetesCalculo extends JFrame {
    private XYSeries glucoseSeries;
    private XYSeriesCollection dataset;
    private JFreeChart chart;
    private JFormattedTextField dateField;
    private DefaultTableModel tableModel;
    private final JTextField glucoseField;
    private final JButton deleteButton;
    private JTable table;
    private XYPlot plot;

    public DiabetesCalculo(int userId) {
        setTitle("Calculo de Glicose");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
         // Inicializa a série de dados para o gráfico
        glucoseSeries = new XYSeries("Glicose");
        dataset = new XYSeriesCollection(glucoseSeries);
        
        // Cria um gráfico de linha com o título e rótulos adequados
        chart = ChartFactory.createXYLineChart(
                "Gráfico de Glicose", "Data", "Nível de Glicose",
                dataset, PlotOrientation.VERTICAL, true, true, false
        );
        
        // Configuração do gráfico
        plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);
        plot.setAxisOffset(new RectangleInsets(10.0, 10.0, 10.0, 10.0));

        // Cria um painel para o gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        
        // Configuração da tabela de dados
        String[] columnNames = {"Data", "Nível de Glicose", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 1 ? Double.class : super.getColumnClass(columnIndex);
            }
        };
        table = new JTable(tableModel);

        // Define um renderizador personalizado para a coluna "Status" da tabela
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 2) {
                    String status = (String) tableModel.getValueAt(row, 2);
                    if (null == status) {
                        c.setBackground(new Color(204, 255, 204)); // Verde claro
                    } else {
                        switch (status) {
                            case "Diabetes":
                                c.setBackground(new Color(255, 204, 204)); // Vermelho claro
                                break;
                            case "Pré-Diabetes":
                                c.setBackground(new Color(255, 255, 204)); // Amarelo claro
                                break;
                            default:
                                c.setBackground(new Color(204, 255, 204)); // Verde claro
                                break;
                        }
                    }
                } else {
                    c.setBackground(table.getBackground());
                }

                return c;
            }
        };

        table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);

        JScrollPane tableScrollPane = new JScrollPane(table);

        // Use um MaskFormatter para formatar a data
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateField = new JFormattedTextField(dateFormatter);
        } catch (java.text.ParseException e) {
        }

        glucoseField = new JTextField(10);

        JButton measureButton = new JButton("Calcular Glicose");
        measureButton.addActionListener((ActionEvent e) -> {
            measureGlucose(userId); // Pass userId here
        });

        deleteButton = new JButton("Deletar Linha");
        deleteButton.addActionListener((ActionEvent e) -> {
            deleteSelectedRow();
        });

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Nivel de Glicose:"));
        inputPanel.add(glucoseField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(measureButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(chartPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);
    }

    private void measureGlucose(int userId) {
    try {
        double glucoseLevel = Double.parseDouble(glucoseField.getText());
        String selectedDate = dateField.getText();

        String status = calcularStatusDiabetes(glucoseLevel);

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date date = inputFormat.parse(selectedDate);
        String formattedDate = outputFormat.format(date);

        glucoseSeries.add(date.getTime(), glucoseLevel);
        Object[] rowData = {selectedDate, glucoseLevel, status};
        tableModel.addRow(rowData);

        inserirDadosNoBanco(formattedDate, glucoseLevel, status, userId);

        XYTextAnnotation annotation = new XYTextAnnotation(status, date.getTime(), glucoseLevel);
        annotation.setFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.addAnnotation(annotation);
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Nível de glicose inválido. Insira um número válido.");
    }
}



    private String calcularStatusDiabetes(double glucoseLevel) {
        if (glucoseLevel < 110) {
            return "Normal";
        } else if (glucoseLevel >= 110 && glucoseLevel <= 125) {
            return "Pré-Diabetes";
        } else {
            return "Diabetes";
        }
    }


    private void inserirDadosNoBanco(String selectedDate, double glucoseLevel, String status, int userId) {
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
        // Substitua estas informações de conexão pelo seu banco de dados
        String url = "jdbc:mysql://localhost:3306/medlink";
        String user = "root";
        String password = "";

        conn = DriverManager.getConnection(url, user, password);

        String query = "INSERT INTO medicao (id, data, medicao, status) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(query);

        // Não é necessário converter a data aqui, pois já está no formato certo
        stmt.setInt(1, userId); // Associe a medição ao usuário pelo usuario_id
        stmt.setString(2, selectedDate); // Use o formato "yyyy-MM-dd" diretamente
        stmt.setDouble(3, glucoseLevel);
        stmt.setString(4, status);

        stmt.executeUpdate();
    } catch (SQLException e) {
        // Lida com erros de banco de dados aqui

    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }
}

    private void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            glucoseSeries.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir.");
        }
    }

    public static void main(String[] args) {
        int yourUserIdHere = 0;
        // Replace 'yourUserIdHere' with the actual user ID you want to pass
        int userId = yourUserIdHere;
        SwingUtilities.invokeLater(() -> {
            DiabetesCalculo app = new DiabetesCalculo(userId);
            app.setVisible(true);
        });
    }
}
