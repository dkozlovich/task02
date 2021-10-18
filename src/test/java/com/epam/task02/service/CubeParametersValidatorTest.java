package com.epam.task02.service;

import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class CubeParametersValidatorTest {

    CubeParametersValidator cubeParametersValidator = CubeParametersValidatorImpl.getInstance();

    @Test
    public void validate() {
        boolean result = cubeParametersValidator.isValid("10, -2.0 - 3.0 4.1");
        Assert.assertTrue(result);
    }
}
