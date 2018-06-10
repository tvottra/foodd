package com.leviticus.foodd;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collection;
public class Recipe implements Comparable<Recipe>
{
    ArrayList<String> Ingredients;
    public double MatchingIngredientsRating;
    Recipe(ArrayList<String> _Ingredients)
    {
        Ingredients = _Ingredients;
        MatchingIngredientsRating = 0;
    }
    public void DetermineMatchingIngredientsRating(Inventory inventory)
    {
        double TotalMatches = 0;
        for(int i = 0; i < inventory.Items.size(); i++)
        {
            for(int z = 0; z < Ingredients.size(); z++)
            {
                if(inventory.Items.get(i).getName().contains(Ingredients.get(z)) || inventory.Items.get(i).getName().contains(Ingredients.get(z)))
                {
                    TotalMatches++;
                    break;
                }
            }
        }
        MatchingIngredientsRating = TotalMatches/(Ingredients.size());
    }
    @Override
    public int compareTo(Recipe compareso)
    {
        return Math.toIntExact(Math.round(compareso.MatchingIngredientsRating-this.MatchingIngredientsRating));
    }
}

//public class RecipeComparer implements Comparator<Recipe>
//{
//    @Override
//    public int compare(Recipe a, Recipe b)
//    {
//        int ratingComparison = compare(a.MatchingIngredientsRating, b.MatchingIngredientsRating);
//        return ratingComparison;
//    }
//    private static int compare(double a, double b){
//        return a < b ? -1
//                : a > b ? 1
//                : 0;
//    }
//}
//
