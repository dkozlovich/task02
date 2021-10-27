package com.epam.task02.warehouse;

import com.epam.task02.entity.Cube;

import java.util.Map;

public interface Warehouse {

    void putParameters(long cubeId, double volume, double surfaceArea, double diagonal);

    void putParameters(long cubeId, CubeParameters cubeParameters);

    CubeParameters getParameters(long cubeId);

    boolean updateParameters(long cubeId, double volume, double surfaceArea, double diagonal);

    void updateParameters(Cube cube);

    CubeParameters removeParameters(long id);

    Map<Long, CubeParameters> getWarehouse();

}
