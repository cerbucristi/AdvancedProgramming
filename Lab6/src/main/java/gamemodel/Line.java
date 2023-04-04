package gamemodel;

import java.awt.*;

public class Line {
    private Vertice vertice1;
    private Vertice vertice2;

    private Color color;
    public Line(Vertice vertice1, Vertice vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public boolean containsVertice(Vertice vertice) {

        double x1 = vertice1.getX();
        double y1 = vertice1.getY();
        double x2 = vertice2.getX();
        double y2 = vertice2.getY();
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        double y = m * vertice.getX() + b;
        double tolerance = 10;
        return Math.abs(y - vertice.getY()) < tolerance;
    }

    public Vertice getVertice1() {
        return vertice1;
    }

    public void setVertice1(Vertice vertice1) {
        this.vertice1 = vertice1;
    }

    public Vertice getVertice2() {
        return vertice2;
    }

    public void setVertice2(Vertice vertice2) {
        this.vertice2 = vertice2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
