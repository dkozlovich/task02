package com.epam.task02.reader.impl;

import com.epam.task02.exception.CubeException;
import com.epam.task02.reader.StringReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFilePathReaderImpl implements StringReader<String> {

    @Override
    public List<String> read(String pathToFile) throws CubeException {
        List<String> lines = new ArrayList<>();
        try(Stream<String> stringStream = Files.lines(Path.of(pathToFile))) {
            lines = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new CubeException();
        }
        return lines;
    }
}
