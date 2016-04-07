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

        Player firstPlayer = createPlayer();
        Player secondPlayer = createPlayer();

        print("Zadejte velikost pole: ");
        int battlefieldSize = scanner.nextInt();

        game = new Game(Arrays.asList(firstPlayer, secondPlayer), battlefieldSize);


        // setup ships on battlefield
        // TODO takto se da zeptat na souradnice
        // TODO lode budou zabirat jen jedno policko zatim takze co souradnice to jedna lod
        // TODO staci se tedy obou hracu zeptat na tolik souradnic kolik maji umistit lodi kazdy na svuj battlefield
        // TODO takze napr kazdy hrac dava 5 lodi takze bude treba se kazdeho hrace 5kra zeptat na x,y souradnice
        // TODO podle ziskanych souradnic umistit lode do game a game je umisti na battlefield
        println("Zadejte souradnice pro prvni lod");
        int x = askForCoordinates("x");
        int y = askForCoordinates("y");

        println("Kontrolni print: x: " + x + " y: " + y);

    }

    private static int askForCoordinates(String par) {
        print("Zadejte souradnici " + par + ": ");
        int val = scanner.nextInt();
        return val;
    }

    private static Player createPlayer() {
        print("Zadejte jmeno hrace: ");
        String playerName = scanner.nextLine();
        return new Player(playerName);
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
