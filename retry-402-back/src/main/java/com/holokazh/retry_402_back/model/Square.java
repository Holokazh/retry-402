package com.holokazh.retry_402_back.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Square")
public class Square extends Shape {

    @Column(name = "side", nullable = false)
    public double side;

    public Square() {
    }

    public Square(int posX, int posY, double side) {
        super(posX, posY);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
