package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    public static final String CAT_SOUND = "Мяу";


    @Mock
    private Feline feline;

    @Test
    public void catGetFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

    }


    @Test
    public void catSoundTest() {
        Cat cat = new Cat(feline);
        Assert.assertEquals(CAT_SOUND, cat.getSound());
    }

}
