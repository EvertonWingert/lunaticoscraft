package lunaticoscraft.lunaticoscraft.races;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Dweller implements BaseRace {

    String name = "Dweller";

    public String getName() {
        return name;
    }
    private Player player;

    public Dweller(Player p) {
        this.player = p;
    }

    @Override
    public void setEffects() {
        this.player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 4));
        this.player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.HUNGER, Integer.MAX_VALUE, 1));

    }
    @Override
    public void clearEffects() {
        this.player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        this.player.removePotionEffect(PotionEffectType.HUNGER);
    }


}
