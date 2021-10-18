package com.epam.task02.validator.impl;

import com.epam.task02.validator.CubeParametersValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeParametersValidatorImpl implements CubeParametersValidator {

    private static CubeParametersValidator instance;

    private CubeParametersValidatorImpl() {

    }

    public static CubeParametersValidator getInstance() {
        if (instance == null) {
            instance = new CubeParametersValidatorImpl();
        }
        return instance;
    }

    private static final String COORDINATES_AND_EDGE_REGEX = "(([+-]?([0-9]*[.])?[0-9]+(,\\s|\\s-\\s|\\s)){3})([0-9]*[.])?[0-9]*";

    @Override
    public boolean isValid(String coordinatesAndEdge) {
        Pattern pattern = Pattern.compile(COORDINATES_AND_EDGE_REGEX);
        Matcher matcher = pattern.matcher(coordinatesAndEdge);
        return matcher.matches();
    }
}
