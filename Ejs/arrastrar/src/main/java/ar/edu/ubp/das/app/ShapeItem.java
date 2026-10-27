package ar.edu.ubp.das.app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class ShapeItem {

    Rectangle2D shape1;
    Ellipse2D shape2;

    int x;
    int y;
    int height = 100;
    int width = 100;

    public ShapeItem() {
        shape1 = new Rectangle2D.Double(1, 1, width, height);
        shape2 = new Ellipse2D.Double(1, 1, width, height);
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
