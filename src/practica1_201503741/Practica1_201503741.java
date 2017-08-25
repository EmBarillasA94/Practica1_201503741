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
public class Practica1_201503741 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int n=0;
        System.out.println("            EDDY ALEJANDRO MURGA BARILLAS");
        System.out.println("                     201503741");
        System.out.println("                 IPC A Practica 1");
        System.out.println("                   BUSCAMINAS!!!!");
        Scanner enter = new Scanner(System.in);
        String presionar= enter.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("                   BUSCAMINAS!!!                  ");
        System.out.println("                 1. Principiante                  ");
        System.out.println("                 2. Intermedio                    ");
        System.out.println("                 3. Experto                       ");
        System.out.println("                 4. Salir                         ");
        System.out.println("Ingrese Opcion: ");
        Scanner p1Option= new Scanner(System.in);
        int op = p1Option.nextInt();
        System.out.println("--------------------------------------------------");
        
        switch(op){
            case 1:
                n=4;
                new Jugar_201503741().crear(n);
                break;
            case 2:
                n=6;
                new Jugar_201503741().crear(n);
                break;
            case 3:
                n=8;
                new Jugar_201503741().crear(n);
                break;
            case 4:
                break;
        }
    }
    
}
