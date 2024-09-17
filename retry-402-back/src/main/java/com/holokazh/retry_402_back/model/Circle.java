package com.holokazh.retry_402_back.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Circle")
public class Circle extends Shape {

    @Column(name = "radius", nullable = false)
    public double radius;

    public Circle() {
    }

    public Circle(int posX, int posY, double radius) {
        super(posX, posY);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
