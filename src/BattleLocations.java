import java.util.Objects;
import java.util.Random;

abstract class BattleLocations extends Location{
    private Monster monster;
    private String reward;
    private int maxMonster;
    public BattleLocations(Player player, String name, Monster monster, String reward, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.reward = reward;
        this.maxMonster = maxMonster;
    }
    @Override
    public  boolean onLocation(){
        int monsterNumber = randomMonsterNumber();
        System.out.println("You're now on the battlefield : " + this.getName());
        System.out.println("Be careful! " + monsterNumber + " " + this.getMonster().getName() + "(s) live here.");
        System.out.println("-----------------------");
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println("Damage : " + this.getPlayer().getDamage());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("-----------------------");
        this.getMonster().monsterInfo();
        System.out.println("-----------------------");
        System.out.println("<F>ight or <E>scape");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")){
            System.out.println("Fight began !!");
            for (int i = 1; i <= monsterNumber; i++) {
                while (this.getMonster().getHealth() != 0 && this.getPlayer().getHealth() != 0) {
                    if (firstHit()){
                        System.out.println("You hit first");
                        playerHit();
                        printHealthInfo(i);
                        if (this.getMonster().getHealth() == 0){
                            break;
                        }
                        monsterHit();
                        printHealthInfo(i);
                        if (this.getPlayer().getHealth() == 0){
                            System.out.println("You died");
                            break;
                        }
                    }
                    else {
                        System.out.println("Monster hit first");
                        monsterHit();
                        printHealthInfo(i);
                        if (this.getPlayer().getHealth() == 0){
                            System.out.println("You died");
                            break;
                        }
                        playerHit();
                        printHealthInfo(i);
                        if (this.getMonster().getHealth() == 0){
                            break;
                        }
                    }
                }
                if (this.getPlayer().getHealth() == 0){
                    break;
                }
                int remainMonster = monsterNumber - i;
                System.out.println(this.getMonster().getName() + " " + i + " died. Remain monster(s) : " + remainMonster);
                this.getMonster().setHealth(this.getMonster().getMaxHealth());
            }
            if (this.getPlayer().getHealth() != 0){
                if (this.getName().equals("Mine")){
                    randomReward();
                }
                else {
                    System.out.println("Congratulations. You won reward : " + this.getReward());
                    this.getPlayer().raiseGold(this.getMonster().getGoldDrop());
                    System.out.println("You gain " + this.getMonster().getGoldDrop() + " Gold ");
                }

                switch (this.getReward()){
                    case "Water" :
                        this.getPlayer().getInventory().setWater(true);
                        break;
                    case "Food" :
                        this.getPlayer().getInventory().setFood(true);
                        break;
                    case "Firewood" :
                        this.getPlayer().getInventory().setFirewood(true);
                        break;
                }
            }
        }
        return this.getPlayer().getHealth() != 0;
    }
    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }
    public boolean firstHit(){
        Random r = new Random();
        int value = r.nextInt(2);
        return value == 0;
    }
    public void monsterHit(){
        this.getPlayer().ouch(this.getMonster().getDamage());
    }
    public void playerHit(){
        this.getMonster().ouchMonster(this.getPlayer().getDamage());
    }
    public void printHealthInfo(int whichMonster){
        System.out.println("Your Health : " + this.getPlayer().getHealth() + " ------ " +
                this.getMonster().getName() + " " + whichMonster + " Health : " + this.getMonster().getHealth());
    }
    public void randomReward(){
        // weapon reward: %15 (%50-pistol  | %30-sword   | %20-rifle)
        // armor reward : %15 (%50-light   | %30-middle  | %20-heavy)
        // gold reward  : %25 (%50- 1 gold | %30- 5 gold | %20- 10 gold)
        // nothing      : %45
        Random r = new Random();
        int rewardNumber = r.nextInt(100);
        int rewardNumber2 = r.nextInt(100);
        if (rewardNumber < 15){
            System.out.println("You gained weapon.");
            if (rewardNumber2 < 50){
                Weapon weapon = Weapon.getWeaponByID(1);
                System.out.println("Your reward is " + weapon.getName());
                if (this.getPlayer().getInventory().getWeapon().getId() < weapon.getId()){
                    this.getPlayer().getInventory().setWeapon(weapon);
                }
                else {
                    System.out.println("You already have same or higher item! So you didn't change your weapon.");
                }
            } else if (rewardNumber2 < 80) {
                Weapon weapon = Weapon.getWeaponByID(2);
                System.out.println("Your reward is " + weapon.getName());
                if (this.getPlayer().getInventory().getWeapon().getId() < weapon.getId()){
                    this.getPlayer().getInventory().setWeapon(weapon);
                }
                else {
                    System.out.println("You already have same or higher item! So you didn't change your weapon.");
                }
            }
            else {
                Weapon weapon = Weapon.getWeaponByID(3);
                System.out.println("Your reward is " + weapon.getName());
                if (this.getPlayer().getInventory().getWeapon().getId() < weapon.getId()){
                    this.getPlayer().getInventory().setWeapon(weapon);
                }
                else {
                    System.out.println("You already have same or higher item! So you didn't change your weapon.");
                }
            }
        } else if (rewardNumber < 30) {
            System.out.println("You gained armor.");
            if (rewardNumber2 < 50){
                Armor armor =  Armor.getArmorByID(1);
                if (this.getPlayer().getInventory().getArmor().getId() < armor.getId()){
                    this.getPlayer().getInventory().setArmor(armor);
                }
                else {
                    System.out.println("You already have same or higher item! So you didn't change your armor.");
                }
            } else if (rewardNumber2 < 80) {
                Armor armor = Armor.getArmorByID(2);
                System.out.println("Your reward is " + armor.getName());
                if (this.getPlayer().getInventory().getArmor().getId() < armor.getId()){
                    this.getPlayer().getInventory().setArmor(armor);
                }
                else {
                    System.out.println("You already have same or higher item! So you didn't change your armor.");
                }
            }
            else {
                Armor armor = Armor.getArmorByID(3);
                if (this.getPlayer().getInventory().getArmor().getId() < armor.getId()){
                    this.getPlayer().getInventory().setArmor(armor);
                }
                else {
                    System.out.println("You already have same or higher item! So you didn't change your armor.");
                }
            }
        } else if (rewardNumber < 55) {
            System.out.println("You gained gold.");
            if (rewardNumber2 < 50){
                this.getPlayer().raiseGold(1);
                System.out.println("Your reward is 1 gold");
            } else if (rewardNumber2 <= 80) {
                this.getPlayer().raiseGold(5);
                System.out.println("Your reward is 5 gold");
            }
            else {
                this.getPlayer().raiseGold(10);
                System.out.println("Your reward is 10 gold");
            }
        }
        else {
            System.out.println("You're unlucky. You gained no drop from this clear :( ");
        }
    }
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
