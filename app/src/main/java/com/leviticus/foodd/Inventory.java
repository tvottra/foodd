package com.leviticus.foodd;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Inventory
{
    ArrayList<Food> Items;
    ArrayList<ExpiredFood> ExpiredItems;
    Inventory(ArrayList<Food> _Items)
    {
        Items = _Items;
        ExpiredItems = new ArrayList<ExpiredFood>();
    }
    Inventory()
    {
        Items = new ArrayList<Food>();
        ExpiredItems = new ArrayList<ExpiredFood>();
    }
    public void AddItem(Food item)
    {
        Items.add(item);
    }
    public int GetNumberOfItems(String fooditem)
    {
        return Food.getFoodCounter(fooditem);
    }
    public int GetTotalItems()
    {
        return Items.size();
    }
    public int GetTotalBadItems()
    {
        return ExpiredItems.size();
    }
    //Name of food and how much we want to remove
    public void RemoveFood(int index)
    {
        String FoodName = Items.get(index).name.FoodName;
        Items.remove(index);
        for(int i = index; i < Items.size(); i++)
        {
            if(FoodName.equals(Items.get(i).getName()))
            {
                Items.get(i).setNumber(Items.get(i).getNumber() - 1);
            }
        }
        Food.SubtractCounter(FoodName,1);
    }
    public void RemoveFood(int FoodNumber, String FoodName)
    {
        int counter = 0;
        for(int i = 0; i < Items.size(); i++)
        {
            if(!(counter < FoodNumber))
            {
                break;
            }
            if(Items.get(i).getName().equals(FoodName))
            {
                Items.remove(i);
                counter++;
            }
        }
        //Rename
        for(int i = 0; i < Items.size(); i++)
        {
            if(Items.get(i).getName().equals(FoodName))
            {
                Items.get(i).setNumber(Items.get(i).getNumber() - counter);
            }
        }
        //Recalibrate actual food class counter
        Food.SubtractCounter(FoodName, counter);
    }
    public void CheckExpiration()
    {
        for(int i = 0; i < Items.size(); i++)
        {
            int ItemDate = Items.get(i).getExp().getYear()*10000 + Items.get(i).getExp().getMonth()*1000 + Items.get(i).getExp().getDay();
            Calendar cal = Calendar.getInstance();
            int CurrentDate = cal.get(Calendar.YEAR)*10000 + (cal.get(Calendar.MONTH) + 1)*1000 + cal.get(Calendar.DAY_OF_MONTH);
            if(CurrentDate > ItemDate)
            {
                ExpiredItems.add(new ExpiredFood(Items.get(i)));
                RemoveFood(i);
            }
        }
    }
}
