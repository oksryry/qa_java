package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FelineParamsTest {

    @Parameter
    public int expectedKittens;

    @Parameter(1)
    public int givenKittens;

    @Parameters(name = "{index}: Ожидаемое количество котят: {0}, вернулось значение {1}")
    public static Object[][] data() {
        return new Object[][] {
            {-3, -3},
            {0, 0},
            {1, 1},
            {12, 12}
        };
    }

    Feline feline = new Feline();

    @Test
    public void returnGivenKittens() {
        Assert.assertEquals(expectedKittens, feline.getKittens(givenKittens));
    }

}
