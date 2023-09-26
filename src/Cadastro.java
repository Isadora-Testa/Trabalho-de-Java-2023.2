import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Cadastro extends JPanel {
    private JButton jcomp1;
    private JLabel jcomp2;
    private JTextField jcomp3;
    private JLabel jcomp4;
    private JTextField jcomp5;
    private JLabel jcomp6;
    private JRadioButton jcomp7;
    private JRadioButton jcomp8;
    private JLabel jcomp9;
    private JTextField jcomp10;
    private JLabel jcomp11;
    private JTextField jcomp12;
    private JLabel jcomp13;
    private JTextField jcomp14;
    private JLabel jcomp15;
    private JPasswordField jcomp16;
    private JLabel jcomp17;
    private JTextField jcomp18;

    public Cadastro() {
        //construct components
        jcomp1 = new JButton ("Cadastrar");
        jcomp2 = new JLabel ("Nome");
        jcomp3 = new JTextField (5);
        jcomp4 = new JLabel ("Sobrenome");
        jcomp5 = new JTextField (5);
        jcomp6 = new JLabel ("Sexo");
        jcomp7 = new JRadioButton ("Feminino");
        jcomp8 = new JRadioButton ("Masculino");
        jcomp9 = new JLabel ("Data de Nascimento");
        jcomp10 = new JTextField (5);
        jcomp11 = new JLabel ("Email");
        jcomp12 = new JTextField (5);
        jcomp13 = new JLabel ("Comfirmar Email");
        jcomp14 = new JTextField (5);
        jcomp15 = new JLabel ("Senha");
        jcomp16 = new JPasswordField (5);
        jcomp17 = new JLabel ("Confirmar Senha");
        jcomp18 = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (449, 354));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (jcomp11);
        add (jcomp12);
        add (jcomp13);
        add (jcomp14);
        add (jcomp15);
        add (jcomp16);
        add (jcomp17);
        add (jcomp18);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (165, 300, 100, 20);
        jcomp2.setBounds (20, 10, 100, 25);
        jcomp3.setBounds (20, 35, 185, 25);
        jcomp4.setBounds (230, 10, 100, 25);
        jcomp5.setBounds (230, 35, 185, 25);
        jcomp6.setBounds (20, 70, 100, 25);
        jcomp7.setBounds (15, 95, 100, 25);
        jcomp8.setBounds (120, 95, 100, 25);
        jcomp9.setBounds (230, 70, 124, 25);
        jcomp10.setBounds (230, 95, 185, 25);
        jcomp11.setBounds (20, 130, 100, 25);
        jcomp12.setBounds (20, 155, 185, 25);
        jcomp13.setBounds (230, 130, 107, 25);
        jcomp14.setBounds (230, 155, 185, 25);
        jcomp15.setBounds (20, 190, 100, 25);
        jcomp16.setBounds (20, 215, 185, 25);
        jcomp17.setBounds (230, 190, 103, 25);
        jcomp18.setBounds (230, 215, 185, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Cadastro());
        frame.pack();
        frame.setVisible (true);
    }
}
