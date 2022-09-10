import java.util.Random;

public class Snake extends Monster{
    public Snake() {
        super("Snake", 4, 3, 12, 12, 0);
        Random r = new Random();
        int randomDamage = r.nextInt(4)+3;
        setDamage(randomDamage);
    }
}
