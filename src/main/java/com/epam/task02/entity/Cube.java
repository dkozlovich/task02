package com.epam.task02.entity;

import com.epam.task02.util.IdGenerator;

public class Cube {

    private long cubeId;
    private Point center;
    private double edge;

    public Cube(Point center, double edge) {
        this.cubeId = IdGenerator.generateId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (cubeId != cube.cubeId) return false;
        if (Double.compare(cube.edge, edge) != 0) return false;
        return center != null ? center.equals(cube.center) : cube.center == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (cubeId ^ (cubeId >>> 32));
        result = 31 * result + (center != null ? center.hashCode() : 0);
        temp = Double.doubleToLongBits(edge);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}