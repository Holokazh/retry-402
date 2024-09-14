package com.holokazh.retry_402_back.service;

import com.holokazh.retry_402_back.model.Form;
import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.repository.FormRepository;
import com.holokazh.retry_402_back.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> findAll() {
        return levelRepository.findAll();
    }

    public Level findById(Long id) {
        return levelRepository.findById(id);
    }

    public Level addLevel(Level level) {
        return levelRepository.save(level);
    }

    public Level updateLevel(int id, Level level) {
        level.setId(id);
        return levelRepository.save(level);
    }

    public void deleteLevel(int id) {
        levelRepository.deleteById(id);
    }
}
