package com.epam.task02.service;

import com.epam.task02.parser.StringParser;
import com.epam.task02.parser.impl.StringParserImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringParserTest {

    @Test
    public void testParseToCenterAndEdge1() {

        double[] expected = new double[4];
        expected[0] = 4.0;
        expected[1] = 6.0;
        expected[2] = -1;
        expected[3] = 100;
        String toParse = "4, 6, -1, 100";
        double[] result;
        StringParser stringParser = new StringParserImpl();
        result = stringParser.parseToCenterAndEdge(toParse);
        Assert.assertArrayEquals(expected, result,0.000001d);
    }

    @Test
    public void testParseToCenterAndEdge2() {

        String toParse = "4, 6j, -1, 100";
        StringParser stringParser = new StringParserImpl();
        double[] result = stringParser.parseToCenterAndEdge(toParse);
        Assert.assertNull(result);
    }


    @Test
    public void testParseToCenterAndEdge3() {
        double[] expected1 = {4.0, 6.0, -1, 100};
        double[] expected2 = {5.0, 64, -11, 10};
        double[] expected3 = {15.0, 27, 1, 2000};
        List<double[]> expected = new ArrayList<>();
        expected.add(expected1);
        expected.add(expected2);
        expected.add(expected3);
        String s1 = "4, 6, -1, 100";
        String s2 = "5, 64, -11, 10";
        String s3 = "15.0 - 27 - 1 - 2000";
        List<String> toParse = new ArrayList<>();
        toParse.add(s1);
        toParse.add(s2);
        toParse.add(s3);
        StringParser stringParser = new StringParserImpl();
        List<double[]> result = stringParser.parseToCenterAndEdge(toParse);
        for (int i = 0; i < result.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), result.get(i),0.000001d);
        }
    }

    @Test
    public void testParseToCenterAndEdge4() {
        double[] expected1 = {4.0, 6.0, -1, 100};
        double[] expected2 = {5.0, 64, -11, 10};
        List<double[]> expected = new ArrayList<>();
        expected.add(expected1);
        expected.add(expected2);
        String s1 = "4, 6, -1, 100";
        String s2 = "15.0 - 27 - 1 - -2000";
        String s3= "15.0 - 27 - 1k - 2";
        String s4 = "5, 64, -11, 10";
        List<String> toParse = new ArrayList<>();
        toParse.add(s1);
        toParse.add(s2);
        toParse.add(s3);
        toParse.add(s4);
        StringParser stringParser = new StringParserImpl();
        List<double[]> result = stringParser.parseToCenterAndEdge(toParse);
        for (int i = 0; i < result.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), result.get(i),0.000001d);
        }
    }
}
