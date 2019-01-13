package cardgame;

import java.util.*;

public class Bot extends Player {

    private ArrayList<Card> botMemory;
    private ArrayList<ArrayList<Integer>> coordsMemory;

    public Bot() {
        botMemory = new ArrayList<Card>();
        coordsMemory = new ArrayList<ArrayList<Integer>>();
    }

    public void addToMemory(int[] coords, Card card) {
        botMemory.add(card);
        ArrayList<Integer> coordsList = new ArrayList<Integer>();
        for (int i : coords) {
            coordsList.add(i);
        }

        coordsMemory.add(coordsList);
    }

    public void deleteFromMemory(Card card) {
        for (Card candidate : botMemory) {
            if (card.getSymbol() != candidate.getSymbol()) {
                continue;
            }

            int index = botMemory.indexOf(card);
            botMemory.remove(index);
            coordsMemory.remove(index);
        }
    }
    

}
