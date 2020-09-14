package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.GameService;
import service.PlayerService;
import service.SelectionService;


import java.util.*;

public class Application {

    public static void main (String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        //GameSet gameSet = context.getBean("gameSet", GameSet.class);
        //PlayerSet playerSet = context.getBean("playerSet", PlayerSet.class);
        //EntryPanel entryPanel = context.getBean("entryPanel", EntryPanel.class);
        GameService gameService = context.getBean("gameServices", GameService.class);
        PlayerService playerService = context.getBean( "playerServices", PlayerService.class);
        SelectionService selectionService = context.getBean("selectionServices", SelectionService.class);





        Scanner scr = new Scanner(System.in).useDelimiter("\n");
        boolean continueLoop = true;
        String tempGameName;
        String panel;
        String tempGameMinPlayer;
        String tempGameMaxPlayer;
        String tempGameMinutesPerPlayer;
        String tempPlayerName;


        Set<String> tempArrayGame;


        while(continueLoop) {
            System.out.println("What would you like to do? \n"
                    + "Type in:\n"
                    + "1 to show all games details\n"
                    + "2 to check existing games list\n"
                    + "3 to check existing player list\n"
                    + "4 to add new game and its paramters\n"
                    + "5 to add new player and games he/she already knows\n"
                    + "6 to check known games of a player\n"
                    + "7 to create a party\n"
                    + "8 to end program");
            panel = scr.next();

            switch (panel) {
                case "1":
                    System.out.println(gameService.getAllGameData());
                    break;
                case "2":
                    System.out.println(gameService.getGames());
                    break;
                case "3":
                    System.out.println(playerService.getPlayer());
                    break;
                case "4":
                    System.out.println("provide new game name");
                    tempGameName = scr.next();

                    if(gameService.gameUniqunessCheck(tempGameName))
                    {
                        System.out.println("That game already exists.");
                        break;
                    }
                    System.out.println("provide new game minimum number of players");
                    tempGameMinPlayer = scr.next();
                    System.out.println("provide new game maximum number of players");
                    tempGameMaxPlayer = scr.next();
                    System.out.println("provide new game minutes per player");
                    tempGameMinutesPerPlayer = scr.next();
                    try {
                        gameService.setNewGame(tempGameName, Integer.parseInt(tempGameMinPlayer), Integer.parseInt(tempGameMaxPlayer), Integer.parseInt(tempGameMinutesPerPlayer));
                        System.out.println("New game added successfully.");
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Adding new game failed. \nMinimum players, maximum players and minutes per player must be numeric.");
                    }
                    break;
                case "5":
                    System.out.println("Provide new player name");
                    tempPlayerName = scr.next();
                    if(playerService.playerUniqunessCheck(tempPlayerName))
                    {
                        System.out.println("That player already exists. Update his known games list or add other player");
                        break;
                    };
                    System.out.println("Provide comma-separated game list of a player without spacebars");
                    tempGameName = scr.next();
                    tempArrayGame = new HashSet<String>(Arrays.asList(tempGameName.split(",")));
                    System.out.println(tempArrayGame);
                    /*if(!gameServices.checkGameExistance(tempArrayGame).equals(""))
                    {
                        System.out.println("Following game does not exist on game list\n"
                                + gameServices.checkGameExistance(tempArrayGame)
                                + "\nPlease add the game to game list first.");
                        break;
                    }*/
                    playerService.setNewPlayer(tempPlayerName, tempArrayGame);
                    break;
                case "6":
                    System.out.println("provide name of a player you want to check known games");
                    tempPlayerName = scr.next();
                    if(playerService.getKnownGame(tempPlayerName).size()==0)
                    {
                        System.out.println("There are no games assigned to that player or that player does not exist");
                        break;
                    }
                    System.out.println(playerService.getKnownGame(tempPlayerName));
                    break;
                case "7":
                    System.out.println("provide comma-players");
                    tempGameName = scr.next();
                    tempArrayGame = new HashSet<String>(Arrays.asList(tempGameName.split(",")));

                    selectionService.getRecommendedKnown(tempArrayGame);
                    break;
                case "8":
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }

        }

    }
}
