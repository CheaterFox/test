package location.battle;

import monster.Snake;
import player.Player;

public class Mine extends BattleLocations{
    public Mine(Player player) {
        super(player, "Mine", new Snake(), "Armor, weapon or gold", 5);
    }
}
