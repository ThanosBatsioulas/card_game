package cardgame;

import java.util.*;
import java.util.Random;

public class Bot extends Player {

    private ArrayList<Card> botMemory;
    private ArrayList<ArrayList<Integer>> coordsMemory;
    private int difficulty;

    public Bot(int difficulty) {
        botMemory = new ArrayList<Card>();
        coordsMemory = new ArrayList<ArrayList<Integer>>();
        this.difficulty = difficulty;
        /*if (this.difficulty ==  1) {
            this.goldfish();
        }
        else if (this.difficulty == 2) {
            this.kangaroo();
        }
        else {
            this.elephant();
        }*/
    }

    public void addToMemory(int[] coords, Card card) {
        botMemory.add(card);
        ArrayList<Integer> coordsList = new ArrayList<Integer>();
        for (int i : coords) {
            coordsList.add(i);
        }

        coordsMemory.add(coordsList);
    }

    public void cardFound(Card card) {
        int index;
        while (index = botMemory.indexOf(card) >= 0) {

            botMemory.remove(index);
            coordsMemory.remove(index);
        }
    }

    public int[] getCoordinates(int row, int col) {
        int[] coordinates = new int[2];

        switch (difficulty) {
            case 1: {
                coordinates[0] = getRandomInRange(1, row) - 1;
                coordinates[1] = getRandomInRange(1, col) - 1;
                break;
            }
            case 3: {

            }

        }

        return coordinates;
    }

    public static int getRandomInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;

    }

    public int[] hasSameCards(ArrayList<Card> list, Card card) {

    }

}
