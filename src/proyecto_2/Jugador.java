/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2;

/**
 * @author Hanner Fernando Sinisterra <hanner.sinisterra@correounivalle.edu.co>
 * @author Daniel Esteban Gallego Velasco <gallego.daniel@correounivalle.edu.co>
 */

public class Jugador {
    private String nombre;
    private int partidasGanadas;
    private char marca;

    public Jugador(String nombre, char marca) {
        this.nombre = nombre;
        this.partidasGanadas = 0;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public char getMarca() {
        return marca;
    }

    public void incrementarPartidasGanadas() {
        partidasGanadas++;
    }
}
