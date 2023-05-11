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
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;


public class Menu extends JFrame implements ActionListener 
{

    private JButton startButton, instructionButton;
    private JLabel backgroundLabel, titleLabel;
    public JPanel panelI;

    public Menu() 
    {
        // Configurar la ventana
        setTitle("Triki");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Usar BorderLayout para agregar el título
        setLocationRelativeTo(null); // Centrar la ventana

        // Agregar el título centrado
        titleLabel = new JLabel("Triki");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Time New Roman", Font.BOLD, 48));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));
        add(titleLabel, BorderLayout.NORTH);

         // Cargar la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("/Imagenes/Fondo1.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        //Crear los botones
        startButton = new JButton("Iniciar juego");
        startButton.setBounds(200, 200, 200, 50);
        startButton.addActionListener(this);
        backgroundLabel.add(startButton);
        
        instructionButton = new JButton("Instrucciones");
        instructionButton.setBounds(400, 200, 200, 50);
        instructionButton.addActionListener(this);
        backgroundLabel.add(instructionButton);
        
        //Crea una mini ventana de mensaje al presionar instrucciones
        panelI = new JPanel(new GridLayout(2,1));
        panelI.setBounds(150,260,260,160);
        panelI.setOpaque(false);

        // Mostrar la ventana
         setVisible(true);
    }

    // Manejar los eventos de los botones
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == startButton)
        {
            // Iniciar el juego
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


