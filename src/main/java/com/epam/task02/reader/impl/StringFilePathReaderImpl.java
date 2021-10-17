package com.epam.task02.reader.impl;

import com.epam.task02.exception.CubeException;
import com.epam.task02.reader.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFilePathReaderImpl implements StringReader<String> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> read(String pathToFile) throws CubeException {
        if (!Files.exists(Path.of(pathToFile))) {
            logger.error("File " + pathToFile + " is not found.");
            throw new CubeException("File " + pathToFile + " is not found.");
        }
        List<String> lines;
        try(Stream<String> stringStream = Files.lines(Path.of(pathToFile))) {
            lines = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("IOException: " + pathToFile);
            throw new CubeException("I/O error: " + pathToFile,e);
        }
        return lines;
    }
}
