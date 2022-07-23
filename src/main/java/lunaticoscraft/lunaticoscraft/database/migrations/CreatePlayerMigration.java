package lunaticoscraft.lunaticoscraft.database.migrations;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static lunaticoscraft.lunaticoscraft.database.ConnectionDB.con;

public class CreatePlayerMigration {

    public static void execute(){
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement("CREATE TABLE IF NOT EXISTS `players` (`id` INTEGER PRIMARY KEY AUTOINCREMENT ,`nick` varchar(255), `race` varchar(255))");
            stm.execute();
            stm.close();
            Bukkit.getConsoleSender().sendMessage("[Lunaticoscraft] Tabela player criada");
        }catch (SQLException e){
            Bukkit.getConsoleSender().sendMessage("[Lunaticoscraft] Erro ao criar tabela player");
        }
    }
}
