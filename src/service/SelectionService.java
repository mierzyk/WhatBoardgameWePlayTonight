package service;

import model.Game;
import model.Player;

import java.util.*;

public class SelectionService {

    private Set<Game> gameData;
    private List<Player> playerData;

    public SelectionService(Set<Game> gameData, List<Player> playerData) {
        this.gameData = gameData;
        this.playerData = playerData;
    }


    public void getRecommendedKnown(Set<String> name, int minutesForGame) {
        List<Player> subsetPlayerData = new ArrayList<>();
        List<String> allGame = new ArrayList<>();
        List<String> mostPlayed = new ArrayList<>();
        Map<String, Integer> knownGamesNumber = new HashMap<>();
        int mostGameNumber = 0;
        int tempMostGameNumber;
        int numberOfPlayers = name.size();
        Integer tempKnownGameNumber;

        for (String singleName : name) {
            for (Player singlePlayer : playerData) {
                if (singleName.equals(singlePlayer.getName())) {
                    for (Game singleGame : gameData) {
                        if (singleGame.getMinPlayers() <= numberOfPlayers
                                && singleGame.getMaxPlayers() >= numberOfPlayers
                                && singleGame.getMinutesPerPlayer() * name.size() <= minutesForGame
                        ) {
                            subsetPlayerData.add(singlePlayer);
                            allGame.addAll(singlePlayer.getKnownGame());
                            break;
                        }
                    }
                }
            }
        }

        HashSet<String> uniqueGame = new HashSet<>(allGame);

        for (String singleGame : uniqueGame) {
            tempMostGameNumber = 0;
            for (String oneGame : allGame) {
                if (singleGame.equals(oneGame)) {
                    tempMostGameNumber++;
                }
            }
            if (tempMostGameNumber > mostGameNumber) {
                mostPlayed.clear();
                mostPlayed.add(singleGame);
                mostGameNumber = tempMostGameNumber;
            } else if (tempMostGameNumber == mostGameNumber) {
                mostPlayed.add(singleGame);
            }
        }

        if (mostPlayed.isEmpty()) {
            System.out.println("No games meet parameters.");
        } else {
            System.out.println("Most frequently known game for party of");
            System.out.println(name);
            System.out.println("is ");
            System.out.println(mostPlayed);
        }
        for (Game singleGame : gameData) {
            if (!uniqueGame.equals(singleGame)) {
                knownGamesNumber.put(singleGame.getName(), 0);
            }
        }


        for (String singleGame : knownGamesNumber.keySet()) {
            for (String singleKnownGame : allGame) {
                if (singleGame.equals(singleKnownGame)) {
                    tempKnownGameNumber = knownGamesNumber.get(singleGame);
                    knownGamesNumber.replace(singleGame, tempKnownGameNumber + 1);
                }
            }
        }


        ArrayList<String> leastPlayed = new ArrayList<>();
        int peopleKnownGames = 0;

        for (int i = 0; i < knownGamesNumber.size(); i++) {
            if (leastPlayed.size() == 0) {
                for (String snigleGame : knownGamesNumber.keySet()) {
                    if (knownGamesNumber.get(snigleGame) == i) {
                        leastPlayed.add(snigleGame);
                        peopleKnownGames = i;
                    }
                }
            }
        }


        System.out.println("least frequently known game for party of");
        System.out.println(name);
        System.out.println("is ");
        System.out.println(leastPlayed);


    }
}

