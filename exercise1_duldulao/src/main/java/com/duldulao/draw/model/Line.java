package com.duldulao.draw.model;

import lombok.Data;

import java.awt.*;
import java.awt.geom.Line2D;

@Data
public class Line extends Shape{
    Point end;

    public Line(Point start, Point end) {
        super(start);;
        this.end = end;
    }

    @Override
    public void render(Graphics g) {
        g.drawLine(location.x, location.y, end.x, end.y);
    }
}
