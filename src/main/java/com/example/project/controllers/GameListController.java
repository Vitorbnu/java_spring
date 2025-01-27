package com.example.project.controllers;

import com.example.project.dto.GameDTO;
import com.example.project.dto.GameListDTO;
import com.example.project.dto.GameMinDTO;
import com.example.project.dto.ReplacementDTO;
import com.example.project.services.GameListService;
import com.example.project.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

   @Autowired
   private GameListService gameListService;
   @Autowired
   private GameService gameService;

   @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> list = gameListService.findAll();
        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){

        List<GameMinDTO> games = gameService.findByList(listId);
        return games;
    }
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());

    }
}
