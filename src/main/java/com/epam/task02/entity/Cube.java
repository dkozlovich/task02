package com.epam.task02.entity;

import com.epam.task02.observer.CubeEvent;
import com.epam.task02.observer.CubeObserver;
import com.epam.task02.observer.Observable;
import com.epam.task02.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Observable {

    private long cubeId;
    private Point center;
    private double edge;
    List<Point> points = new ArrayList<>();
    private final List<CubeObserver> observers = new ArrayList<>();

    public Cube(Point center, double edge) {
        this.cubeId = IdGenerator.generateId();
        this.center = center;
        this.edge = edge;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setCubeId(long cubeId) {
        this.cubeId = cubeId;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObserver();
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
        notifyObserver();
    }

    public long getCubeId() {
        return cubeId;
    }

    @Override
    public void attach(CubeObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(CubeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if (observers.isEmpty()) {
            return;
        }
        CubeEvent event = new CubeEvent(this);
        observers.forEach(observer -> observer.parametersChange(event));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (Double.compare(cube.edge, edge) != 0) return false;
        return center != null ? center.equals(cube.center) : cube.center == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center != null ? center.hashCode() : 0;
        temp = Double.doubleToLongBits(edge);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CubeId = ").append(cubeId);
        stringBuilder.append(", center = ").append(center);
        stringBuilder.append(", edge = ").append(edge);
        return stringBuilder.toString();
    }
}