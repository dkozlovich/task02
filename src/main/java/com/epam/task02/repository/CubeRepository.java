package com.epam.task02.repository;

import com.epam.task02.entity.Cube;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface CubeRepository {

    List<Cube> getCubes();

    int size();

    boolean isEmpty();

    boolean add(Cube cube);

    boolean addAll(Collection<?extends Cube> collection);

    boolean remove(Cube cube);

    Cube remove(int index);

    boolean removeAll(Collection<? extends Cube> collection);

    Cube get(int index);

    Cube set(int index, Cube element);

    List<Cube> query(CubeSpecification specification);

    List<Cube> queryStream(CubeSpecification specification);

    List<Cube> sort(Comparator<Cube> comparator);

}
