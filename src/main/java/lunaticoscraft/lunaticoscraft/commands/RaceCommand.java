package lunaticoscraft.lunaticoscraft.commands;

import lunaticoscraft.lunaticoscraft.database.querys.PlayerQueries;
import lunaticoscraft.lunaticoscraft.helpers.RaceHelper;
import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RaceCommand  implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("race")) {

            if(args[0] == null) return true;

            String raceName = args[0];

            Bukkit.getLogger().info(args[0]);

            BaseRace race = RaceHelper.getRace(raceName, p);
            if(race == null) return true;

            race.setEffects();

            //Salva player no banco de dados
            PlayerQueries playerQueries = new PlayerQueries();
            playerQueries.save(p.getName(), race.getName());
        }
        return true;
    }

}

