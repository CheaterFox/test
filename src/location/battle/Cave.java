package location.battle;

import monster.Zombie;
import player.Player;

public class Cave extends BattleLocations{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food",3);
    }
}
