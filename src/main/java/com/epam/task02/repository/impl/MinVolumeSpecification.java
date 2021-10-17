package com.epam.task02.repository.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.repository.CubeSpecification;
import com.epam.task02.service.CubeService;
import com.epam.task02.service.impl.CubeServiceImpl;

public class MinVolumeSpecification implements CubeSpecification {
    private final double minVolume;

    public MinVolumeSpecification(double minVolume) {
        this.minVolume = minVolume;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService cubeService = CubeServiceImpl.getInstance();
        double volume = cubeService.findVolume(cube);
        return volume >= minVolume;
    }
}
