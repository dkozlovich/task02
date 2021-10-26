package com.epam.task02.warehouse;

public interface Warehouse {

    void putParameters(long cubeId, double volume, double surfaceArea, double diagonal);

    void putParameters(long cubeId, CubeParameters cubeParameters);

    CubeParameters getParameters(long cubeId);

    boolean updateParameters(long cubeId, double volume, double surfaceArea, double diagonal);

}
