/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

import javax.swing.JFrame;
import javax.swing.*;

public class TrikiGame
{
    public static void main(String[] args)
    {
        String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1:");
        String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 2:");

        JFrame frame = new JFrame("Triki Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TrikiPanel trikiPanel = new TrikiPanel(nombreJugador1, nombreJugador2);
        frame.getContentPane().add(trikiPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}