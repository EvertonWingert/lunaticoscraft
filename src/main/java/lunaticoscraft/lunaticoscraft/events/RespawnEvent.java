package lunaticoscraft.lunaticoscraft.events;

import lunaticoscraft.lunaticoscraft.Lunaticoscraft;
import lunaticoscraft.lunaticoscraft.database.querys.PlayerQueries;
import lunaticoscraft.lunaticoscraft.helpers.RaceHelper;
import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import lunaticoscraft.lunaticoscraft.races.Automech;
import lunaticoscraft.lunaticoscraft.races.Dweller;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Objects;

public class RespawnEvent implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)  {

        Bukkit.getScheduler().runTaskLater(Lunaticoscraft.getInstance(), task -> {

            Player p = event.getPlayer();

            PlayerQueries playerQueries = new PlayerQueries();
            String databasePlayer = playerQueries.findPlayerByName(p.getName());

            if(databasePlayer == null) return;
            BaseRace race = RaceHelper.getRace(databasePlayer, p);
            if(race == null) return;
            race.setEffects();

        }, 5L);
    }

}

