package com.example.savchenko_calculator;

import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorUnitTests {

    @Test
    public void checkAddition(){
        final String solutionWindow = "7+2";
        final String expectedResult = "9";
        final String actualResult = CalcUnitTestFunc.getResult(solutionWindow);

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void checkSubtraction(){
        final String solutionWindow = "7-2";
        final String expectedResult = "5";
        final String actualResult = CalcUnitTestFunc.getResult(solutionWindow);

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void checkMultiplication(){
        final String solutionWindow = "7*2";
        final String expectedResult = "14";
        final String actualResult = CalcUnitTestFunc.getResult(solutionWindow);

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void checkDivision(){
        final String solutionWindow = "7/2";
        final String expectedResult = "3.5";
        final String actualResult = CalcUnitTestFunc.getResult(solutionWindow);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void checkInvalidInput(){
        final String solutionWindow = "7/2*/2^5";
        final String expectedResult = "Err";
        final String actualResult = CalcUnitTestFunc.getResult(solutionWindow);

        assertEquals(expectedResult, actualResult);

    }

}
