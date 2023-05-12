/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TrikiPanel extends JPanel {
    private static final int CELDA_SIZE = 100;
    private static final int CELDA_MARGIN = 10;
    private static final int PANEL_WIDTH = 3 * (CELDA_SIZE + CELDA_MARGIN) + 2 * CELDA_MARGIN;
    private static final int PANEL_HEIGHT = 3 * (CELDA_SIZE + CELDA_MARGIN) + 2 * CELDA_MARGIN;

    private Juego juego;
    private JLabel lblJugador1;
    private JLabel lblJugador2;
    private JLabel lblMensaje;
    private JButton btnReiniciar;
    private JButton btnRegresar;

    public TrikiPanel(String nombreJugador1, String nombreJugador2) 
    {
        juego = new Juego(nombreJugador1, nombreJugador2);

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
        setLayout(null);

        lblJugador1 = new JLabel("Jugador 1: " + nombreJugador1);
        lblJugador1.setFont(new Font("Arial", Font.PLAIN, 16));
        lblJugador1.setBounds((PANEL_WIDTH - 1) / 2, CELDA_MARGIN, 150, 20);
        add(lblJugador1);

        lblJugador2 = new JLabel("Jugador 2: " + nombreJugador2);
        lblJugador2.setFont(new Font("Arial", Font.PLAIN, 16));
        lblJugador2.setBounds((PANEL_WIDTH - 150) / 2, 2 * CELDA_MARGIN + CELDA_SIZE, 150, 20);
        add(lblJugador2);

        lblMensaje = new JLabel("");
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
        lblMensaje.setBounds(CELDA_MARGIN, 3 * CELDA_MARGIN + 2 * CELDA_SIZE, PANEL_WIDTH - 2 * CELDA_MARGIN, 20);
        add(lblMensaje);

        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBounds(2 * CELDA_MARGIN + 2 * CELDA_SIZE, 3 * CELDA_MARGIN + 2 * CELDA_SIZE, 100, 30);
        btnReiniciar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                reiniciarJuego();
            }
        });
        add(btnReiniciar);

        btnRegresar = new JButton("Regresar al Menú");
        btnRegresar.setBounds(2 * CELDA_MARGIN + 2 * CELDA_SIZE, CELDA_MARGIN, 150, 30);
        btnRegresar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                regresarAlMenu();
            }
        });
        add(btnRegresar);

        MouseAdapter mouseAdapter = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int fila = (e.getY() - CELDA_MARGIN) / (CELDA_SIZE + CELDA_MARGIN);
                int columna = (e.getX() - CELDA_MARGIN) / (CELDA_SIZE + CELDA_MARGIN);

                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3)
                {
                    if (juego.hacerJugada(fila, columna)) 
                    {
                        repaint();

                        if (juego.getGanador() != null) 
                        {
                            lblMensaje.setText("¡" + juego.getGanador().getNombre() + " ha ganado!");
                            actualizarPuntajes();
                            deshabilitarTablero();
                        } 
                            else if (juego.getTurnoActual() == null)
                            {
                                lblMensaje.setText("¡Empate!");
                                actualizarPuntajes();
                                deshabilitarTablero();
                            }
                    }
                }
            }
        };
        addMouseListener(mouseAdapter);
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        int boardWidth = 3 * (CELDA_SIZE + CELDA_MARGIN);
        int boardHeight = 3 * (CELDA_SIZE + CELDA_MARGIN);
        int startX = (getWidth() - boardWidth) / 2;
        int startY = (getHeight() - boardHeight) / 2;

        for (int fila = 0; fila < 3; fila++)
        {
            for (int columna = 0; columna < 3; columna++) 
            {
                int x = startX + columna * (CELDA_SIZE + CELDA_MARGIN);
                int y = startY + fila * (CELDA_SIZE + CELDA_MARGIN);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELDA_SIZE, CELDA_SIZE);
                g.setFont(new Font("Arial", Font.BOLD, 60));
                char casilla = juego.getTablero().getCasilla(fila, columna);
                if (casilla == 'X') 
                {
                    g.drawString("X", x + 25, y + 65);
                } 
                else if (casilla == 'O')
                {
                    g.drawString("O", x + 25, y + 65);
                }
           }
        }
    }

    private void reiniciarJuego()
    {
        juego.reiniciar();
        lblMensaje.setText("");
        habilitarTablero();
        repaint();
    }

    private void actualizarPuntajes()
    {
       Jugador jugador1 = juego.getJugador1();
       Jugador jugador2 = juego.getJugador2();

       lblJugador1.setText("Jugador 1: " + jugador1.getNombre() + " (" + jugador1.getPartidasGanadas() + " victorias)");
       lblJugador2.setText("Jugador 2: " + jugador2.getNombre() + " (" + jugador2.getPartidasGanadas() + " victorias)");
    }

    private void deshabilitarTablero()
    {
        for (MouseListener listener : getMouseListeners())
        {
        removeMouseListener(listener);
        }
    }

    private void habilitarTablero()
    {
         MouseListener[] mouseListeners = getMouseListeners();
        if (mouseListeners.length == 0)
        {
           MouseListener mouseListener = new MouseAdapter()
           {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    int fila = (e.getY() - CELDA_MARGIN) / (CELDA_SIZE + CELDA_MARGIN);
                    int columna = (e.getX() - CELDA_MARGIN) / (CELDA_SIZE + CELDA_MARGIN);

                    if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3)
                    {
                        if (juego.hacerJugada(fila, columna))
                        {
                            repaint();

                            if (juego.getGanador() != null)
                            {
                                lblMensaje.setText("¡" + juego.getGanador().getNombre() + " ha ganado!");
                                actualizarPuntajes();
                                deshabilitarTablero();
                            }
                            else if (juego.getTurnoActual() == null)
                            {
                                lblMensaje.setText("¡Empate!");
                                actualizarPuntajes();
                                deshabilitarTablero();
                            }
                        }
                    }
                }
            };
            addMouseListener(mouseListener);
        }
    }
    
    private void regresarAlMenu() 
    {
        Menu menu = new Menu();
        menu.setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
}