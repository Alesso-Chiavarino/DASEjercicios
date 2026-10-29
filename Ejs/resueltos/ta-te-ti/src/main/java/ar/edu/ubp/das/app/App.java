package ar.edu.ubp.das.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Tablero tablero = new Tablero();

        Scanner in = new Scanner(System.in);
        System.out.println("Juguemos al TA-TE-TI");
        System.out.print("Nombre del jugador 1: ");
        String p1 = in.nextLine();
        System.out.print("Nombre del jugador 2: ");
        String p2 = in.nextLine();

        boolean jugador1 = true, fin = false;

        while(!fin) {
            tablero.mostrarTablero();

            if(jugador1) {
                System.out.println("Turno de " + p1 + " (X): ");
            }
            else {
                System.out.println("Turno de " + p2 + " (O): ");
            }

            char c = '-';
            if(jugador1) {
                c = 'X';
            }
            else {
                c = 'O';
            }

            int fila = 0;
            int columna = 0;
            while(true) {
                try {
                    System.out.print("Ingresa la fila (0, 1, ó 2): ");
                    fila = Integer.parseInt(in.nextLine().trim());
                    System.out.print("Ingresa la columna (0, 1, ó 2): ");
                    columna = Integer.parseInt(in.nextLine().trim());
                    if(fila < 0 || columna < 0 || fila > 2 || columna > 2) {
                        System.out.println("La posición no es válida, vuelve a intentar");
                    }
                    else if(tablero.getTablero()[fila][columna] != '-') {
                        System.out.println("La posición ya fue elegida, vuelve a intentar");
                    }
                    else {
                        break;
                    }
                }
                catch(NumberFormatException ex) {
                    System.out.println("El valor ingresado no es \"ENTERO\", vuelve a intentar");
                }
            }

            tablero.getTablero()[fila][columna] = c;
            if(gano(tablero.getTablero()) == 'X') {
                System.out.println("¡" + p1 + " ganó! :D");
                fin = true;
            }
            else if(gano(tablero.getTablero()) == 'O') {
                System.out.println("¡" + p2 + " ganó! :D");
                fin = true;
            }
            else {
                if(termino(tablero.getTablero())) {
                    System.out.println("No hay más posiciones");
                    fin = true;
                }
                else {
                    jugador1 = !jugador1;
                }
            }
        }

        tablero.mostrarTablero();

        in.close();
    }

    public static char gano(char[][] tablero) {
        for(int i = 0; i < 3; i++) {
            if(tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != '-') {
                return tablero[i][0];
            }
        }

        for(int j = 0; j < 3; j++) {
            if(tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j] && tablero[0][j] != '-') {
                return tablero[0][j];
            }
        }

        if(tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != '-') {
            return tablero[0][0];
        }

        if(tablero[2][0] == tablero[1][1] && tablero[1][1] ==  tablero[0][2] && tablero[2][0] != '-') {
            return tablero[2][0];
        }
        return ' ';
    }

    public static boolean termino(char[][] tablero) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}

