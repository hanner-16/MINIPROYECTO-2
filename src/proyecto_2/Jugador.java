/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

public class Jugador 
{
    private String nombre;
    private int partidas_Ganadas;
    
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        this.partidas_Ganadas = 0;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getPartidas_Ganadas()
    {
        return partidas_Ganadas;
    }
    
    public void incrementarPartidasGanadas()
    {
        partidas_Ganadas++;
    }
}
