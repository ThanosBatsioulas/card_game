package cardgame;

import java.util.*;
import java.util.Collections;

public class Board {
    private Card[][] myTable;
    private char[][] finalTable;
    private int times,row,col;

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

    public void creationBoard() {
        ArrayList<Card> list = new ArrayList<>();
        int count = (row * col) / times;

        for(int i = 0; i < count; i++ ) {
            Card c = Card.fillCard(i);
            for(int j = 0; j < times; j++) {
                list.add(c);
            }
        }
        Collections.shuffle(list);
        //System.out.println("the row is:"+ row);
        //System.out.println("the col is:"+ col);

        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                myTable[i][j] = list.get(counter);

                counter = counter + 1;
            }
        }
    }

    public void printFakeTable(int[][] coordSet) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (coordSet.length == 2){
                    if ((i == coordSet[0][0] && j == coordSet[0][1]) || (i == coordSet[1][0] && j == coordSet[1][1])) {
                        System.out.print(myTable[i][j].getSymbol());
                        System.out.print("      ");
                    }
                    else {
                        System.out.print(finalTable[i][j]);
                        System.out.print("      ");
                    }
                }
                if (coordSet.length == 3){
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

    public void printFinalTable() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(finalTable[i][j]);
                System.out.print("      ");
            }
        System.out.println("\n");
        }
    }
    public void printMyTable() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(myTable[i][j].getSymbol());
                System.out.print("      ");
            }
        System.out.println("\n");
        }
    }

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

    public void changeFinalTable(int[][] coordinateSet) {
        for (int[] c : coordinateSet) {
            finalTable[c[0]][c[1]] = myTable[c[0]][c[1]].getSymbol();
        }
    }

    public boolean winTable() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (finalTable[i][j] == '*'){
                    return false;
                }
            }
        }
        return true;
    }
}
