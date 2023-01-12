package location.battle;

import monster.Bear;
import player.Player;

public class River extends BattleLocations{
    public River(Player player) {
        super(player, "River", new Bear(), "Water",2);
    }
}
