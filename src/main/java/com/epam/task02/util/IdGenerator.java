package com.epam.task02.util;

public class IdGenerator {

    private static long counter;

    public static long generateId() {
        return counter++;
    }

}
