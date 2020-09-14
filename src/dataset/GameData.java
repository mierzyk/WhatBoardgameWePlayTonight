package dataset;

import model.Game;
import java.util.*;

public class GameData {

    private Set<Game> gamesData;

    public GameData() {
        gamesData = new HashSet<>();
        gamesData.add(new Game("Agricola", 1, 5, 30));
        gamesData.add(new Game("Puerto Rico", 2, 5, 20));
        gamesData.add(new Game("Scythe", 2, 7, 25));
        gamesData.add(new Game("Avalon", 5, 10, 5));
        gamesData.add(new Game("Captain Sonar", 6, 8, 5));
        gamesData.add(new Game("Zimna Wojna", 2, 2, 70));
        gamesData.add(new Game("Small World", 2, 5, 15));
        gamesData.add(new Game("Alchemicy", 2, 4, 20));
        gamesData.add(new Game("Teotihuacan", 2, 4, 25));
        gamesData.add(new Game("Terra Mystica", 2, 5, 30));
        gamesData.add(new Game("Blood Rage", 2, 5, 20));
        gamesData.add(new Game("Descent", 2, 5, 40));
        gamesData.add(new Game("Siedem Cudów Swiata", 2, 8, 10));
        gamesData.add(new Game("Cyklady", 2, 6, 20));
        gamesData.add(new Game("Tzolk'in", 2, 6, 20));
        this.gamesData = gamesData;
    }

    public Set<Game> getGameData() {
        return this.gamesData;
    }


}
