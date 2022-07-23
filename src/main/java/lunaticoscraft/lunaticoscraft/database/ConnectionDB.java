package lunaticoscraft.lunaticoscraft.database;

import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class ConnectionDB {

    public static Connection con = null;

    //make singleton
    private static ConnectionDB instance;

    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    static private File createDBFile(){
        File file = new File("plugins/lunaticoscraft/database/lunaticoscraft.db");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
          try {
              file.createNewFile();
          }catch (IOException e) {
              Bukkit.getConsoleSender().sendMessage("[Lunaticoscraft] Erro ao conectar ao banco de dados SQLite");
              return null;
          }
        }
        return file;
    }

    public static void openConnectionSqlite()  {
        File file = createDBFile();
        String url = "jdbc:sqlite:" + file.getAbsolutePath();

        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);

            Bukkit.getConsoleSender().sendMessage("[Lunaticoscraft] Conectado ao banco de dados SQLite");
        } catch (SQLException | ClassNotFoundException e) {
           Bukkit.getConsoleSender().sendMessage("[Lunaticoscraft] Erro ao conectar ao banco de dados SQLite");
        }

    }



}

