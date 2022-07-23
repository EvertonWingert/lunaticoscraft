package lunaticoscraft.lunaticoscraft.helpers;

import lunaticoscraft.lunaticoscraft.interfaces.BaseRace;
import lunaticoscraft.lunaticoscraft.races.Automech;
import lunaticoscraft.lunaticoscraft.races.Dweller;
import org.bukkit.entity.Player;

import java.util.Objects;

public class RaceHelper {

    public static BaseRace getRace(String raceName, Player p){
        if(Objects.equals(raceName, "Automech")){
            return new Automech(p);
        }

        if(Objects.equals(raceName, "Dweller")){
            return new Dweller(p);
        }

        return null;
    }
}
