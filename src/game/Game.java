package game;

import location.*;
import location.battle.Cave;
import location.battle.Forest;
import location.battle.Mine;
import location.battle.River;
import location.safe.SafeHouse;
import location.safe.Shop;
import player.Player;

import java.util.Scanner;

public class Game {
    Location location;

    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("# Welcome to the Dark Path #");
        System.out.print("Please enter your nickname : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName().toUpperCase() + ", Are you ready for a scary journey!");
        player.selectChar();

        while (true){
            System.out.println();
            player.printInfo();
            System.out.println();
            System.out.println("# LOCATIONS #");
            System.out.println();
            System.out.println("Please choose a location to go");
            System.out.println("------------------------------");
            System.out.println("0. Exit game.Game  --------> End the Game");
            System.out.println("1. Safe House --------> You can recover your health in here.");
            System.out.println("2. Shop       --------> You can buy equipments in here.");
            System.out.println("3. Cave       --------> Battlefield (Reward: Food).");
            System.out.println("4. Forest     --------> Battlefield (Reward: Firewood).");
            System.out.println("5. River      --------> Battlefield (Reward: Water).");
            System.out.println("6. Mine       --------> Battlefield (Reward: Can gain an equipment.Armor, weapon or gold).");
            System.out.print(":: ");
            int selectLocation = input.nextInt();
            while (selectLocation < 0 || selectLocation > 6){
                System.out.println("Invalid Value. Please choose again.");
                selectLocation = input.nextInt();
            }
            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Shop(player);
                    break;
                case 3:
                    if (!player.getInventory().isFood()){
                        location = new Cave(player);
                    }
                    else {
                        player.cleared("Cave", "Food");
                        this.location = new SafeHouse(player);
                    }
                    break;
                case 4:
                    if (!player.getInventory().isFirewood()){
                        location = new Forest(player);
                    }
                    else {
                        player.cleared("Forest", "Firewood");
                        this.location = new SafeHouse(player);
                    }
                    break;
                case 5:
                    if (!player.getInventory().isWater()){
                        location = new River(player);
                    }
                    else {
                        player.cleared("River", "Water");
                        this.location = new SafeHouse(player);
                    }
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location == null){
                System.out.println("You gave up quickly. Your path ended here.");
                break;
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
            if(selectLocation == 1 && player.getInventory().isFood() && player.getInventory().isFirewood() && player.getInventory().isWater()){
                System.out.println("You collected all the elements and...");
                System.out.println("You Won The Game");
                System.out.println("CONGRATULATIONS :)");
                break;
            }

        }

    }

}


