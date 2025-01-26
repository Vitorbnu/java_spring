package com.example.project.controllers;

import com.example.project.dto.GameDTO;
import com.example.project.dto.GameListDTO;
import com.example.project.dto.GameMinDTO;
import com.example.project.services.GameListService;
import com.example.project.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

   @Autowired
   private GameListService gameListService;

   @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> list = gameListService.findAll();
        return list;
    }
}
