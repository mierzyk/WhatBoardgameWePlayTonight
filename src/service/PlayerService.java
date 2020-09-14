package service;

import model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerService {

    private List<Player> playerData;

    public PlayerService(List<Player> playerData) {
        this.playerData = playerData;
    }

    public Set<String> getKnownGame(String name) {
        Set<String> tempPlayerList = new HashSet<>();

        for (Player singlePlayer : playerData) {
            if (singlePlayer.getName().equals(name))
                tempPlayerList = (singlePlayer.getKnownGame());
            break;
        }
        return tempPlayerList;
    }

    public List<String> getPlayer() {
        ArrayList<String> tempPlayerList = new ArrayList<>();

        for (Player singlePlayer : playerData) {
            tempPlayerList.add(singlePlayer.getName());
        }

        return tempPlayerList;
    }

    public boolean playerUniqunessCheck(String name) {
        boolean duplicatedName = false;
        for (Player singlePlayer : playerData) {
            if (singlePlayer.getName().equals(name)) {
                duplicatedName = true;
                break;
            }
        }
        return duplicatedName;
    }

    public void setNewPlayer(String name, Set<String> gameList) {
        playerData.add(new Player(name, gameList));
    }

    public boolean playerExistanceCheck(String name) {
        boolean returner = false;

        for (Player singlePlayer : playerData) {
            if (singlePlayer.equals(name)) {
                returner = true;
                break;
            }
        }

        return returner;

    }
}
