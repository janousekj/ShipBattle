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

        setupBattlefield();
        gamePlay(firstPlayer, secondPlayer);


    }

    private static void gamePlay(Player firstPlayer, Player secondPlayer) {
        //setup ships on battlefield
        // TODO
        while (isShipsOnField(firstPlayer, secondPlayer)) {
        for (Player player : game.getPlayers()) {
                println("Na tahu je" + player.getName() + "prosim strilej");
                int x = askForCoordinates("x");
                int y = askForCoordinates("y");
                switch (player.getBattlefield().fire(x, y)) {
                    case EMPTY:
                        println("Vedle!");
                        player.getBattlefield().setHit(x, y);
                        player.printBattlefield();
                        break;
                    case SHIP:
                        println("Zasah");
                        player.getBattlefield().setHit(x, y);
                        player.setHits(player.getHits()+1);
                        player.printBattlefield();
                        break;
                    case HIT:
                        println("Tam uz jsi strilel");
                        player.printBattlefield();
                        break;
                    default:
                        break;
                }
            }

        }
    }

    private static boolean isShipsOnField(Player firstPlayer, Player secondPlayer) {
        return firstPlayer.getHits() < game.getTOTAL_AMOUNT_OF_SHIPS() || secondPlayer.getHits() < game.getTOTAL_AMOUNT_OF_SHIPS();
    }

    private static void setupBattlefield() {
        for (Player player : game.getPlayers()) {
            println("Nyni� zadava " + player.getName());
            int i = 0;
            while (i < Game.TOTAL_AMOUNT_OF_SHIPS) {
                println("Zadejte souradnice pro " + i + ". lod");
                int x = askForCoordinates("x");
                int y = askForCoordinates("y");
                if (player.getBattlefield().putShip(x, y)) {
                    println("Lod byla umistena");
                    i++;
                } else println("Uz tam nejakou lod mas");

            }
        }
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
