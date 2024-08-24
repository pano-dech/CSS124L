package com.duldulao.draw.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Drawing extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    Color currentColor;;
    DrawMode drawMode;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JMenuItem  chooseColormenuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    Space space;
    Point start;
    Point lastPoint;
    MouseStatus mouseState;

    JMenuItem lineMenuItem;
    JMenuItem circleMenuItem;
    JMenuItem rectmenuItem;
    public Drawing(){
        currentColor = Color.black;
        createMenu();
        drawMode = DrawMode.Circle;
        space = new Space();
        mouseState = MouseStatus.Released;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        lineMenuItem.addActionListener(this);
        circleMenuItem.addActionListener(this);
        rectmenuItem.addActionListener(this);
        chooseColormenuItem.addActionListener(this);

    }
    public void paint(Graphics g) {
        super.paint(g);
        for(Shape shape :space.shapes) {
            shape.render(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(mouseState == MouseStatus.Released) {
            start = e.getPoint();
            lastPoint = start;
            getGraphics().setColor(Color.black);

            if(drawMode == DrawMode.Line) {
                new Line(start, lastPoint).render(getGraphics());
            }
            else if(drawMode == DrawMode.Circle) {
                new Circle(start, lastPoint).render(getGraphics());
            }
            else if(drawMode == DrawMode.Rectangle) {
                new Rectangle(start, lastPoint).render(getGraphics());
            }


            //getGraphics().drawLine((int)start.getX(),(int)start.getY(),(int)lastPoint.getX(),(int) lastPoint.getY());
            mouseState = MouseStatus.Pressed;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseState = MouseStatus.Released;
        getGraphics().setXORMode(Color.WHITE);
        space.shapes.add(new Line(start,lastPoint));
        lastPoint = e.getPoint();
        if(drawMode == DrawMode.Line) {
            Line line = new Line(start, lastPoint);
                    line.setColor(currentColor);
            space.shapes.add(line);

        }
        if(drawMode == DrawMode.Circle) {
            space.shapes.add(new Circle(start, lastPoint));
        }
        if(drawMode == DrawMode.Rectangle) {
            space.shapes.add(new Rectangle(start, lastPoint));

        }

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(mouseState == MouseStatus.Pressed) {
            Graphics  g = getGraphics();
            if(drawMode == DrawMode.Line) {
                new Line(start, lastPoint).render(getGraphics());
                new Line(start, e.getPoint()).render(getGraphics());
            }
            if(drawMode == DrawMode.Circle) {
                new Circle(start, lastPoint).render(getGraphics());
                new Circle(start, e.getPoint()).render(getGraphics());
            }
            if(drawMode == DrawMode.Rectangle) {
                new Rectangle(start, lastPoint).render(getGraphics());
                new Rectangle(start, e.getPoint()).render(getGraphics());
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    void createMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription(
            "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("New", KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Open", KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Save", KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Save As", KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Close", KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Open",
                                         new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        menu = new JMenu("Shape");
        menu.setMnemonic(KeyEvent.VK_S);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

        lineMenuItem = new JMenuItem("Line");
        menu.add(lineMenuItem );

        circleMenuItem  = new JMenuItem("Circle");
        menu.add(circleMenuItem );

        rectmenuItem = new JMenuItem("Rectangle");
        menu.add(rectmenuItem );

        menuItem = new JMenuItem("Ellipse");
        menu.add(menuItem );

        menuItem = new JMenuItem("Link");
        menu.add(menuItem );

        submenu = new JMenu("Color");
        submenu.add(menuItem);
        menu.add(submenu);


        //Build second menu in the menu bar.
        menu = new JMenu("Attributes");
        menu.setMnemonic(KeyEvent.VK_N);

        chooseColormenuItem = new JMenuItem("Choose Color");
        menu.add(chooseColormenuItem );

        menuBar.add(menu);

        submenu = new JMenu("Color");
        submenu.add(menuItem);
        menu.add(submenu);

        menuItem = new JMenuItem("Red");
        submenu.add(menuItem);

        menuItem = new JMenuItem("Black");
        submenu.add(menuItem);

        menuItem = new JMenuItem("White");
        submenu.add(menuItem);

        menu.add(submenu);

        this.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == circleMenuItem){
            drawMode = DrawMode.Circle;
        }
        else if(e.getSource() == lineMenuItem){
            drawMode = DrawMode.Line;
        }
        else if(e.getSource() == rectmenuItem){
            drawMode = DrawMode.Rectangle;
        }
        else if(e.getSource() == chooseColormenuItem){
            currentColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
            getGraphics().setColor(currentColor);
        }

    }
}