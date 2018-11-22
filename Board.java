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

    public void printFakeTable(int c1, int c2, int c3, int c4) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(finalTable[i][j]);

                if((i == c1 && j == c2) || (i == c3 && j == c4)){
                    System.out.print(myTable[i][j].getSymbol());
                    System.out.print("      ");
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

    public boolean matchCards(int coord1, int coord2, int coord3, int coord4) {
        if(myTable[coord1][coord2].getSymbol() == myTable[coord3][coord4].getSymbol()){
            return true;
        }
        return false;
    }

    public void changeFinalTable(int c1, int c2, int c3, int c4) {
        finalTable[c1][c2] = myTable[c1][c2].getSymbol();
        finalTable[c3][c4] = myTable[c3][c4].getSymbol();

    }

    public boolean winTable() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(finalTable[i][j] == '*'){
                    return false;
                }
            }
        }
        return true;
    }
}
