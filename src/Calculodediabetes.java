import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import javax.swing.text.MaskFormatter;

public class Calculodediabetes extends JFrame {
    private XYSeries glucoseSeries;
    private XYSeriesCollection dataset;
    private JFreeChart chart;
    private JFormattedTextField dateField; // Campo formatado para data
    private JComboBox<String> timeComboBox;
    private DefaultTableModel tableModel;
    private JTextField glucoseField;
    private JButton deleteButton;
    private JTable table;

    public Calculodediabetes() {
        setTitle("Calculo de Glicose");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        glucoseSeries = new XYSeries("Glicose");
        dataset = new XYSeriesCollection(glucoseSeries);

        chart = ChartFactory.createXYLineChart(
                "Gráfico de Glicose", "Data", "Nível de Glicose",
                dataset, PlotOrientation.VERTICAL, true, true, false
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);
        plot.setAxisOffset(new RectangleInsets(10.0, 10.0, 10.0, 10.0));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));

        String[] columnNames = {"Data", "Nível de Glicose", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 1 ? Double.class : super.getColumnClass(columnIndex);
            }
        };
        table = new JTable(tableModel);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 2) {
                    String status = (String) tableModel.getValueAt(row, 2);
                    if ("Diabetes".equals(status)) {
                        c.setBackground(new Color(255, 204, 204)); // Vermelho claro
                    } else if ("Pré-Diabetes".equals(status)) {
                        c.setBackground(new Color(255, 255, 204)); // Amarelo claro
                    } else {
                        c.setBackground(new Color(204, 255, 204)); // Verde claro
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
            e.printStackTrace();
        }

        glucoseField = new JTextField(10);

        JButton measureButton = new JButton("Calcular Glicose");
        measureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                measureGlucose();
            }
        });

        deleteButton = new JButton("Deletar Linha");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
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

    private void measureGlucose() {
        try {
            double glucoseLevel = Double.parseDouble(glucoseField.getText());
            String selectedDate = dateField.getText();

            String status = calcularStatusDiabetes(glucoseLevel);

            glucoseSeries.add(Double.parseDouble(selectedDate.replace("/", "")), glucoseLevel);
            Object[] rowData = {selectedDate, glucoseLevel, status};
            tableModel.addRow(rowData);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nível de glicose inválido. Por favor, insira um número válido.");
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

    private String calcularStatusDiabetes(double glucoseLevel) {
        if (glucoseLevel < 110) {
            return "Normal";
        } else if (glucoseLevel >= 110 && glucoseLevel <= 125) {
            return "Pré-Diabetes";
        } else {
            return "Diabetes";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculodediabetes app = new Calculodediabetes();
                app.setVisible(true);
            }
        });
    }
}
