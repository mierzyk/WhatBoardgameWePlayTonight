package service;

import model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameService {

    private Set<Game> gameData;

    public GameService(Set<Game> gameData) {
        this.gameData = gameData;
    }

    public String getAllGameData() {

        String gameSetText = String.format("%-20s", "Game Name") + String.format("%-12s", "Min players") + String.format("%-12s", "Max players") + String.format("%-12s", "Minutes per player") + "\n";

        for (Game singleGame : gameData) {
            gameSetText += String.format("%-20s", singleGame.getName()) + String.format("%-12s", singleGame.getMinPlayers())
                    + String.format("%-12s", singleGame.getMaxPlayers()) + String.format("%-12s", singleGame.getMinutesPerPlayer()) + "\n";
        }

        return gameSetText;
    }

    public void setNewGame(String name, int minPlayers, int maxPlayers, int minutesPerPlayer) {
        gameData.add(new Game(name, minPlayers, maxPlayers, minutesPerPlayer));
    }

    public ArrayList<String> getGames() {
        ArrayList<String> tempGames = new ArrayList<>();
        for (Game singleGame : gameData) {
            tempGames.add(singleGame.getName());
        }
        return tempGames;
    }

    public String checkGameExistance(List<String> game) {
        String nonUnique = "";
        for (String singleGameInput : game)
            for (Game singleGame : gameData) {
                //System.out.println(singleGame.getName());
                if (singleGameInput.equals(singleGame.getName())) {
                    nonUnique = singleGameInput;
                    break;
                }
            }
        return nonUnique;
    }

    public boolean gameUniqunessCheck(String gameName) {
        boolean duplicatedName = false;
        for (Game singleGame : gameData) {
            if (singleGame.getName().equals(gameName)) {
                duplicatedName = true;
                break;
            }
        }
        return duplicatedName;
    }


}
