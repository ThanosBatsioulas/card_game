package cardgame;

import java.util.Scanner;
import java.util.*;

public class Game {

    Board table ;

    public Game(int row, int col, int times) {
        table = new Board(row, col, times);
        int rounds = 0;

        do {
            rounds = rounds +1;
            System.out.println("Κάνε την " + rounds + "η προσπάθεια..");

            int[] coords = new int[2 * times];
            for(int i = 0; i < 2 * times; i++ ) {
                coords[i] = getCoordinate(i,times);
            }
            if(table.matchCards(coords[0],cords[1],cord[2],cords[3])) {
                System.out.println("Ταιριάζουν οι κάρτες μεταξύ τους");
                table.changeFinalTable(coords[0],cords[1],cord[2],cords[3])
            }

        }
    }

    public int getCoordinate(int x, int t) {
        int coordinate;
        if(x mod 2 == 0) {
            System.out.println("Δώσε την γραμμή της " + (x+1) +"ης κάρτας");
            coord = readCoordinate();
            return coordinate;
        }
        System.out.println("Δώσε την στήλη της" + (x+1) +"ης κάρτας");
        coord = readCoordinate();
        return coordinate;
    }

    public int readCoordinate() {
        Scanner scanner = new Scanner(System.in);
        int coord;
        boolean goodData = true;
        do {
            if(!goodData){
                System.out.println("Πληκτολόγησες λάθος συντεταγμένη");
            }
            coord = scanner.nextInt();
            goodData = (coord > 0 && coord < table.getRow()) || (coord > 0 && coord < table.getCol());

        } while(!goodData);
        return coord;
    }
}
