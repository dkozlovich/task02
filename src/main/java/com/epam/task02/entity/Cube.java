package com.epam.task02.entity;

import com.epam.task02.util.IdGenerator;

public class Cube {

    private long cubeId;
    private Point center;
    private double edge;

    public Cube(Point center, double edge) {
        this.cubeId = IdGenerator.generate();
        this.center = center;
        this.edge = edge;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public long getCubeId() {
        return cubeId;
    }
}