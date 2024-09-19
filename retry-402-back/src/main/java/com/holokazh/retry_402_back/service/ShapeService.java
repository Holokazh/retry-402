package com.holokazh.retry_402_back.service;

import com.holokazh.retry_402_back.model.Shape;
import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.repository.ShapeRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;
    private final LevelService levelService;

    public ShapeService(ShapeRepository shapeRepository, LevelService levelService) {
        this.shapeRepository = shapeRepository;
        this.levelService = levelService;
    }

    public Shape findById(Long id) {
        return shapeRepository.findById(id);
    }

    public Shape createAndAddShapeToLevel(Long levelID,Shape form) {
        Level level = levelService.findById(levelID);
        level.addShape(form);
        return shapeRepository.save(form);
    }

    public Level createAndSetShapesToLevel(Long levelID, List<Shape> shapes) {
        Level level = levelService.findById(levelID);
        level.clearShapes();
        level.addShapes(shapes);
        shapeRepository.saveAll(shapes);
        return level;
    }

    public Shape updateShape(Long id, Shape shape) {
        shape.setId(id);
        return shapeRepository.save(shape);
    }

    public boolean deleteShape(int id) {
        shapeRepository.deleteById(id);
        return true;
    }
}
