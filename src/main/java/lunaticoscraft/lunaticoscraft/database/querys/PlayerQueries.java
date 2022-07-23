package lunaticoscraft.lunaticoscraft.database.querys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static lunaticoscraft.lunaticoscraft.database.ConnectionDB.con;

public class PlayerQueries {


    public void save(String nick, String race){
        PreparedStatement stm = null;

        try{
            stm = con.prepareStatement("INSERT INTO players (nick, race) values(?,?)");

            stm.setString(1, nick);
            stm.setString(2, race);

            stm.execute();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findPlayerByName(String nick){
        PreparedStatement stm = null;

        try{
            stm = con.prepareStatement("SELECT * from players WHERE nick = (?)");
            stm.setString(1, nick);

            ResultSet result = stm.executeQuery();
            return result.getString("race");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
