package ar.edu.ubp.das.app;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RectangularShape;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class App extends Canvas implements MouseMotionListener {

    ShapeItem shape;

    boolean isMoving = false;
    int prevX;
    int prevY;

    Color c;
    Random random;

    public App() {
        random = new Random();
        shape = new ShapeItem();

        addMouseMotionListener(this);

        JFrame frame = new JFrame("Arrastra la figura");
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    public void paint(Graphics g) {
        c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        RectangularShape rs;
        if(random.nextInt(256) % 2 == 0) {
            rs = shape.shape1;
            this.shape.paint(g, rs, c);
        }
        else {
            rs = shape.shape2;
            this.shape.paint(g, rs, c);
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isMoving) {
            RectangularShape rs;
            if(random.nextInt(256) % 2 == 0) {
                rs = shape.shape1;
            }
            else {
                rs = shape.shape2;
            }

            if (shape.isInside(rs, e)) {
                prevX = e.getX();
                prevY = e.getY();
                isMoving = true;
            }
        }
        else {
            shape.x = (shape.x + e.getX()) - prevX;
            shape.y = (shape.y + e.getY()) - prevY;

            prevX = e.getX();
            prevY = e.getY();

            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        isMoving = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }

}