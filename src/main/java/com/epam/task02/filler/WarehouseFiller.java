package com.epam.task02.filler;

import com.epam.task02.entity.Cube;
import com.epam.task02.service.CubeService;
import com.epam.task02.service.impl.CubeServiceImpl;
import com.epam.task02.warehouse.Warehouse;
import com.epam.task02.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillWarehouse(List<Cube> cubes) {
        for (Cube cube : cubes) {
            fillWarehouse(cube);
        }
    }

    public void fillWarehouse(Cube cube) {
        CubeService cubeService = CubeServiceImpl.getInstance();
        Warehouse warehouse = WarehouseImpl.getInstance();
        double volume = cubeService.findVolume(cube);
        double surfaceArea = cubeService.findSurfaceArea(cube);
        double diagonal = cubeService.findDiagonal(cube);
        warehouse.putParameters(cube.getCubeId(), volume, surfaceArea, diagonal);
        logger.info("Cube parameters added to warehouse. Cube: " + cube);
    }

}
