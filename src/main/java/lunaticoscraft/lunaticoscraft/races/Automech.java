package lunaticoscraft.lunaticoscraft.races;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import org.bukkit.entity.Player;

public class Automech implements BaseRace {

    private Player player;

    public Automech(Player p) {
        this.player = p;
    }


    @Override
    public void setBuff() {

    }

    @Override
    public void setDebuff() {

    }
}
