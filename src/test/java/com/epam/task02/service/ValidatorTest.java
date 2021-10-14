package com.epam.task02.service;

import com.epam.task02.validator.Validator;
import com.epam.task02.validator.impl.ValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    Validator validator = new ValidatorImpl();

    @Test
    public void validate() {
        boolean result = validator.validate("10, -2.0 - 3.0 4.1");
        Assert.assertTrue(result);
    }
}
