package com.duldulao.draw.model;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Compound extends Shape{
    List<Shape> shapes;

    public Compound(Point location){
        super(location);
        shapes = new ArrayList<>();
    }
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    @Override
    public void render(Graphics g) {
        for(Shape shape: shapes){
            shape.render(g);;
        }
    }
}
