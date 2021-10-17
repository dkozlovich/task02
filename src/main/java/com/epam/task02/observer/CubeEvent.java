package com.epam.task02.observer;

import com.epam.task02.entity.Cube;

import java.util.EventObject;

public class CubeEvent extends EventObject {
    public CubeEvent(Cube source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube) super.getSource();
    }
}
