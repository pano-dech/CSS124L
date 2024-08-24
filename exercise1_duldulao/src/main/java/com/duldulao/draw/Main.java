package com.duldulao.draw;

import com.duldulao.draw.model.Drawing;
import com.duldulao.draw.model.Line;
import com.duldulao.draw.model.Shape;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        drawing.setSize(1024,800);//400 width and 500 height
        drawing.setLayout(null);//using no layout managers
        drawing.setVisible(true);//making the frame visible
    }
}