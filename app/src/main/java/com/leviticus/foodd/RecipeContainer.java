package com.leviticus.foodd;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.Comparator;

public class RecipeContainer
{
    ArrayList<Recipe> Recipes;
    void LoadRecipes(String FileLocation)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileLocation));
            String Line;
            ArrayList<String> IngredientLists = new ArrayList<String>();
            while((Line = reader.readLine()) != null)
            {
                if(Line.equals("-------------"))
                {
                    Recipes.add(new Recipe(new ArrayList<String>(IngredientLists)));
                    IngredientLists.clear();
                }
                else
                {
                    IngredientLists.add(Line);
                }
            }
        }
        catch(java.io.FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(java.io.IOException e) {
            e.printStackTrace();
        }
    }
    void SortRecipes(Inventory inventory)
    {
        for(Recipe r : Recipes)
        {
            r.DetermineMatchingIngredientsRating(inventory);
        }
        Collections.sort(Recipes);
    }
    RecipeContainer(String starter, Inventory inventory)
    {
        Recipes = new ArrayList<Recipe>();
        LoadRecipes(starter);
        SortRecipes(inventory);
    }

}
