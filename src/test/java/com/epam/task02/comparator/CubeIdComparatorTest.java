package com.epam.task02.comparator;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeIdComparatorTest {

    @Test
    public void testCompare() {
        Cube cube1 = new Cube(new Point(1,1,1),10);
        Cube cube2 = new Cube(new Point(1,1,1),12);
        int expected = 1;
        CubeEdgeComparator comparator = new CubeEdgeComparator();
        int result = comparator.compare(cube2, cube1);
        Assert.assertEquals(expected, result);
    }
}
