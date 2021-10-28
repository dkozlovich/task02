package com.epam.task02.reader;

import com.epam.task02.exception.CubeException;
import com.epam.task02.reader.impl.StringFilePathReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringFilePathReaderTest {

    StringReader<String> stringReader = new StringFilePathReaderImpl();

    @Test
    public void testRead() throws CubeException {
        List<String> expected = new ArrayList<>();
        expected.add("first");
        expected.add("1 2 3");
        List<String> result = stringReader.read("src\\test\\resources\\list.txt");
        Assert.assertEquals(expected, result);
    }
}
