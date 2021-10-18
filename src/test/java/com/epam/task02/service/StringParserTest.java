package com.epam.task02.service;

import com.epam.task02.parser.StringParser;
import com.epam.task02.parser.impl.StringParserImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testParseToCoordinatesAndEdge2() {
        double[] expected1 = new double[4];
        expected1[0] = 4.0;
        expected1[1] = 6.0;
        expected1[2] = -1;
        expected1[3] = 100;
        double[] expected2 = new double[4];
        expected2[0] = 5.0;
        expected2[1] = 64.0;
        expected2[2] = -11;
        expected2[3] = 10;
        List<double[]> expected = new ArrayList<>();
        expected.add(expected1);
        expected.add(expected2);
        String s1 = "4, 6, -1, 100";
        String s2 = "5, 64, -11, 10m";
        List<String> toParse = new ArrayList<>();
        toParse.add(s1);
        toParse.add(s2);
        StringParser stringParser = new StringParserImpl();
        List<double[]> result = stringParser.parseToCoordinatesAndEdge(toParse);
        for (int i = 0; i < result.size(); i++) {
            Assert.assertArrayEquals(expected.get(i),result.get(i),0.000001d);
        }
    }
}
