package panel;

import service.GameService;

import java.util.Scanner;

public class EntryPanel {

    GameService gameService;

    public EntryPanel(GameService gameService) {
        this.gameService = gameService;
    }



    Scanner scr = new Scanner(System.in);
    String panel = "1";


    public String getPanel()
    {
        switch (panel){
            case "1":
                System.out.println(gameService.getAllGameData());
                break;



        }
        return "1";

    }


}
