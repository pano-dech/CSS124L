package com.duldulao.draw.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Space {
    public Space(){
        shapes = new ArrayList<Shape>();
    }
    List<Shape> shapes;
    void add(Shape shape){
        shapes.add(shape);
    }
}
