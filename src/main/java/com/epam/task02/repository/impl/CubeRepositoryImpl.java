package com.epam.task02.repository.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.repository.CubeRepository;
import com.epam.task02.repository.CubeSpecification;

import java.util.*;

public class CubeRepositoryImpl implements CubeRepository {

    private static CubeRepository instance;

    private final List<Cube> cubes;

    private CubeRepositoryImpl() {
        cubes = new ArrayList<>();
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<Cube> getCubes() {
        return Collections.unmodifiableList(cubes);
    }

    @Override
    public int size() {
        return cubes.size();
    }

    @Override
    public boolean isEmpty() {
        return cubes.isEmpty();
    }

    @Override
    public boolean add(Cube cube) {
        return cubes.add(cube);
    }

    @Override
    public boolean addAll(Collection<? extends Cube> collection) {
        return cubes.addAll(collection);
    }

    @Override
    public boolean remove(Cube cube) {
        return cubes.remove(cube);
    }

    @Override
    public Cube remove(int index) {
        return cubes.remove(index);
    }

    @Override
    public boolean removeAll(Collection<? extends Cube> collection) {
        return cubes.removeAll(collection);
    }

    @Override
    public Cube get(int index) {
        return cubes.get(index);
    }

    @Override
    public Cube set(int index, Cube element) {
        return cubes.set(index, element);
    }

    @Override
    public List<Cube> query(CubeSpecification specification) {
        List<Cube> list = new ArrayList<>();
        for (Cube cube : cubes) {
            if (specification.specify(cube)) {
                list.add(cube);
            }
        }
        return list;
    }

    @Override
    public List<Cube> queryStream(CubeSpecification specification) {
        return cubes.stream().filter(specification::specify).toList();
    }

    @Override
    public List<Cube> sort(Comparator<Cube> comparator) {
        cubes.sort(comparator);
        return cubes;
    }

}
