package com.holokazh.retry_402_back.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Triangle")
public class Triangle extends Shape {

    @Column(name = "base", nullable = false)
    public double base;

    @Column(name = "height", nullable = false)
    public double height;

    public Triangle() {}

    public Triangle(int posX, int posY, double base, double height) {
        super(posX, posY);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
