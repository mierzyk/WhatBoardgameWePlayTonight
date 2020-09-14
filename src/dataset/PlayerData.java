package dataset;

import model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerData {


    private ArrayList<Player> playerData; //do we need this line?

    public PlayerData() {


        playerData = new ArrayList<Player>();
        Set<String> tempSet = new HashSet<String>();
        tempSet.add("Scythe");
        tempSet.add("Agricola");
        tempSet.add("Puerto Rico");
        tempSet.add("Avalon");
        tempSet.add("Captain Sonar");
        tempSet.add("Cyklady");
        tempSet.add("Siedem Cudow Swiata");
        tempSet.add("Blood Rage");


        playerData.add(new Player("Michal", tempSet));

        playerData.add(new Player("Asia", new HashSet<>() {{
            add("Scythe");
            add("Agricola");
            add("Cyklady");
            add("Feudum");
            add("Teotihuacan");
        }}));
        playerData.add(new Player("Rafal", new HashSet<>() {{
            add("Small World");
            add("Alchemicy");
            add("Feudum");
            add("Tzolk'in");
            add("Small World");
        }}));
        playerData.add(new Player("Agata", new HashSet<>() {{
            add("Scythe");
            add("Agricola");
            add("Puerto Rico");
            add("Avalon");
            add("Zimna Wojna");
        }}));
        playerData.add(new Player("Zbyszek", new HashSet<>() {{
            add("Scythe");
            add("Agricola");
            add("Avalon");
            add("Zimna Wojna");
            add("Feudum");

        }}));
        playerData.add(new Player("Agnieszka", new HashSet<>() {{
            add("Avalon");
            add("Zimna Wojna");
            add("Blood Rage");
            add("Siedem Cudow Swiata");
        }}));
        playerData.add(new Player("Tomek", new HashSet<>() {{
            add("Descent");
            add("Agricola");
            add("Terra Mystica");
            add("Avalon");
            add("Captain Sonar");
            add("Siedem Cudow Swiata");
            add("Blood Rage");
        }}));
        playerData.add(new Player("Tomek", new HashSet<>() {{
            add("Descent");
            add("Agricola");
            add("Terra Mystica");
        }}));
        playerData.add(new Player("Krzysiek", new HashSet<>() {{
            add("Tzolk'in");
            add("Agricola");
            add("Avalon");
        }}));
        playerData.add(new Player("Ola", new HashSet<>() {{
            add("Blood Rage");
            add("Cyklady");
            add("Puerto Rico");
        }}));

        this.playerData = playerData;
    }

    public List<Player> getPlayerData() {
        return playerData;
    }
}
