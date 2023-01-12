package location.battle;

import monster.Vampire;
import player.Player;

public class Forest extends BattleLocations{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood",3);
    }
}
