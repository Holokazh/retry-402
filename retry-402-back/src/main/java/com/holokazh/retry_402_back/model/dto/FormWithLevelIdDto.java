package com.holokazh.retry_402_back.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class FormWithLevelIdDto {
    private Long id;
    private String color;
    private int posX;
    private int posY;
    private String type;
    private Long level_id;
    private double radius;
    private double side;
    private double base;
    private double height;
}
