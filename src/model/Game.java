package model;

public class Game {

    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int minutesPerPlayer;
    //public GameExpansion gameExpansion;

    public Game(String name, int minPlayers, int maxPlayers, int minutesPerPlayer)
    {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.minutesPerPlayer = minutesPerPlayer;
        //this.gameExpansion = gameExpansion;//todo develop game expansion mechanism
    }

    public String getName()
    {
        return this.name;
    }

    public int getMinPlayers()
    {
        return this.minPlayers;
    }

    public int getMaxPlayers()
    {
        return this.maxPlayers;
    }

    public int getMinutesPerPlayer()
    {
        return this.minutesPerPlayer;
    }


}
