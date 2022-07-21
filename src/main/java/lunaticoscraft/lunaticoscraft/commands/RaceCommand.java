package lunaticoscraft.lunaticoscraft.commands;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import lunaticoscraft.lunaticoscraft.races.Automech;
import lunaticoscraft.lunaticoscraft.races.Dweller;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class RaceCommand  implements CommandExecutor {

    public static Map<String, String> players = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("race")) {

            String raceName = args[0];

            if(players.containsKey(p.getName())){
                BaseRace oldRace = getRace(raceName, p);
                oldRace.clearEffects();
                players.remove(p.getName());
            }

            BaseRace race = getRace(raceName, p);
            if(race == null) return true;

            race.setEffects();
            players.put(p.getName(), race.getName());
        }
        return true;
    }

    BaseRace getRace(String raceName, Player p){
        if(Objects.equals(raceName, "Automech")){
            return new Automech(p);
        }

        if(Objects.equals(raceName, "Dweller")){
            return new Dweller(p);
        }

        return null;
    }
}

