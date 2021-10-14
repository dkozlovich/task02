package com.epam.task02.validator.impl;

import com.epam.task02.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {

    private static final String POINT_AND_EDGE_REGEX = "(([+-]?([0-9]*[.])?[0-9]+(\\s|,\\s|\\s-\\s)){3})(\\d*.\\d*)";

    @Override
    public boolean validate(String pointAndEdge) {
        Pattern pattern = Pattern.compile(POINT_AND_EDGE_REGEX);
        Matcher matcher = pattern.matcher(pointAndEdge);
        return matcher.matches();
    }
}
