/*Στην κλάση Board δημιουργούμε τα δύο ταμπλο
 *ένα του χρήστη και ένα με τα χαρτιά
 */
package cardgame;

import java.util.*;
import java.util.Collections;

public class Board {
    private Card[][] myTable;
    private char[][] finalTable;
    private int times,row,col;

//Κατασκευαστής που αρχικοποιεί τους δύο πίνακες.
    public Board(int row, int col, int times) {
        this.myTable = new Card[row][col];
        this.finalTable = new char[row][col];
        this.row = row;
        this.col = col;
        this.times = times;
        creationBoard();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                finalTable[i][j] = '*';
            }
        }
    }
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
    }

//αρχικοποιεί τον πίνακα myTable με κάρτες,
//με την βοήθεια ενός ArrayList.
    public void creationBoard() {
        ArrayList<Card> list = new ArrayList<>();
        int count = (row * col) / times;

        for(int i = 0; i < count; i++ ) {
            Card c = Card.fillCard(i);
            for(int j = 0; j < times; j++) {
                list.add(c); //γεμίζουμε την λίστα μας με γράμματα κατά σείρα
            }
        }
        Collections.shuffle(list); // την 'ανακατεύουμε'
        //System.out.println("the row is:"+ row);
        //System.out.println("the col is:"+ col);

        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                myTable[i][j] = list.get(counter); //και τα περνάμε στο myTable

                counter = counter + 1;
            }
        }
    }

//η συνάρτηση αυτή εμφανίζει στο χρήστη τον πίνακα finalTable
//με τις λάθος μαντεψιές.
    public void printFakeTable(int[][] coordSet) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (coordSet.length == 2){ // για το παιχνίδι 1. και 2.
                    if ((i == coordSet[0][0] && j == coordSet[0][1]) || (i == coordSet[1][0] && j == coordSet[1][1])) {
                        System.out.print(myTable[i][j].getSymbol());
                        System.out.print("      ");
                    }
                    else {
                        System.out.print(finalTable[i][j]);
                        System.out.print("      ");
                    }
                }
                if (coordSet.length == 3){ // για το 3. παιχνίδι
                    if ((i == coordSet[0][0] && j == coordSet[0][1]) || (i == coordSet[1][0] && j == coordSet[1][1]) || (i == coordSet[2][0] && j == coordSet[2][1])) {
                        System.out.print(myTable[i][j].getSymbol());
                        System.out.print("      ");
                    }
                    else {
                        System.out.print(finalTable[i][j]);
                        System.out.print("      ");
                    }
                }
            }
        System.out.println("\n");
        }
    }

//η συνάρτηση αυτή εμφανίζει τον πίνακα finalTable.
    public void printFinalTable() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(finalTable[i][j]);
                System.out.print("      ");
            }
        System.out.println("\n");
        }
    }

//η συνάρτηση αυτή ελέγχει αν ταιριάζουν οι κάρτες μεταξύ τους
    public boolean matchCards(int[][] coordinateSet) {
        char firstLetter = myTable[coordinateSet[0][0]][coordinateSet[0][1]].getSymbol();

        for (int i = 1; i < coordinateSet.length; ++i) {
            char letter = myTable[coordinateSet[i][0]][coordinateSet[i][1]].getSymbol();

            if (letter != firstLetter) {
                return false;
            }
        }
        return true;
    }

//αλλάζει 2 στοιχεία του πίνακα finalTable με το σύμβολο των αντίστοιχων του myTable.
    public void changeFinalTable(int[][] coordinateSet) {
        for (int[] c : coordinateSet) {
            finalTable[c[0]][c[1]] = myTable[c[0]][c[1]].getSymbol();
        }
    }

//η συνάρτηση αυτή ελέγχει αν έχει αλλάξει όλος ο πίνακας finalTable.
    public boolean winTable() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (finalTable[i][j] == '*'){
                    return false;
                }
            }
        }
        return true; //αυτό σημαίνει ότι τελείωσε το παιχνίδι.
    }
}
