package com.duldulao.draw.model;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Chain extends  Shape{
    List<Point> points;

    public Chain(Point location){
        super(location);
        points = new ArrayList<>();
    }

    void addChain(Point location){
        points.add(location);
    }
    @Override
    public void render(Graphics g) {

    }
}
