package application;
import dataset.GameData;
import dataset.PlayerData;
import model.Game;
import model.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.GameService;
import service.PlayerService;
import service.SelectionService;

import java.util.List;
import java.util.Set;


@Configuration
@ComponentScan("Program")

public class GameConfig {

    @Bean
    public Set<Game> gameData()
    {
        return new GameData().getGameData();
    }

    @Bean
    public List<Player> playerData()
    {
        return new PlayerData().getPlayerData();
    }

    @Bean
    public PlayerService playerServices() {return new PlayerService(playerData());}

    @Bean
    public GameService gameServices() {return new GameService(gameData());}

    @Bean
    public SelectionService selectionServices() {return new SelectionService(gameData(),playerData());}



}
