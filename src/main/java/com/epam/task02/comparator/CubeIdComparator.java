package com.epam.task02.comparator;

import com.epam.task02.entity.Cube;

import java.util.Comparator;

public class CubeIdComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube c1, Cube c2) {
        return Long.compare(c1.getCubeId(), c2.getCubeId());
    }
}
