package cardgame;

import java.util.Random;

public class Card {
    private char symbol;

    public Card(char symbol) {
        this.symbol = symbol;

    }

    public char getSymbol() {
        //System.out.println("im in getSymbol");
        return this.symbol;
    }
    public void setSymbol(char s) {
        this.symbol = s;
    }

    public static Card fillCard(int index) {
        StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        char randomSymbol ;
        randomSymbol = alphabet.charAt(index);

        return new Card(randomSymbol);
    }

    public boolean equality(Card card) {
        return this.symbol == card.symbol;
    }

    /*public void lengthOfAlphabet(int length) {
        alphabet.delete(length,26);
    }
    public void deleteLetter(char letter) {
        int index = alphabet.indexOf(String.valueOf(letter));
        alphabet.deleteCharAt(index);
    }*/

}
