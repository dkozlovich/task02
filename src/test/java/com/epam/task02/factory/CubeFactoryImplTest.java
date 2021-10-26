package com.epam.task02.factory;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.factory.CubeFactory;
import com.epam.task02.factory.impl.CubeFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeFactoryImplTest {

    CubeFactory cubeFactoryImpl = CubeFactoryImpl.getInstance();

    @Test
    public void testCreateByCenterAndEdge() {
        Cube expected = new Cube(new Point(1,1,1), 15);
        Cube result = cubeFactoryImpl.createByCenterAndEdge(new Point(1,1,1), 15);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCreateByPoints() {
        Cube expected = new Cube(new Point(1,1,1), 2);
        Point p1 = new Point(0,0,0);
        Point p2 = new Point(2,0,0);
        Point p3 = new Point(2,2,0);
        Point p4 = new Point(0,2,0);
        Point p5 = new Point(0,0,2);
        Point p6 = new Point(2,0,2);
        Point p7 = new Point(2,2,2);
        Point p8 = new Point(0,2,2);
        List<Point> list = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
        Cube result = cubeFactoryImpl.createByPoints(list);
        Assert.assertEquals(expected, result);
    }
}
