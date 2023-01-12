package character;

public class GameChar {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int gold;
    public GameChar(int id,String name, int damage, int health, int gold) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDamage() {
        return damage;
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
}

