/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

public class Tablero 
{
    private char[][] casillas;
    private int movimientos;
    
    public Tablero()
    {
        casillas = new char[3][3];
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; i <3; j++)
            {
                casillas[i][j] = ' ';
            }
        }
        movimientos = 0;
    }
    
    public boolean estaLleno()
    {
        return movimientos == 9;
    }
    
    public boolean haGanado(char jugador)
    {
        for (int i = 0; i < 3; i++) {
            if (casillas[i][0] == jugador && casillas[i][1] == jugador && casillas[i][2] == jugador)
            {
                return true;
            }
            
            if (casillas[0][i] == jugador && casillas[1][i] == jugador && casillas[2][i] == jugador) 
            {
                return true;
            }
        }
        if (casillas[0][0] == jugador && casillas[1][1] == jugador && casillas[2][2] == jugador)
        {
            return true;
        }
        
        else if (casillas[0][2] == jugador && casillas[1][1] == jugador && casillas[2][0] == jugador) 
        {
            return true;
        }
        
        return false;
    }
    
    public boolean hacerJugada(char jugador, int fila, int columna)
    {
        if(casillas[fila][columna] != ' ')
        {
            return false;
        }
        
        casillas[fila][columna] = jugador;
        movimientos++;
        return true;
    }
    
    public void reiniciar()
    {
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; i <3; j++)
            {
                casillas[i][j] = ' ';
            }
        }
        movimientos = 0;
    }
    
    public char getCasillas(int fila, int columna)
    {
        return casillas[fila][columna];
    }
}
