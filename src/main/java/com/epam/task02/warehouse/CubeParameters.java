package com.epam.task02.warehouse;

public class CubeParameters {
    private double volume;
    private double surfaceArea;
    private double diagonal;

    public CubeParameters(double volume, double surfaceArea, double diagonal) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
        this.diagonal = diagonal;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CubeParameters that = (CubeParameters) o;

        if (Double.compare(that.volume, volume) != 0) return false;
        if (Double.compare(that.surfaceArea, surfaceArea) != 0) return false;
        return Double.compare(that.diagonal, diagonal) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(surfaceArea);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(diagonal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Volume = ").append(volume);
        stringBuilder.append(", surface area = ").append(surfaceArea);
        stringBuilder.append(", diagonal = ").append(diagonal);
        return stringBuilder.toString();
    }
}
