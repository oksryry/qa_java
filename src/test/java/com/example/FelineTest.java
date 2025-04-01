package com.example;

import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

public class FelineTest {

    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void felineGetKittensWithoutParameterTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void felineGetKittensWithParameterTest() {
        Feline feline = new Feline();
        Assert.assertEquals(-3, feline.getKittens(-3));
    }

    @Test //проверяем, что возвращается список еды именно для Хищника
    public void verifyFoodListTest() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test //поверяем, что getFood вообще вызывается именно с этим аргументом
    public void verifyGetFoodInvokation() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test(expected = Exception.class) //проверяем, что на случайном аргументе, который генерится в Utils, выкинется исключение
    public void getFoodException() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        Utils util = Mockito.spy(new Utils());
        feline.getFood(util.generator());
    }
}
