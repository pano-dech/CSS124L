package com.duldulao.draw.model;

import lombok.Data;

import java.awt.*;

@Data
public class Circle extends Shape {
    Point end;
    public Circle(Point location, int radius){
        super(location);
        this.end.x = location.x + radius;
        this.end.y = location.y;
    }

    public Circle(Point location, Point end){
        super(location);
        this.end = end;
    }

    @Override
    public void render(Graphics g) {
         int radius = (int)Math.sqrt((double)((end.x - location.x) * (end.x - location.x) + (end.y - location.y) * (end.y - location.y)));
        g.drawOval(location.x, location.y, 2 * radius, 2 * radius);
    }
}
