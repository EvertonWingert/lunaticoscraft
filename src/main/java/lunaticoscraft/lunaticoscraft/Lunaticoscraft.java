package lunaticoscraft.lunaticoscraft;

import lunaticoscraft.lunaticoscraft.commands.RaceCommand;
import lunaticoscraft.lunaticoscraft.database.ConnectionDB;
import lunaticoscraft.lunaticoscraft.database.migrations.CreatePlayerMigration;
import lunaticoscraft.lunaticoscraft.events.JoinEvent;
import lunaticoscraft.lunaticoscraft.events.RespawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lunaticoscraft extends JavaPlugin {

    private static Lunaticoscraft instance;

    public Lunaticoscraft() {
        instance = this;
    }

    public static Lunaticoscraft getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {

        //Database
        ConnectionDB.openConnectionSqlite();
        CreatePlayerMigration.execute();

        // Plugin startup logic
        Bukkit.getLogger().info("Plugin iniciado");

        Bukkit.getPluginManager().registerEvents(new RespawnEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        getCommand("race").setExecutor(new RaceCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
