package com.holokazh.retry_402_back.controller;

import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.model.dto.LevelDto;
import com.holokazh.retry_402_back.service.LevelService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/levels")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping
    public List<Level> getLevels() {
        return levelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable Long id) {
        Level level = levelService.findById(id);
        if (level != null) {
            return ResponseEntity.ok(level);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Level> addLevel(@RequestBody Level level) {
        return new ResponseEntity<>(levelService.addLevel(level), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Level> updateLevel(@PathVariable Long id, @RequestBody LevelDto levelDto) {
        Level updatedLevel = levelService.updateLevelName(id, levelDto);
        if (updatedLevel != null) {
            return ResponseEntity.ok(updatedLevel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable int id) {
        boolean deleted = levelService.deleteLevel(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteAllShapes/{id}")
    public ResponseEntity<Level> deleteShapesOfLevel(@PathVariable Long id) {
        Level levelWithShapesDeleted = levelService.deleteShapesOfLevelId(id);
        if (levelWithShapesDeleted.getShapes().isEmpty()) {
            return new ResponseEntity<>(levelWithShapesDeleted, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
