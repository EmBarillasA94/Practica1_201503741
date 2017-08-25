/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201503741;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Eddy Alejandro
 */
public class Jugar_201503741 {

    public Jugar_201503741() {
    }
    int inicial = 0;
    String[][] matriz1;
    String[][] matriz2;
    int randomX;
    int randomY;
    int x;
    int y;
    String pos;
    String nivel = "";

    public void crear(int n) {
        inicial = n;

        matriz1 = new String[n][n];
        matriz2 = new String[n][n];

        //matriz del juego
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz1[i][j] = "X";
            }
        }
        //imprimiendo

        if (n == 4) {
            nivel = "PRINCIPIANTE";
        } else if (n == 6) {
            nivel = "INTERMEDIO";
        } else if (n == 8) {
            nivel = "EXPERTO";
        }
        System.out.println("--------------------------------------------------");
        if (nivel == "PRINCIPIANTE") {
            System.out.println("                NIVEL " + nivel);
        } else if (nivel == "INTERMEDIO") {
            System.out.println("                 NIVEL " + nivel);
        } else if (nivel == "EXPERTO") {
            System.out.println("                   NIVEL " + nivel);
        }
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println("");
            if (nivel == "PRINCIPIANTE") {
                System.out.print("                   ");
            } else if (nivel == "INTERMEDIO") {
                System.out.print("                ");
            } else if (nivel == "EXPERTO") {
                System.out.print("             ");
            }
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("|" + matriz1[i][j] + "|");
            }
        }

        matriz2(n);

        System.out.println("");
        System.out.println("               --------------------");
        System.out.println("                    Voltear: V");
        System.out.println("                    Reiniciar: R");
        System.out.println("                    Salir: S");
        System.out.print("                  Ingrese Opciton: ");
        //ingresando option para jugar
        Scanner Joption = new Scanner(System.in);
        String letra;
        letra = Joption.nextLine();
        System.out.println("               --------------------");
        Option(letra);
    }

    public void Option(String letra) {
        switch (letra) {
            case "V":
                voltear();
                break;
            case "v":
                voltear();
                break;
            case "R":
                crear(inicial);
                break;
            case "r":
                crear(inicial);
                break;
            case "S":
                break;
            case "s":
                break;
        }
    }

    public void matriz2(int n) {
        //matriz de minas y numeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz2[i][j] = " ";
            }
        }

        //determinando el numero de minas segun el nivel del juego
        int nMinas = 0;
        switch (n) {
            case 4:
                nMinas = 4;
                break;
            case 6:
                nMinas = 8;
                break;
            case 8:
                nMinas = 12;
                break;
        }
        //llenando la matriz2 con el numero de minas
        for (int i = 0; i < nMinas; i++) {
            int verificador = 0;
            while (verificador == 0) {
//                System.out.println("nMinas: " + nMinas);
                randomX = ThreadLocalRandom.current().nextInt(0, n);
                randomY = ThreadLocalRandom.current().nextInt(0, n);
//                System.out.println("randomX: " + randomX + "randomY: " + randomY);
                if (matriz2[randomX][randomY] == " ") {
                    matriz2[randomX][randomY] = "*";
                    verificador = 1;
                }
            }
        }
        //llenando de numeros las matriz 2
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                if (matriz2[i][j] == " ") {
                    int numero = 0;
                    String num;
                    //una posicion arriba
                    try {
                        if (matriz2[i - 1][j] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //una posicion abajo
                    try {
                        if (matriz2[i + 1][j] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //una posicion a la izquierda
                    try {
                        if (matriz2[i][j - 1] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //una posicion a la derecha
                    try {
                        if (matriz2[i][j + 1] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //esquina superior izquierda
                    try {
                        if (matriz2[i - 1][j - 1] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //esquina superior derecha
                    try {
                        if (matriz2[i - 1][j + 1] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //esquina inferior izquierda
                    try {
                        if (matriz2[i + 1][j - 1] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
                    //esquina inferior derecha
                    try {
                        if (matriz2[i + 1][j + 1] == "*") {
                            numero = numero + 1;
                        }
                    } catch (Exception e) {
                    }
//                    System.out.println("numero: "+numero);
                    num = String.valueOf(numero);
                    matriz2[i][j] = num;
                }
            }
        }

        //imprimiendo matriz de minas y numero
        System.out.println("");
        for (int i = 0; i < matriz2.length; i++) {
            System.out.println("");
            if (nivel == "PRINCIPIANTE") {
                System.out.print("                   ");
            } else if (nivel == "INTERMEDIO") {
                System.out.print("                ");
            } else if (nivel == "EXPERTO") {
                System.out.print("             ");
            }
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("|" + matriz2[i][j] + "|");
            }
        }

    }

    public void voltear() {
        //ingresando posiciones x,y
        Scanner ingresar = new Scanner(System.in);
        System.out.println("               Ingrese fila y columna:");
        System.out.print("                         ");
        pos = ingresar.nextLine();
        String[] parts = pos.split(",");
//        System.out.println("pos: " + pos);
        x = Integer.parseInt(parts[0]);
//        System.out.println("x: " + x);
        y = Integer.parseInt(parts[1]);
//        System.out.println("y: " + y);
        int posX = x - 1;
//        System.out.println("posX: " + posX);
        int posY = y - 1;
//        System.out.println("posY: " + posY);
//        System.out.println("inicial: " + inicial);
        //filtro de la posicion ingresada
        if (posX < inicial & posY < inicial & posX >= 0 & posY >= 0) {

            if (matriz2[posX][posY] != "*" & matriz1[posX][posY] == "X") {
                //en la posicion elegida
                matriz1[posX][posY] = matriz2[posX][posY];
                //una posicion arriba
                try {
                    if (matriz2[posX - 1][posY] != "*") {
                        matriz1[posX - 1][posY] = matriz2[posX - 1][posY];
                    }
                } catch (Exception e) {
                }
                //una posicion abajo
                try {
                    if (matriz2[posX + 1][posY] != "*") {
                        matriz1[posX + 1][posY] = matriz2[posX + 1][posY];
                    }
                } catch (Exception e) {
                }
                //una posicion a la izquierda
                try {
                    if (matriz2[posX][posY - 1] != "*") {
                        matriz1[posX][posY - 1] = matriz2[posX][posY - 1];
                    }
                } catch (Exception e) {
                }
                //una posicion a la derecha
                try {
                    if (matriz2[posX][posY + 1] != "*") {
                        matriz1[posX][posY + 1] = matriz2[posX][posY + 1];
                    }
                } catch (Exception e) {
                }
                //contador para la matriz2
                int contadorM2 = 0;
                int contadorM1 = 0;
                for (int i = 0; i < matriz2.length; i++) {
                    for (int j = 0; j < matriz2.length; j++) {
                        if (matriz2[i][j] != "*") {
                            contadorM2 = contadorM2 + 1;
                        }
                    }
                }
//            System.out.println("contadorM2: " + contadorM2);
                //contador para la matriz1
                for (int i = 0; i < matriz1.length; i++) {
                    for (int j = 0; j < matriz1.length; j++) {
                        if (matriz1[i][j] != "X") {
                            contadorM1 = contadorM1 + 1;
                        }
                    }
                }
//            System.out.println("contadorM1: " + contadorM1);
                if (contadorM1 == contadorM2) {
                    victoria();
                } else if (contadorM1 != contadorM2) {
                    seguir_jugando();
                }
            } else if (matriz2[posX][posY] == "*") {
                derrota();
            } else if (matriz1[posX][posY] != "X") {
                System.out.println("  La posicion ya fue volteada, intenta con otra");
                voltear();
            }

        } else {
            System.out.println("  La posicion ingresada no es valida, intenta con otra");
            voltear();
        }
    }

    public void seguir_jugando() {
        System.out.println("--------------------------------------------------");
        if (nivel == "PRINCIPIANTE") {
            System.out.println("                NIVEL " + nivel);
        } else if (nivel == "INTERMEDIO") {
            System.out.println("                 NIVEL " + nivel);
        } else if (nivel == "EXPERTO") {
            System.out.println("                   NIVEL " + nivel);
        }
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println("");
            if (nivel == "PRINCIPIANTE") {
                System.out.print("                   ");
            } else if (nivel == "INTERMEDIO") {
                System.out.print("                ");
            } else if (nivel == "EXPERTO") {
                System.out.print("             ");
            }
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("|" + matriz1[i][j] + "|");
            }
        }

        matriz2_seguir();

        System.out.println("");
        System.out.println("               --------------------");
        System.out.println("                    Voltear: V");
        System.out.println("                    Reiniciar: R");
        System.out.println("                    Salir: S");
        System.out.print("                  Ingrese Opciton: ");
        //ingresando option para jugar
        Scanner Joption = new Scanner(System.in);
        String letra;
        letra = Joption.nextLine();
        System.out.println("               -------------------");
        Option(letra);
    }

    public void matriz2_seguir() {
        //imprimiendo matriz de minas y numero
        System.out.println("");
        for (int i = 0; i < matriz2.length; i++) {
            System.out.println("");
            if (nivel == "PRINCIPIANTE") {
                System.out.print("                   ");
            } else if (nivel == "INTERMEDIO") {
                System.out.print("                ");
            } else if (nivel == "EXPERTO") {
                System.out.print("             ");
            }
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("|" + matriz2[i][j] + "|");
            }
        }
    }

    public void derrota() {
        System.out.println("--------------------------------------------------");
        if (nivel == "PRINCIPIANTE") {
            System.out.println("                NIVEL " + nivel);
        } else if (nivel == "INTERMEDIO") {
            System.out.println("                 NIVEL " + nivel);
        } else if (nivel == "EXPERTO") {
            System.out.println("                   NIVEL " + nivel);
        }
        System.out.println("                   PERDISTE!!!!");
        //copiando todos los elementos de la matriz2 a la matriz1
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                matriz1[i][j] = matriz2[i][j];
            }
        }
        //imprimiendo matriz1
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println("");
            if (nivel == "PRINCIPIANTE") {
                System.out.print("                   ");
            } else if (nivel == "INTERMEDIO") {
                System.out.print("                ");
            } else if (nivel == "EXPERTO") {
                System.out.print("             ");
            }
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("|" + matriz1[i][j] + "|");
            }
        }
        //imprimiendo matriz de minas y numero
        System.out.println("");
        for (int i = 0; i < matriz2.length; i++) {
            System.out.println("");
            if (nivel == "PRINCIPIANTE") {
                System.out.print("                   ");
            } else if (nivel == "INTERMEDIO") {
                System.out.print("                ");
            } else if (nivel == "EXPERTO") {
                System.out.print("             ");
            }
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("|" + matriz2[i][j] + "|");
            }
        }
        System.out.println("");
        System.out.println("               ---------------------");
        System.out.println("                  Jugar de nuevo:");
        System.out.println("                       SI: S");
        System.out.println("                       NO: N");
        System.out.print("                   Ingrese Opcion: ");
        Scanner leer = new Scanner(System.in);
        String r = "";
        r = leer.nextLine();
        switch (r){
            case "S":
                new Practica1_201503741().menu();
                break;
            case "s":
                new Practica1_201503741().menu();
                break;
            case "N":
                break;
            case "n":
                break;
        }
        
    }

    public void victoria() {
        System.out.println("--------------------------------------------------");
        if (nivel == "PRINCIPIANTE") {
            System.out.println("                NIVEL " + nivel);
        } else if (nivel == "INTERMEDIO") {
            System.out.println("                 NIVEL " + nivel);
        } else if (nivel == "EXPERTO") {
            System.out.println("                   NIVEL " + nivel);
        }
        System.out.println("                   VICTORIA!!!!");
        //copiando todos los elementos de la matriz2 a la matriz1
        /*
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                matriz1[i][j] = matriz2[i][j];
            }
        }
        //imprimiendo matriz1
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println("");
            System.out.print("              ");
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("|" + matriz1[i][j] + "|");
            }
        }
        //imprimiendo matriz de minas y numero
        System.out.println("");
        for (int i = 0; i < matriz2.length; i++) {
            System.out.println("");
            System.out.print("              ");
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("|" + matriz2[i][j] + "|");
            }
        }
        */
        System.out.println("");
        System.out.println("               ---------------------");
        System.out.println("                  Jugar de nuevo:");
        System.out.println("                       SI: S");
        System.out.println("                       NO: N");
        System.out.print("                   Ingrese Opcion: ");
        Scanner leer = new Scanner(System.in);
        String r = "";
        r = leer.nextLine();
        switch (r){
            case "S":
                new Practica1_201503741().menu();
                break;
            case "s":
                new Practica1_201503741().menu();
                break;
            case "N":
                break;
            case "n":
                break;
        }
        
    }
}
