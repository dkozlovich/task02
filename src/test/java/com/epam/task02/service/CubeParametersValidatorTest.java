package com.epam.task02.service;

import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class CubeParametersValidatorTest {

    CubeParametersValidator cubeParametersValidator = CubeParametersValidatorImpl.getInstance();

    @Test
    public void validateCenterAndEdge() {
        boolean result = cubeParametersValidator.isValidCenterAndEdge("10, -12.2189 - 3.11 36.88");
        Assert.assertTrue(result);
    }

    @Test
    public void validatePointsString() {
        boolean result = cubeParametersValidator.isValidPointsString("12 24 38.8 49 55 86 77 811.6");
        Assert.assertTrue(result);
    }
}