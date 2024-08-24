package com.duldulao.draw.model;

import lombok.Data;

import java.awt.*;

@Data
public class Rectangle extends  Shape{
    int width;
    int height;

    public Rectangle(Point location, Point end ){
        super(location);
        width = end.x - location.x;
        height = end.y - location.y;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawRect(location.x,location.y, width, height);
    }

}
