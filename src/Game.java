/*Η κλάση Game δημιουργεί ένα αντικείμενο της κλάσης Board
 *και ουσιαστικά δημιουργεί όλους τους 'κανόνες' για το παιχνίδι.
 */
package cardgame;

import java.util.Scanner;
import java.util.*;
import java.util.Arrays;

public class Game {
    Board table ;
    Player[] players;

    private int rounds;
    public Game(int row, int col, int times, int num) {
        table = new Board(row, col, times);
        //int rounds = 0;
        table.printFinalTable();

        players = new Player[num];
        for (int i = 0; i < num; ++i) {
          players[i] = new Player();
        }

        //έναρξη γύρων
        for(int j = 0; j < num; j++) {
            do {
                System.out.println(num);
                //rounds = rounds + 1;
                players[j].setRound();
                System.out.println("Κάνε την " + players[j].getRound() + "η προσπάθεια..");


                //ένα set*times τύπου-> [[x, y], [x, y]]
                int[][] coords = new int[times][2];
                for (int i = 0; i < times; i++ ) {
                    coords[i] = getCoordinates();
                }

                if (table.matchCards(coords)) {
                    System.out.println("ΜΠΡΑΒΟ!!!\nΤαιριάζουν οι κάρτες μεταξύ τους\n");
                    table.changeFinalTable(coords); //άμα είναι σωστές οι κάρτες βάλτα στον finalTable.
                    table.printFinalTable();
                }
                else {
                    try {
                    System.out.println("SORRY:(\nΔεν ταιριάζουν οι κάρτες μεταξύ τους\n");
                    table.printFakeTable(coords);
                    Thread.sleep(5000); //για να μην θυμάται τις λάθος κάρτες.
                    clearScreen();
                    table.printFinalTable();
                    }
                    catch (InterruptedException e){
                    }
                }
            } while (table.winTable() == false); //τέλος γύρων.
        }
        System.out.println("ΣΥΓΧΑΡΗΤΗΡΙΑ ΚΕΡΔΙΣΕΣ ΤΟ ΠΑΙΧΙΝΙΔΙ ΣΕ ΓΥΡΟΥΣ");
    }

    // παίρνει τις συντεταγμένες από τον χρήστη
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

//ελέγχει άμα είναι σωστη η συντεταγμένη.
    public boolean coordInRange(int min, int max, int x) {
        return (x >= min && x < max);
    }

//διβάζει απο τον χρήστη τις συντεταγμένες
    public int readCoordinate() {
        Scanner scanner = new Scanner(System.in);
        int coord = scanner.nextInt() - 1;

        return coord;
    }

//διαγράφει οτι υπάρχει στο terminal
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
