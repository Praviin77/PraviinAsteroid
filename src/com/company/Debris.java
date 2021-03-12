package com.company;

import java.awt.*;

public class Debris extends VectorSprite{

    public Debris(double x, double y) {
        shape = new Polygon();

        shape.addPoint(1, 1);
        shape.addPoint(-1, 1);
        shape.addPoint(-1, -1);
        shape.addPoint(1, -1);

        drawShape = new Polygon();

        drawShape.addPoint(1, 1);
        drawShape.addPoint(-1, 1);
        drawShape.addPoint(-1, -1);
        drawShape.addPoint(1, -1);

        xPosition = x;
        yPosition = y;
        THRUST = 10;

        double h, a;
        h = Math.random() + 1;
        a = Math.random() * (2 * Math.PI);
        xSpeed = Math.cos(a) * h;
        ySpeed = Math.sin(a) * h;

        active = true;
    }
}
