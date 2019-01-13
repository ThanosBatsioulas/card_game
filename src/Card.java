/*η κλάση Card υλοποιεί μία κάρτα με ένα σύμβολο.
 *
 */
package cardgame;

import java.util.Random;

public class Card {
    private char symbol;

    public Card(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char s) {
        this.symbol = s;
    }

    //γεμίζει την κάρτα με ένα γράμμα της alphabet.
    public static Card fillCard(int index) {
        StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        char randomSymbol ;
        randomSymbol = alphabet.charAt(index);

        return new Card(randomSymbol);
    }

    //ελέγχει αν δύο κάρτες έχουν το ίδο symbol.
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
