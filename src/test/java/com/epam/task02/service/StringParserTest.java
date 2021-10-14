package com.epam.task02.service;

import com.epam.task02.parser.StringParser;
import com.epam.task02.parser.impl.StringParserImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StringParserTest {

    @Test
    public void testParseToCoordinatesAndEdge() {

        double[] expected = new double[4];
        expected[0] = 4.0;
        expected[1] = 6.0;
        expected[2] = -1;
        expected[3] = 100;
        String toParse = "4, 6, -1, 100";
        double[] result;
        StringParser stringParser = new StringParserImpl();
        result = stringParser.parseToCoordinatesAndEdge(toParse);
        Assert.assertArrayEquals(expected,result,0.000001d);
    }

}
