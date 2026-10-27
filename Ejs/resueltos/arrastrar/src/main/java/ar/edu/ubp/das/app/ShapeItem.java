package ar.edu.ubp.das.app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class ShapeItem {

    private RectangularShape shape;

    private int x;
    private int y;
    private int height = 100;
    private int width = 100;

    public RectangularShape getShape() {
        return shape;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ShapeItem(RectangularShape shape) {
        this.shape = shape;
    }

    public void paint(Graphics g, RectangularShape shape, Color c) {
        shape.setFrame(x, y, width, height);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(c);
        g2.fill(shape);
        g2.dispose();
    }

    public boolean isInside(RectangularShape shape, MouseEvent e) {
        if (shape.contains(e.getPoint())) {
            return true;
        }
        return false;
    }

}
