package cardgame;

import java.util.*;

public class Player {
    protected int wins ;
    protected int correct_cards ;
    protected int round;

    public Player() {
        this.wins = 0;
        this.correct_cards = 0;
        this.round = 0;
    }
    public int getRound() {
        return round;
    }

    public void setRound() {
        round = round + 1;
    }

    public int getNumOfCorrects() {
        return this.correct_cards;
    }

    public void setCorrectCards(int x) {
        correct_cards = correct_cards + x;
    }

    public int getNumOfWins() {
        return this.wins;
    }

    public void setWin() {
        wins = wins + 1;
    }

    // παίρνει τις συντεταγμένες από τον χρήστη
    public int[] getCoordinates(int row, int col) {
        int[] coordinates = new int[2];

        System.out.println("->Δώσε την γραμμή της κάρτας ");
        do {
            coordinates[0] = this.readCoordinate();
            if (!this.coordInRange(0, row, coordinates[0])){
                System.out.println("Έδωσες λάθος συντεταγμένες\nΔώσε τιμή μέχρι " + row);
            }
        } while (!this.coordInRange(0, row, coordinates[0]));

        System.out.println("->Δώσε την στήλη της κάρτας");
        do {
            coordinates[1] = this.readCoordinate();
            System.out.println();
            if (!this.coordInRange(0, col, coordinates[1])){
                System.out.println("Έδωσες λάθος συντεταγμένες\nΔώσε τιμή μέχρι " + row);
            }
        }
        while (!this.coordInRange(0, col, coordinates[1]));

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

    public void addToMemory(int[] coords, Card card) {
    }

    public void cardFound(Card card) {}

    public int[][] getAllCoordinates(int row, int col, int times) {
        int[][] coordinates;
        for (int i = 0; i < times; ++i) {
            coordinates[i] = this.getCoordinates(row, col);
        }
        return coordinates;
    }
}
