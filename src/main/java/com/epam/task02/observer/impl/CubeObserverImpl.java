package com.epam.task02.observer.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.observer.CubeEvent;
import com.epam.task02.observer.CubeObserver;
import com.epam.task02.service.CubeService;
import com.epam.task02.service.impl.CubeServiceImpl;
import com.epam.task02.warehouse.Warehouse;
import com.epam.task02.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserverImpl implements CubeObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parametersChange(CubeEvent event) {
        CubeService cubeService = CubeServiceImpl.getInstance();
        Cube cube = event.getSource();
        double surfaceArea = cubeService.findSurfaceArea(cube);
        double volume = cubeService.findVolume(cube);
        double diagonal = cubeService.findDiagonal(cube);
        Warehouse warehouse = WarehouseImpl.getInstance();
        if (warehouse.updateParameters(cube.getCubeId(), volume, surfaceArea, diagonal)) {
            logger.info("Warehouse was updated. Cube: " + cube);
        } else {
            logger.error("Warehouse is not updated. Cube: " + cube);
        }
    }
}
