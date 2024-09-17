package com.holokazh.retry_402_back.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", referencedColumnName = "id", nullable = false)
    private List<Shape> shapes;

    public Level() {
    }

    public Level(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void addShapes(List<Shape> listShapes) {
        this.shapes.addAll(listShapes);
    }

    public void clearShapes() {
        this.shapes.clear();
    }

    public void setShapes(List<Shape> listShapes) {
        this.shapes = listShapes;
    }

    public List<Shape> getShapes() {
        return this.shapes;
    }
}
