package lunaticoscraft.lunaticoscraft.events;

import lunaticoscraft.lunaticoscraft.database.ConnectionDB;
import lunaticoscraft.lunaticoscraft.database.querys.PlayerQueries;
import lunaticoscraft.lunaticoscraft.helpers.RaceHelper;
import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import lunaticoscraft.lunaticoscraft.races.Automech;
import lunaticoscraft.lunaticoscraft.races.Dweller;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;


public class JoinEvent implements Listener {

    @EventHandler
    public void onEnter(PlayerJoinEvent event) {
        Player p = event.getPlayer();

         PlayerQueries playerQueries = new PlayerQueries();
         String databasePlayer = playerQueries.findPlayerByName(p.getName());

        if(databasePlayer == null) return;
        BaseRace race = RaceHelper.getRace(databasePlayer, p);
        if(race == null) return;
        race.setEffects();

        Bukkit.getLogger().info("Entrou: " + p);
    }


}