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
                System.out.println("Ταιριάζουν οι κάρτες μεταξύ τους\n");
                table.changeFinalTable(coords);
                table.printFinalTable();
            }
            else {
                System.out.println("Δεν ταιριάζουν οι κάρτες μεταξύ τους\n");
                table.printFakeTable(coords);
            }
        } while(table.winTable() == false);
    }

    // Reads a set of coordinates x, y from the user
    public int[] getCoordinates() {
        int[] coordinates = new int[2];

        System.out.println("Δώσε την γραμμή της κάρτας ");
        do{
            coordinates[0] = readCoordinate();
            if(!coordInRange(0, table.getRow(), coordinates[0])){
                System.out.println("Έδωσες λάθος συντεταγμένες\nΔώσε τιμή μέχρι " + table.getRow());
            }
        } while (!coordInRange(0, table.getRow(), coordinates[0]));


        System.out.println("Δώσε την στήλη της κάρτας");
        do {
            coordinates[1] = readCoordinate();
            if(!coordInRange(0, table.getCol(), coordinates[1])){
                System.out.println("Έδωσες λάθος συντεταγμένες\nΔώσε τιμή μέχρι " + table.getCol());
            }
        }
        while (!coordInRange(0, table.getCol(), coordinates[1]));

        return coordinates;
    }

    public boolean coordInRange(int min, int max, int x) {
            boolean coordTest;
            coordTest = (x >= min && x < max);
            return coordTest;
    }

    public int readCoordinate() {
        Scanner scanner = new Scanner(System.in);
        int coord = scanner.nextInt() - 1;

        return coord;
    }
}
