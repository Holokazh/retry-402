package com.holokazh.retry_402_back.service;

import com.holokazh.retry_402_back.model.dto.LevelNameDto;
import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.repository.LevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LevelService {

    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public Level updateLevelName(Long id, LevelNameDto levelNameDto) {
        Level level = findById(id);
        level.setName(levelNameDto.getName());
        return levelRepository.save(level);
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

    public boolean deleteLevel(int id) {
        levelRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Level deleteShapesOfLevelId(Long id) {
        Level level = findById(id);
        
        level.clearShapes();

        return levelRepository.save(level);
    }
}
