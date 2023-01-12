package location.safe;

import player.Player;

public class SafeHouse extends SafeLocations{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You're in the safe house now.");
        System.out.println("Holy Spirits blessed and heal you.");
        this.getPlayer().setHealth(this.getPlayer().getMaxHealth());
        return true;
    }
}
