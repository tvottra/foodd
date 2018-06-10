package com.leviticus.foodd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



 public class Food {
    private static int counter = 0;
    private String name;
    private ExpirationDate exp;



    public Food(String foodName, ExpirationDate exp) {
        counter++;
        this.name = foodName + counter;
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
