package cardGame;

import java.util.*;


public class Board {
    private Card[][] myTable;
    private int times,row,col;


    public Board(int row, int col, int t) {
        this.myTable = new Card[row][col];
        this.times = t;
    }

    public void creationBoard(int times) {
        ArrayList<Card> list = new ArrayList<>();
        int count = (row * col) / times;

        for(int i = 0; i < count; i++ ) {
            Card c = Card.fillCard();
            for(int j = 0; j < times; j++) {
                list.add(c);
            }
        }
    }
}
