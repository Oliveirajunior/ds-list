package com.example.dslist.services;

import com.example.dslist.dto.GameDto;
import com.example.dslist.dto.GameListDto;
import com.example.dslist.dto.GameMinDto;
import com.example.dslist.entities.Game;
import com.example.dslist.entities.GameList;
import com.example.dslist.repositories.GameListRepository;
import com.example.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDto> dto = result.stream().map(GameListDto::new).toList();
        return dto;
    }
}
