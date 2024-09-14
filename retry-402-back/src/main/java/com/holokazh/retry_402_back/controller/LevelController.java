package com.holokazh.retry_402_back.controller;

import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.service.LevelService;
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

    @PostMapping
    public ResponseEntity<Level> addLevel(@RequestBody Level level) {
        return ResponseEntity.ok(levelService.addLevel(level));
    }
}
