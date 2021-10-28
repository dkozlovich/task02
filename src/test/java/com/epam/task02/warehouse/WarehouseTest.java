package com.epam.task02.warehouse;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.warehouse.impl.WarehouseImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WarehouseTest {

    private Warehouse warehouse = WarehouseImpl.getInstance();;
    private Map<Long,CubeParameters> expectedMap;
    private CubeParameters expectedParameters;
    private CubeParameters parameters;
    private long id;

    @Before
    public void init() {
        warehouse.removeAllParameters();
        expectedMap = new HashMap<>();
        parameters = new CubeParameters(27, 54, 5.196152);
        expectedParameters = new CubeParameters(27, 54, 5.196152);
        id = 1;
        expectedMap.put(id, expectedParameters);
    }

    @Test
    public void testPutParameters() {
        warehouse.putParameters(id, parameters);
        Map<Long, CubeParameters> result = WarehouseImpl.getInstance().getWarehouse();
        Assert.assertEquals(expectedMap, result);
    }

    @Test
    public void testGetParameters() {
        warehouse.putParameters(id, parameters);
        CubeParameters result = warehouse.getParameters(1);
        Assert.assertEquals(expectedParameters, result);
    }

    @Test
    public void testUpdateParameters() {
        warehouse.putParameters(id, parameters);
        Cube cube = new Cube(new Point(10,10,10), 15);
        cube.setCubeId(id);
        expectedParameters = new CubeParameters(3375, 1350, 25.981);
        warehouse.updateParameters(cube);
        Map<Long, CubeParameters> result = warehouse.getWarehouse();
        expectedMap.put(id, expectedParameters);
        Assert.assertEquals(expectedMap.get(id), result.get(id));
    }

    @Test
    public void testGetWarehouse() {
        warehouse.putParameters(id, parameters);
        Map<Long,CubeParameters> result = warehouse.getWarehouse();
        Assert.assertEquals(expectedMap, result);
    }

    @Test
    public void testRemove() {
        warehouse.putParameters(id, parameters);
        warehouse.removeParameters(id);
        boolean result = warehouse.getWarehouse().isEmpty();
        Assert.assertTrue(result);
    }
}
