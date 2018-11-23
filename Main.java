/**
 *H κλάση Main δίνει την επιλογή στον χρήστη να επιλέξει όποιο
 *από τα 3 παιχνίδια θέλει.
 * Αθανάσιος Μπατσιούλας ΑΕΜ 2776
 * Βασίλειος Πιτσιάβας   ΑΕΜ 2859
 */
package cardgame;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner ans = new Scanner(System.in);
        int i;
        Game game;

        do {
            System.out.println("Πάτα 1 για το Βασικό\n");
            System.out.println("Πάτα 2 για το Διπλάσιο\n");
            System.out.println("Πάτα 3 για το Τρίο\n");
            System.out.println("Πάτα 0 αμα θες να βγεις\n");

            i = ans.nextInt();
            System.out.println();
            switch (i) {
                case 1: {
                    game = new Game(4,6,2);
                    break;
                }
                case 2: {
                    game = new Game(6,8,2);
                    break;
                }
                case 3: {
                    game = new Game(6,6,3);
                    break;
                }
                case 0: {
                    System.out.println("Έξοδος. Bye:D");
                    break;
                }
            }
        } while (i != 0);
    }
}
