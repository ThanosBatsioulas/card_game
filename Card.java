package cardGame;

import java.util.Random;

public class Card {
    private char symbol;
    public  StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");


    public Card(char s) {
        this.symbol = s;
    }

    public char getSymbol() {
        return this.symbol;
    }
    public void setSymbol(char s) {
        this.symbol = s;
    }

    public Card fillCard() {
        Random r = new Random();
        char randomSymbol ;

        randomSymbol = alphabet.charAt(r.nextInt(alphabet.length()));
        Card c = new Card(randomSymbol);
        System.out.println(c.getSymbol());
        return new Card(randomSymbol);
    }

    public void lengthOfAlphabet(int length) {
        alphabet.delete(length,26);
    }
    public void deleteLetter(char letter) {
        int index = alphabet.indexOf(String.valueOf(letter));
        alphabet.deleteCharAt(index);
    }






}
