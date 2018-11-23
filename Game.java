package cardgame;

import java.util.Scanner;
import java.util.*;

public class Game {
    Board table ;

    public Game(int row, int col, int times) {
        table = new Board(row, col, times);
        int rounds = 0;
        table.printFinalTable();

        do {
            rounds = rounds + 1;
            System.out.println("Κάνε την " + rounds + "η προσπάθεια..");

            // Get times * set of coordinates [[x, y], [x, y]]
            int[][] coords = new int[times][2];
            for (int i = 0; i < times; i++ ) {
                coords[i] = getCoordinates();
            }

            if (table.matchCards(coords)) {
                System.out.println("ΜΠΡΑΒΟ!!!\nΤαιριάζουν οι κάρτες μεταξύ τους\n");
                table.changeFinalTable(coords);
                table.printFinalTable();
            }
            else {
                try {
                System.out.println("SORRY:(\nΔεν ταιριάζουν οι κάρτες μεταξύ τους\n");
                table.printFakeTable(coords);
                Thread.sleep(5000);
                clearScreen();
                table.printFinalTable();
                }
                catch (InterruptedException e){
                }
            }
        } while (table.winTable() == false);
        System.out.println("ΣΥΓΧΑΡΗΤΗΡΙΑ ΚΕΡΔΙΣΕΣ ΤΟ ΠΑΙΧΙΝΙΔΙ ΣΕ" + rounds + "ΓΥΡΟΥΣ");
    }

    // Reads a set of coordinates x, y from the user
    public int[] getCoordinates() {
        int[] coordinates = new int[2];

        System.out.println("->Δώσε την γραμμή της κάρτας ");
        do {
            coordinates[0] = readCoordinate();
            if (!coordInRange(0, table.getRow(), coordinates[0])){
                System.out.println("Έδωσες λάθος συντεταγμένες\nΔώσε τιμή μέχρι " + table.getRow());
            }
        } while (!coordInRange(0, table.getRow(), coordinates[0]));


        System.out.println("->Δώσε την στήλη της κάρτας");
        do {
            coordinates[1] = readCoordinate();
            System.out.println();
            if (!coordInRange(0, table.getCol(), coordinates[1])){
                System.out.println("Έδωσες λάθος συντεταγμένες\nΔώσε τιμή μέχρι " + table.getCol());
            }
        }
        while (!coordInRange(0, table.getCol(), coordinates[1]));

        return coordinates;
    }

    public boolean coordInRange(int min, int max, int x) {
        return (x >= min && x < max);
    }

    public int readCoordinate() {
        Scanner scanner = new Scanner(System.in);
        int coord = scanner.nextInt() - 1;

        return coord;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
