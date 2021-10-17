package com.epam.task02.warehouse;

import com.epam.task02.exception.CubeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Long, CubeParameters> cubeParameters;

    private Warehouse() {
        cubeParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(long cubeId, double surfaceArea, double volume) {
        CubeParameters cubeParameters = new CubeParameters();
        cubeParameters.setSurfaceArea(surfaceArea);
        cubeParameters.setVolume(volume);
        this.cubeParameters.put(cubeId, cubeParameters);
    }

    public void putParameters(long cubeId, CubeParameters cubeParameters) {
        this.cubeParameters.put(cubeId, cubeParameters);
    }

    public CubeParameters getParameters(long cubeId) {
        return cubeParameters.get(cubeId);
    }

    public boolean updateParameters(long cubeId, double surfaceArea, double volume) {
        CubeParameters cubeParameters = this.cubeParameters.get(cubeId);
        if (cubeParameters == null) {
            logger.error("Cube with such ID is not found.");
            return false;
        }
        cubeParameters.setSurfaceArea(surfaceArea);
        cubeParameters.setVolume(volume);
        return true;
    }
}
