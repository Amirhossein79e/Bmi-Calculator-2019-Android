package com.amirhosseinemadi.bmi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();



    @Test
    public void getMin() {
        BMI bmi = new BMI();
        bmi.setAge(String.valueOf(20));
        bmi.setHeight(String.valueOf(185f));
        assertEquals(calculator.getMin(bmi,1.033f),65.4,0.0f);
    }

    @Test
    public void t()
    {
        assertEquals(10+10,21);
    }
}