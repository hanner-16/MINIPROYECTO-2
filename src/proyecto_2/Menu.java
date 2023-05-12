/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private JButton startButton, instructionButton;
    private JLabel titleLabel;
    private JLabel backgroundLabel;
    public JPanel panelI;

    public Menu() {
        // Configurar la ventana
        setTitle("Triki");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Usar BorderLayout para agregar el título
        setLocationRelativeTo(null); // Centrar la ventana

        // Cargar la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("src/imagenes/Fondo.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImage);
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // Agregar el título sin borde
        titleLabel = new JLabel("Triki");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.decode("#572364")); // Cambiar el color a verde neón
        titleLabel.setBounds(-150, 0, 800, 100);
        titleLabel.setBorder(null); // Quitar el borde
        backgroundLabel.add(titleLabel);

        //Crear los botones
        ImageIcon startImageIcon = new ImageIcon("src/imagenes/inicio.png");
        startButton = new JButton(startImageIcon);
        startButton.setBounds(150, 200, 200, 50);
        startButton.addActionListener(this);
        backgroundLabel.add(startButton);

        ImageIcon instructionImageIcon = new ImageIcon("src/imagenes/instrucciones.png");
        instructionButton = new JButton(instructionImageIcon);
        instructionButton.setBounds(150, 300, 200, 50);
        instructionButton.addActionListener(this);
        backgroundLabel.add(instructionButton);

        //Crea una mini ventana de mensaje al presionar instrucciones
        panelI = new JPanel(new GridLayout(2, 1));
        panelI.setBounds(150, 260, 260, 160);
        panelI.setOpaque(false);

        // Mostrar la ventana
        pack();
        setVisible(true);
    }

    // Manejar los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1:");
            String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 2:");

            JFrame frame = new JFrame("Triki Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            TrikiPanel trikiPanel = new TrikiPanel(nombreJugador1, nombreJugador2);
            frame.getContentPane().add(trikiPanel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            dispose(); // Cerrar la ventana del menú
        } 
        else if (e.getSource() == instructionButton) 
        {
            JOptionPane.showMessageDialog(panelI, "El Triki es un juego que se plantea en una cuadrícula 3x3. Los jugadores colocan sus símbolos en turnos con el objetivo de hacer una línea de tres. Si lo logran, ganan; de lo contrario pierden.");
        }
    }

    public static void main(String[] args)
    {
        new Menu();
    }
}