/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

public class Juego {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turnoActual;
    private Jugador ganador;

    public Juego(String nombreJugador1, String nombreJugador2) {
        tablero = new Tablero();
        jugador1 = new Jugador(nombreJugador1, 'X');
        jugador2 = new Jugador(nombreJugador2, 'O');
        turnoActual = jugador1;
        ganador = null;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public boolean hacerJugada(int fila, int columna) 
    {
        if (tablero.esCasillaVacia(fila, columna) && ganador == null) 
        {
            tablero.marcarCasilla(fila, columna, turnoActual.getMarca());
            if (tablero.hayGanador(turnoActual.getMarca()))
            {
                ganador = turnoActual;
                turnoActual.incrementarPartidasGanadas();
                return true;
            } 
            else if (tablero.estaLleno())
            {
                turnoActual = null; // Empate
                return true;
            }
            cambiarTurno();
            return true;
        }
        return false;
    }

    public void reiniciar() 
    {
        tablero.vaciarTablero();
        turnoActual = jugador1;
        ganador = null;
    }

    private void cambiarTurno()
    {
        if (turnoActual == jugador1)
        {
            turnoActual = jugador2;
        } 
        else
        {
            turnoActual = jugador1;
        }
    }
}