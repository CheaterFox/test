package location.safe;

import location.Location;
import player.Player;

abstract class SafeLocations extends Location {
    public SafeLocations(Player player, String name) {
        super(player, name);
    }

    @Override
    public abstract boolean onLocation();
}
