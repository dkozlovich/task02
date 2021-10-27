package com.epam.task02.warehouse.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.filler.WarehouseFiller;
import com.epam.task02.warehouse.CubeParameters;
import com.epam.task02.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static WarehouseImpl instance;
    private final Map<Long, CubeParameters> cubeParameters;


    private WarehouseImpl() {
        cubeParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new WarehouseImpl();
        }
        return instance;
    }

    @Override
    public void putParameters(long cubeId, double volume, double surfaceArea, double diagonal) {
        CubeParameters cubeParameters = new CubeParameters(volume, surfaceArea, diagonal);
        cubeParameters.setSurfaceArea(surfaceArea);
        cubeParameters.setVolume(volume);
        this.cubeParameters.put(cubeId, cubeParameters);
    }

    @Override
    public void putParameters(long cubeId, CubeParameters cubeParameters) {
        this.cubeParameters.put(cubeId, cubeParameters);
    }

    @Override
    public CubeParameters getParameters(long cubeId) {
        return cubeParameters.get(cubeId);
    }

    @Override
    public boolean updateParameters(long cubeId, double volume, double surfaceArea, double diagonal) {
        CubeParameters cubeParameters = this.cubeParameters.get(cubeId);
        if (cubeParameters == null) {
            logger.error("Cube with ID " + cubeId + " is not found.");
            return false;
        }
        cubeParameters.setSurfaceArea(surfaceArea);
        cubeParameters.setVolume(volume);
        cubeParameters.setDiagonal(diagonal);
        return true;
    }

    @Override
    public void updateParameters(Cube cube) {
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillWarehouse(cube);
    }

    @Override
    public CubeParameters removeParameters(long id) {
        return cubeParameters.remove(id);
    }

    @Override
    public Map<Long, CubeParameters> getWarehouse() {
        return new HashMap<Long, CubeParameters>(cubeParameters);
    }
}
