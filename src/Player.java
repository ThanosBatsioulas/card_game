package cardgame;

import java.util.*;

public class Player {
    private int wins ;
    private int correct_cards ;
    private int round;

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
        System.out.println("la");
    }
}
