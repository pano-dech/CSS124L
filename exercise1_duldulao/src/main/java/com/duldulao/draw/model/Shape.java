package com.duldulao.draw.model;

import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
public abstract class Shape {
    protected Point location;
    public Shape(Point location){
        this.location = location;
    }
    Color color;
    boolean visible;
    List<Shape> shapes;
    public abstract void render(Graphics g);
}
