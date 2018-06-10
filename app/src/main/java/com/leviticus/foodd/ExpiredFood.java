package com.leviticus.foodd;

public class ExpiredFood extends Food
{
    ExpiredFood(String foodName, ExpirationDate exp)
    {
        super(foodName, exp);
    }
    ExpiredFood(Food food)
    {
        super(food.name.FoodName, food.exp);
    }
    @Override
    protected void DetermineStatus()
    {
        this.CURRSTATUS = STATUS.EXPIRED;
    }
}
