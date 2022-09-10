public class Monster {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int maxHealth;
    private int goldDrop;

    public Monster(String name, int id, int damage, int health, int maxHealth, int goldDrop) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.maxHealth = maxHealth;
        this.goldDrop = goldDrop;
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    public void ouchMonster(int damage){
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
        }
    }
    public void monsterInfo(){
        System.out.println("Monster Name : " + this.name);
        System.out.println("Health : " + this.health);
        System.out.println("Damage : " + this.damage);
        System.out.println("Gold Drop : "+ this.goldDrop);
    }
}
