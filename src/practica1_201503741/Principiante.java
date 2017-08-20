/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201503741;

import java.util.Scanner;

/**
 *
 * @author Eddy Alejandro
 */
public class Principiante {

    public Principiante() {
    }

    public void crear() {
        int n=4;
        char[][] matriz1;
        matriz1 = new char[n][n];
        char[][] matriz2;
        matriz2 = new char[4][4];

        //imprimiendo matriz del juego
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz1[i][j] = 'X';
            }
        }
        //imprimiendo
        System.out.println("--------------------------------------------------");
        System.out.println("              NIVEL PRINCIPIANTE");
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println("");
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("|" + matriz1[i][j] + "|");
            }
        }
        System.out.println("");
        System.out.println("               -------------------");
        System.out.println("                  Voltear: V");
        System.out.println("                  Reiniciar: R");
        System.out.println("                  Salir: S");
        System.out.println("                Ingrese Opciton:");
        //ingresando option para jugar
        Scanner Joption = new Scanner(System.in);
        String letra;
        letra = Joption.nextLine();

        Option(letra);
    }
    
    void Option(String letra){
        switch (letra) {
            case "V":
                System.out.println("voltear");
            case "R":
                crear();
                break;
            case "S":
                System.out.println("salir");
                break;
        }
    }

}
