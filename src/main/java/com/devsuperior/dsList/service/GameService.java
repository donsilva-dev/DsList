package com.devsuperior.dsList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsList.dto.GameDTO;
import com.devsuperior.dsList.dto.GameMinDTO;
import com.devsuperior.dsList.entities.Game;
import com.devsuperior.dsList.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return  new GameDTO(result);
		
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(game -> new GameMinDTO(game)).toList();

	}
}
