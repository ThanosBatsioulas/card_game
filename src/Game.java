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
    int level;

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
            do {
                Scanner ans = new Scanner(System.in);
                System.out.println("Τι level δυσκολίας επιθυμείς;\n");
                System.out.println("Για μνήμη χρυσόψαρου πάτα 1\nΓια μνήμη κανγκουρο πάτα 2\nΓια μνήμη ελέφαντα πάτα 3\n");
                level = ans.nextInt();
            } while ( level != 1 && level != 2 && level != 3);
            players[i] = new Bot(level);
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
                    coords = players[j].getAllCoordinates(row, col, times);
                    for (int z = 0; z < num_pl; ++z) {
                        for (int i = 0; i < times; ++i){
                            players[z].addToMemory(coords[i], table.returnCard(coords[i][0], coords[i][1]));
                        }
                    }

                    if (table.matchCards(coords)) {
                        for(int z = 0; z < num_pl; ++z) {
                            players[z].cardFound(table.returnCard(coords[0][0], coords[0][1]));
                        }
                        System.out.println("ΜΠΡΑΒΟ!!!\nΤαιριάζουν οι κάρτες μεταξύ τους\n");
                        players[j].setCorrectCards(times);
                        System.out.println("έχεις βρει " + players[j].getNumOfCorrects() + "σωστές κάρτες");
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
                } while (flag == true);
            }
        } while (table.winTable() == false); //τέλος γύρων.

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
