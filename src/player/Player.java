package player;

import character.Archer;
import character.GameChar;
import character.Knight;
import character.Samurai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int gold;
    private String charName;
    private String name;
    private int maxHealth;
    private List<Integer> visitedLocation = new ArrayList<>();

    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public List<Integer> getVisitedLocation() {
        return visitedLocation;
    }

    public void addVisitedLocation(Integer newLocation) {
        this.visitedLocation.add(newLocation);
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("----------------------------------------------");
        System.out.println("CHARACTERS");
        System.out.println("----------------------------------------------");
        for (GameChar gameChar: charList) {
            System.out.println("ID-" + gameChar.getId() +
                    "\t Character: " + gameChar.getName() +
                    "\t Damage: " + gameChar.getDamage() +
                    "\t Health: " + gameChar.getHealth() +
                    "\t Gold: " + gameChar.getGold());
        }
        System.out.println("----------------------------------------------");
        System.out.println("Choose your destiny !");
        System.out.print(":: ");
        int charSelect = input.nextInt();
        switch (charSelect){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("You are a " + this.getCharName() + " now on...");

    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setGold(gameChar.getGold());
        this.setCharName(gameChar.getName());
        this.setMaxHealth(gameChar.getHealth());
    }
    public void printInfo(){
        System.out.println("equipment.Weapon : " + this.getInventory().getWeapon().getName() +
                ", equipment.Armor : " + this.getInventory().getArmor().getName() +
                ", Block : " + this.getInventory().getArmor().getBlock() +
                ", Damage : " + this.getDamage() +
                ", Health : " + this.getHealth() +
                ", Gold : " + this.getGold());
        System.out.println("Rewards >> Firewood: " + rewardInfo(this.inventory.isFirewood() )+
                ", Water : " + rewardInfo(this.inventory.isWater()) +
                ", Food : " + rewardInfo(this.inventory.isFood()));
    }
    public void ouch(int damage){
        int currentDamage = damage - this.inventory.getArmor().getBlock();
        if (currentDamage < 0){
            currentDamage = 0;
        }
        this.health -= currentDamage;
        if (this.health < 0 ){
            this.health = 0;
        }
    }
    public void raiseGold(int goldDrop){
        this.gold += goldDrop;
    }
    public char rewardInfo(boolean isStock){
        return isStock ? '1' : '0';
    }
    public void cleared(String battlefield, String reward){
        System.out.println("You already cleared " + battlefield + " and got the " + reward);
        System.out.println("You're going to Safe House now...");
        System.out.println();
    }
}

