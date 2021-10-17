package com.epam.task02.comparator;

import com.epam.task02.entity.Cube;

import java.util.Comparator;

public class CubeEdgeComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube c1, Cube c2) {
        return Double.compare(c1.getEdge(), c2.getEdge());
    }
}
