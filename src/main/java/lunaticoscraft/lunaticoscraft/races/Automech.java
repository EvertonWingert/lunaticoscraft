package lunaticoscraft.lunaticoscraft.races;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Automech implements BaseRace {

    String name = "Automech";

    public String getName() {
        return name;
    }

    private Player player;

    public Automech(Player p) {
        this.player = p;
    }

    @Override
    public void setEffects() {
        this.player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 4));
        this.player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
    }

    @Override
    public void clearEffects() {
        this.player.removePotionEffect(PotionEffectType.ABSORPTION);
        this.player.removePotionEffect(PotionEffectType.SLOW);
    }


}
