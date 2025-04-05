package com.example;

import java.util.List;

public class Lion {

    boolean hasMane; //грива

    private final Feline feline;

    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }


//    Feline feline = new Feline(); // - эта строка была в исходном коде, под удаление


    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() { //здесь можно сделать параметризованный тест
        return hasMane;
    }


    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
