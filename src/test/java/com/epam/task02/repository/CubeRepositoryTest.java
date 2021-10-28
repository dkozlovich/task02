package com.epam.task02.repository;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.repository.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeRepositoryTest {

    public static boolean initIsDone = false;

    CubeRepository repository = CubeRepositoryImpl.getInstance();
    Cube cube0 = new Cube(new Point(10, 10, 10), 15);
    Cube cube1 = new Cube(new Point(0, 15, 10), 25);
    Cube cube2 = new Cube(new Point(0, 15, 16), 5);

    @Before
    public void init() {
        if (initIsDone) {
            return;
        }
        repository.add(cube0);
        repository.add(cube1);
        repository.add(cube2);
        initIsDone = true;
    }

    @Test
    public void testEdgeSpecification() {
        EdgeSpecification specification = new EdgeSpecification(5, 20);
        List<Cube> result = repository.query(specification);
        List<Cube> expected = new ArrayList<>();
        expected.add(cube0);
        expected.add(cube2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIdSpecification() {
        IdSpecification specification = new IdSpecification(cube1.getCubeId());
        List<Cube> result = repository.query(specification);
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMinVolumeSpecification() {
        MinVolumeSpecification specification = new MinVolumeSpecification(300);
        List<Cube> result = repository.query(specification);
        List<Cube> expected = new ArrayList<>();
        expected.add(cube0);
        expected.add(cube1);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSurfaceAreaSpecification() {
        SurfaceAreaSpecification specification = new SurfaceAreaSpecification(1,20);
        List<Cube> result = repository.query(specification);
        List<Cube> expected = new ArrayList<>();
        expected.add(cube0);
        expected.add(cube2);
        Assert.assertEquals(expected, result);
    }

}
