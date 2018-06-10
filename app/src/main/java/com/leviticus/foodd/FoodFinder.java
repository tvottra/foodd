package com.leviticus.food;

import java.io.FileReader;
import java.util.ArrrayList;
import java.util.iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONParser;


public class FoodFinder;{
  public static String getSpecies(String file){
    JSONParser parser = newJSONParser();
    String species = "";

    try{
      object obj = parser.parse(new FileReader(file));
      JSON object jsonobject = (JSONObject) obj;
      
      JSONArray categories = (JSONArray) jsonObject.get("categories");
      JSONObject close = (JSONObject) categories.iterator().next();
      species = close.get("name");
    }catch (Exception e){
      e.printStackTrace();
    }
    return species;
  }
}
