package com.epam.task02.reader;

import com.epam.task02.exception.CubeException;

import java.util.List;

public interface StringReader<T> {

    List<String> read(T t) throws CubeException;
}
