package com.example.dslist.services;

import com.example.dslist.dto.GameDto;
import com.example.dslist.dto.GameMinDto;
import com.example.dslist.entities.Game;
import com.example.dslist.projections.GameMinProjection;
import com.example.dslist.repositories.GameListRepository;
import com.example.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(GameMinDto::new).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDto(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {
        List<GameMinProjection> result = gameListRepository.searchByList(listId);
        return result.stream().map(GameMinDto::new).toList();
    }




}
