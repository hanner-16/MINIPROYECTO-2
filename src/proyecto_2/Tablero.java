/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

public class Tablero {
    private char[][] casillas;

    public Tablero() {
        casillas = new char[3][3];
        vaciarTablero();
    }

    public void vaciarTablero() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                casillas[fila][columna] = ' ';
            }
        }
    }

    public char getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public boolean esCasillaVacia(int fila, int columna) {
        return casillas[fila][columna] == ' ';
    }

    public void marcarCasilla(int fila, int columna, char marca) {
        casillas[fila][columna] = marca;
    }

    public boolean estaLleno() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (esCasillaVacia(fila, columna)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hayGanador(char marca) {
        // Comprobar filas
        for (int fila = 0; fila < 3; fila++) {
            if (casillas[fila][0] == marca && casillas[fila][1] == marca && casillas[fila][2] == marca) {
                return true;
            }
        }

        // Comprobar columnas
        for (int columna = 0; columna < 3; columna++) {
            if (casillas[0][columna] == marca && casillas[1][columna] == marca && casillas[2][columna] == marca) {
                return true;
            }
        }

        // Comprobar diagonales
        if (casillas[0][0] == marca && casillas[1][1] == marca && casillas[2][2] == marca) {
            return true;
        }
        if (casillas[0][2] == marca && casillas[1][1] == marca && casillas[2][0] == marca) {
            return true;
        }

        return false;
    }
}