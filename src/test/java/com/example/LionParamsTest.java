package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParamsTest {

    @Parameter
    public String sex;

    @Parameter(1)
    public boolean expectedHasMane;

    @Parameters(name = "{index}: Для пола льва {0} выводится значение наличия гривы {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Mock
    private Feline feline = Mockito.mock(Feline.class);


    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }


}
