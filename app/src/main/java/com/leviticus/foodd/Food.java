package com.leviticus.foodd;
import java.util.ArrayList;
public class Food
{
    public enum STATUS
    {
        UNDERRIPE,
        RIPE,
        OVERRIPE,
        EXPIRED
    }
    class FoodCounter
    {
        public int value;
        public String name;
        FoodCounter(String _name)
        {
            value = 0;
            name = _name;
        }
    }
    class FoodString
    {
        public String FoodName;
        public int FoodValue;
        FoodString(String _FoodName, int _FoodValue)
        {
            FoodName = _FoodName;
            FoodValue = _FoodValue;
        }
    }
    protected STATUS CURRSTATUS;
    protected static ArrayList<FoodCounter> counters;
    protected static int counter = 1;
    protected FoodString name;
    protected ExpirationDate exp;
    public Food(String foodName, ExpirationDate exp)
    {
        counter++;
        name = new FoodString(foodName, getFoodCounter(foodName));
        addCounter(foodName);
        this.exp = exp;
        DetermineStatus();
    }
    //Change to reflect date later
    protected void DetermineStatus()
    {
        this.CURRSTATUS = STATUS.RIPE;
    }
    public STATUS getCURRSTATUS()
    {
        return CURRSTATUS;
    }
    protected void addCounter(String id)
    {
        for(int i = 0; i < counters.size(); i++)
        {
            if(counters.get(i).name == id)
            {
                counters.get(i).value++;
                return;
            }
        }
        counters.add(new FoodCounter(id));
    }
    public static void SubtractCounter(String id, int numsubtract)
    {
        for(int i = 0; i < counters.size(); i++)
        {
            if(counters.get(i).name == id)
            {
                counters.get(i).value -= numsubtract;
                return;
            }
        }
    }
    public static int getFoodCounter(String food)
    {
        for(int i = 0; i < counters.size(); i++)
        {
            if(counters.get(i).name == food)
            {
                return counters.get(i).value;
            }
        }
        return 0;
    }
    public static int getCounter()
    {
        return counter;
    }

    public static void setCounter(int counter)
    {
        Food.counter = counter;
    }

    public String getName()
    {
        return name.FoodName;
    }
    public void setName(String name)
    {
        this.name.FoodName = name;
    }
    public int getNumber()
    {
        return name.FoodValue;
    }
    public void setNumber(int setter)
    {
        name.FoodValue = setter;
    }
    public ExpirationDate getExp()
    {
        return exp;
    }
    public void setExp(ExpirationDate exp)
    {
        this.exp = exp;
    }
}
