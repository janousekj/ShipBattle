package com.company.presentation.console;

import com.company.domain.Game;
import com.company.domain.Player;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by semanticer on 7. 4. 2016.
 */
public class ConsoleGame {

    private static Game game;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        // setup game
        printBlock("Hra zacina");



        print("Zadejte velikost pole: ");
        final int battlefieldSize = scanner.nextInt();
        Player firstPlayer = createPlayer(battlefieldSize);
        Player secondPlayer = createPlayer(battlefieldSize);

        game = new Game(Arrays.asList(firstPlayer, secondPlayer));


        for (Player player : game.getPlayers()) {
            println("Nyní zadava "+player.getName());
            int i = 0;
            while (i <=5) {
                println("Zadejte souradnice pro "+i+". lod");
                int x = askForCoordinates("x");
                int y = askForCoordinates("y");
                if (player.getBattlefield().putShip(x,y)){
                    println("Lod byla umistena");
                    i++;
                }else println("Uz tam nejakou lod mas");

            }
        }
        //setup ships on battlefield
        // TODO hratelny prvni tah

    }

    private static int askForCoordinates(String par) {
        print("Zadejte souradnici " + par + ": ");
        int val = scanner.nextInt();
        return val;
    }

    private static Player createPlayer(int size) {
        print("Zadejte jmeno hrace: ");
        String playerName = scanner.nextLine();
        return new Player(playerName, size);
    }


    public static void printBlock(String text){
        System.out.println("/// --- " + text + " --- \\\\\\");
    }

    public static void println(String text){

        System.out.println(text);
    }
    public static void print(String text){
        System.out.print(text);
    }
}
