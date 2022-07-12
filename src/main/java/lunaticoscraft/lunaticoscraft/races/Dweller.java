package lunaticoscraft.lunaticoscraft.races;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Dweller implements BaseRace {

    private Player player;

    public Dweller(Player p) {
        this.player = p;
    }

    @Override
    public void setBuff() {
        this.player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 4));

    }

    @Override
    public void setDebuff() {
        this.player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.HUNGER, Integer.MAX_VALUE, 1));
    }
}
