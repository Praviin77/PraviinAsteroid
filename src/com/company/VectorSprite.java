package com.company;

import java.awt.*;

public class VectorSprite {

    Polygon shape, drawShape; // each vectorSprite will have a polygon
    double xPosition, yPosition;
    double xSpeed, ySpeed;
    double angle;
    double ROTATION;
    double THRUST;

    boolean active; // tracks dead/alive status of sprite

    int counter; // increases by 1 with each timer tick

    // Constructor
    public VectorSprite() {

    }

    public void paint(Graphics g) {
        g.drawPolygon(drawShape);
    }

    public void updatePosition() {
        counter ++;

        xPosition += xSpeed;
        yPosition += ySpeed;

        wrapAround();

        int x, y;
        for (int i = 0; i < shape.npoints; i++) {
            // shape.xpoints[i] += xSpeed;
            // shape.ypoints[i] += ySpeed;

            x = (int)Math.round(shape.xpoints[i] * Math.cos(angle) - shape.ypoints[i] * Math.sin(angle));
            y = (int)Math.round(shape.xpoints[i] * Math.sin(angle) + shape.ypoints[i] * Math.cos(angle));

            drawShape.xpoints[i] = x;
            drawShape.ypoints[i] = y;
        }
        drawShape.invalidate();
        drawShape.translate((int)Math.round(xPosition), (int)Math.round(yPosition));
    }

    private void wrapAround() {
        if (xPosition > 900) {
            xPosition = 0;
        }
        if (xPosition < 0) {
            xPosition = 900;
        }
        if (yPosition > 600) {
            yPosition = 0;
        }
        if (yPosition < 0) {
            yPosition = 600;
        }
    }
}
