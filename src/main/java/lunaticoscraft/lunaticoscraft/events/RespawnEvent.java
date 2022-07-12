package lunaticoscraft.lunaticoscraft.events;

import lunaticoscraft.lunaticoscraft.Lunaticoscraft;
import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import lunaticoscraft.lunaticoscraft.races.Dweller;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnEvent implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)  {

        Bukkit.getScheduler().runTaskLater(Lunaticoscraft.getInstance(), task -> {
            Player p = event.getPlayer();
            BaseRace race = new Dweller(p);
            race.setBuff();
            race.setDebuff();
        }, 5L);
    }
}

