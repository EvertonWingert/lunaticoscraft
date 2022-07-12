package lunaticoscraft.lunaticoscraft.events;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import lunaticoscraft.lunaticoscraft.races.Dweller;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onEnter(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        BaseRace race = new Dweller(p);

        race.setBuff();
        race.setDebuff();

        Bukkit.getLogger().info("Entrou: " + p);
    }

}