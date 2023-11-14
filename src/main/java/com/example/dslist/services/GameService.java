package com.example.dslist.services;

import com.example.dslist.dto.GameMinDto;
import com.example.dslist.entities.Game;
import com.example.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(GameMinDto::new).toList();
        return dto;
    }
}
