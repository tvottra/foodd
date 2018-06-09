package com.leviticus.foodd;

public class Food {
    private static int counter;
    private String name;
    private ExpirationDate exp;

    public Food(String name, ExpirationDate exp) {
        counter++;
        this.name = name;
        this.exp = exp;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Food.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpirationDate getExp() {
        return exp;
    }

    public void setExp(ExpirationDate exp) {
        this.exp = exp;
    }
}
