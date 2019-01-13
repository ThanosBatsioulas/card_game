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
    public Game(int row, int col, int times, int num_pl, int num_bots) {
        table = new Board(row, col, times);
        //int rounds = 0;
        table.printFinalTable();

        players = new Player[num_pl];
        for (int i = 0; i < num_pl - num_bots; ++i) {
            players[i] = new Player();
        }
        for(int i = num_pl - num_bots; i < num_pl; ++i) {
            players[i] = new Bot();
        }

        //έναρξη γύρων
        do {
            for(int j = 0; j < num_pl; j++) {
                Boolean flag = false;
                do {
                    //rounds = rounds + 1;
                    players[j].setRound();
                    System.out.println("o "+ (j+1) + "ος παίχτης να κάνει την " + players[j].getRound() + "η προσπάθεια..");


                    //ένα set*times τύπου-> [[x, y], [x, y]]
                    int[][] coords = new int[times][2];
                    for (int i = 0; i < times; i++ ) {
                        coords[i] = getCoordinates();
                    }

                    if (table.matchCards(coords)) {
                        System.out.println("ΜΠΡΑΒΟ!!!\nΤαιριάζουν οι κάρτες μεταξύ τους\n");
                        players[j].setCorrectCards(times);
                        System.out.println("έχεις βρει" + players[j].getNumOfCorrects() + "σωστές κάρτες");
                        table.changeFinalTable(coords); //άμα είναι σωστές οι κάρτες βάλτα στον finalTable.
                        table.printFinalTable();
                        flag = true ;
                    }
                    else {
                        try {
                            System.out.println("SORRY:(\nΔεν ταιριάζουν οι κάρτες μεταξύ τους\n");
                            table.printFakeTable(coords);
                            flag = false;
                            Thread.sleep(5000); //για να μην θυμάται τις λάθος κάρτες.
                            clearScreen();
                            table.printFinalTable();
                        }
                        catch (InterruptedException e){
                        }
                    }
                } while ( flag == true);
            }
        } while (table.winTable() == false); //τέλος γύρων.

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

    public void winner(Player[] players) {
        int max = players[0].getNumOfCorrects();
        int winner = 0;
        Boolean no_winner = false;
        for(int i = 1; i < players.length; ++i ) {
            if (players[i].getNumOfCorrects() > max) {
                max = players[i].getNumOfCorrects();
                winner = i;
            }
            else if (players[i].getNumOfCorrects() == max) {
                no_winner = true;
            }
        }
        if(no_winner == false) {
            System.out.println("Ο νικητής είναι ο παίχτης " + winner + " τελειώνοντας σε " + players[winner].getRound() + " γύρους\n");
            players[winner].setWin();
        }
        else {
            System.out.println("Δεν υπάρχει νικήτης λόγω ισοβαθμίας\n");
        }
    }
}
