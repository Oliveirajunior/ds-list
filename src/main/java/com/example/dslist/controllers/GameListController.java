package com.example.dslist.controllers;

import com.example.dslist.dto.GameDto;
import com.example.dslist.dto.GameListDto;
import com.example.dslist.dto.GameMinDto;
import com.example.dslist.services.GameListService;
import com.example.dslist.services.GameService;
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
    public List<GameListDto> findAll(){
        List<GameListDto> result = gameListService.findAll();
        return result;
    }
}
