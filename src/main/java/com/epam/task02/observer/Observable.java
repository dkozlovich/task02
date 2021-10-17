package com.epam.task02.observer;

public interface Observable {
    void attach(CubeObserver observer);

    void detach(CubeObserver observer);

    void notifyObserver();
}
