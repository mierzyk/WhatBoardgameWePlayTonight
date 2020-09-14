package model;
import java.util.Set;


public class Player {

    private String name;
    private Set<String> knownGame;

    public Player(String name, Set<String> knownGame) {
        this.name = name;
        this.knownGame = knownGame;
    }
    //PlayerGameKnowledge knowledge;
    //PlayerGamePreferences preferences;

    public String getName(){
        return this.name;
    }

    public Set<String> getKnownGame(){
        return this.knownGame;
    }


}
