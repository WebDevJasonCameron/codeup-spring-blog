package com.codeup.springblog.controllers;

import com.codeup.springblog.models.DiceGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("roll-dice")
public class RollController {

    @GetMapping
    public String showRollPage(){
        return "views-assignment/roll-dice";
    }

    @GetMapping("/{userNum}")
    public String playDiceGame(@PathVariable String userNum, Model model){
        DiceGame diceGame = new DiceGame(userNum);
        DiceGame diceGame2 = new DiceGame(userNum);
        DiceGame diceGame3 = new DiceGame(userNum);

        List<DiceGame> diceGames = new ArrayList<>();

        diceGames.add(gameManager(diceGame));
        diceGames.add(gameManager(diceGame2));
        diceGames.add(gameManager(diceGame3));

        model.addAttribute("userNum", userNum);
        model.addAttribute("diceGames", diceGames);

        // STAND
        return "views-assignment/roll-dice";
    }

    private DiceGame gameManager(DiceGame game){
        game.setThrowNum(Integer.toString(MathController.getRandom(1, 6)));
        if(game.getUserNum().equals(game.getThrowNum())){
            game.setGameOutcome("You Win!!!");
        } else {
            game.setGameOutcome("You did not win.");
        }
        return game;
    }


}  //<--END
