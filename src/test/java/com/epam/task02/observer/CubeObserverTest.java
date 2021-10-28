package com.epam.task02.observer;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.filler.WarehouseFiller;
import com.epam.task02.observer.impl.CubeObserverImpl;
import com.epam.task02.warehouse.CubeParameters;
import com.epam.task02.warehouse.Warehouse;
import com.epam.task02.warehouse.impl.WarehouseImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CubeObserverTest {

    private CubeObserver observer;
    private Cube cube;
    private CubeEvent cubeEvent;
    private Warehouse warehouse;
    private WarehouseFiller warehouseFiller;

    @Before
    public void init() {
        observer = new CubeObserverImpl();
        warehouse = WarehouseImpl.getInstance();
        cube = new Cube(new Point(10,10,10), 15);
        cube.attach(observer);
        cubeEvent = new CubeEvent(cube);
        warehouseFiller = new WarehouseFiller();
        warehouseFiller.fillWarehouse(cube);
    }

    @Test
    public void testParametersChange() {
        observer.parametersChange(cubeEvent);
        CubeParameters result = warehouse.getParameters(cube.getCubeId());
        CubeParameters expected = new CubeParameters(3375, 1350, 25.981);
        Assert.assertEquals(expected, result);
    }
}
