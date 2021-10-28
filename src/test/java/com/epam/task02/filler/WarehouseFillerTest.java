package com.epam.task02.filler;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.warehouse.CubeParameters;
import com.epam.task02.warehouse.Warehouse;
import com.epam.task02.warehouse.impl.WarehouseImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseFillerTest {

    private Warehouse warehouse = WarehouseImpl.getInstance();
    private WarehouseFiller warehouseFiller = new WarehouseFiller();

    @Before
    public void init() {
        warehouse.removeAllParameters();
    }

    @Test
    public void testFillWarehouse() {
        List<Cube> cubes = new ArrayList<>();
        Cube cube = new Cube(new Point(10,10,10), 15);
        cubes.add(cube);
        Cube cube1 = new Cube(new Point(-86,19,40), 33);
        cubes.add(cube1);
        warehouseFiller.fillWarehouse(cubes);
        Map<Long, CubeParameters> result = warehouse.getWarehouse();
        Map<Long, CubeParameters> expected = new HashMap<>();
        expected.put(cube.getCubeId(),new CubeParameters(3375, 1350, 25.981));
        expected.put(cube1.getCubeId(),new CubeParameters(35937, 6534, 57.158));
        Assert.assertEquals(expected, result);
    }
}
