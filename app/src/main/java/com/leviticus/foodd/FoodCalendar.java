package com.leviticus.foodd;
//android client id 759828094176-6npjg2lijvruamckhbcrnv6lr2u3um3e.apps.googleusercontent.com
import android.appwidget.AppWidgetManager.*;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.time.Year;
import java.util.ArrayList;
public class FoodCalendar
{
    class Element
    {
        Food CurrFood;
        Date Value;
        Element(Date _Value)
        {
            Value = _Value;
            CurrFood = null;
        }
        Element(Date _Value, Food _ExpiredFood)
        {
            CurrFood = _ExpiredFood;
            Value = _Value;
        }
        //GUI PERSON CODES THIS
        void Display(int xloc, int yloc, int width, int height)
        {

        }
    }
    class Month
    {
        String ID;
        ArrayList<Element> Days;
        int DayNumber;
        int MonthNumber;
        int YearNumber;
        //Somebody with GUI knowledge do this
        void GenerateGUI()
        {
            int DayCounter = 0;
            int ShiftDownCounter = 0;
        }
        void GenerateDays()
        {
            for(int i = 1; i <= DayNumber; i++)
            {
                Days.add(new Element(new Date(MonthNumber, i, YearNumber)));
            }
        }
        Month(String _ID, int _DayNumber, int _MonthNumber, int _YearNumber)
        {
            ID = _ID;
            DayNumber = _DayNumber;
            MonthNumber = _MonthNumber;
            YearNumber = _YearNumber;
            GenerateDays();
        }
    }
    Inventory inventory;
    String UserEmail;
    ArrayList<Month> Elements;
    private void GenerateCalendar(int Year)
    {
        Elements.add(new Month("January", 31, 1, Year));
        Elements.add(new Month("February", (Year%4) == 0 ? 29 : 28, 2, Year));
        Elements.add(new Month("March", 31, 3, Year));
        Elements.add(new Month("April", 30, 4, Year));
        Elements.add(new Month("May", 31, 5, Year ));
        Elements.add(new Month("June", 30, 6, Year));
        Elements.add(new Month("July", 31, 7, Year));
        Elements.add(new Month("August", 31, 8, Year));
        Elements.add(new Month("September", 30, 9, Year));
        Elements.add(new Month("October", 31, 10, Year));
        Elements.add(new Month("November", 30, 11, Year));
        Elements.add(new Month("December", 31, 12, Year));
    }
    private void UpdateCalendarComponents()
    {
        //Reset to null
        for(Month i : Elements)
        {
            for(Element d : i.Days)
            {
                d.CurrFood = null;
            }
        }
        for(Food i : inventory.Items)
        {
            Elements.get(i.getExp().getMonth() - 1).Days.get(i.getExp().getDay() - 1).CurrFood = i;
        }
        for(ExpiredFood i : inventory.ExpiredItems)
        {
            Elements.get(i.getExp().getMonth() - 1).Days.get(i.getExp().getDay() - 1).CurrFood = i;
        }
    }
    FoodCalendar(ArrayList<Food> FoodCal, int Year)
    {
        GenerateCalendar(Year);
        inventory = new Inventory(FoodCal);
    }
    FoodCalendar(int Year)
    {
        GenerateCalendar(Year);
        inventory = new Inventory();
    }
    public void FoodNotify()
    {

    }
}
