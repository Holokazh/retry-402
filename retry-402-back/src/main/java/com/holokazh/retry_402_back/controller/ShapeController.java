package com.holokazh.retry_402_back.controller;

import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.model.Shape;
import com.holokazh.retry_402_back.service.ShapeService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/shapes")
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Shape> getShapeById(@PathVariable Long id) {
        Shape form = shapeService.findById(id);
        if (form != null) {
            return ResponseEntity.ok(form);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/add/{level_id}")
    public ResponseEntity<Shape> addShape(@PathVariable Long level_id, @RequestBody Shape shape) {
        return ResponseEntity.ok(shapeService.createAndAddShapeToLevel(level_id, shape));
    }

    @PostMapping(value = "/save/{level_id}")
    public ResponseEntity<Level> saveShapes(@PathVariable Long level_id, @RequestBody List<Shape> shapes) {
        return ResponseEntity.ok(shapeService.createAndSetShapesToLevel(level_id, shapes));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Shape> updateShape(@PathVariable Long id, @RequestBody Shape form) {
        return ResponseEntity.ok(shapeService.updateShape(id, form));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteShape(@PathVariable int id) {
        shapeService.deleteShape(id);
        return ResponseEntity.noContent().build();
    }
}
