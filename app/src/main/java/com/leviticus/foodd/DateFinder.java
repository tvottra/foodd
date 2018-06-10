package com.leviticus.foodd;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class DateFinder
{


    public static ArrayList<String> getRegions(String file){
        JSONParser parser = new JSONParser();
        ArrayList<String> text = new ArrayList<>();

        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray regions = (JSONArray) jsonObject.get("regions");
            JSONObject heck = (JSONObject) regions.iterator().next();
            JSONArray lines = (JSONArray) heck.get("lines");
            Iterator<JSONObject> i = lines.iterator();
            while(i.hasNext()) {
                JSONObject you = i.next();
                JSONArray words = (JSONArray) you.get("words");
                Iterator<JSONObject> j = words.iterator();
                while(j.hasNext()){
                    JSONObject abhigya = j.next();
                    text.add((String) abhigya.get("text"));
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;

    }
    String MergeList(ArrayList<String> List)
    {
        String returner = "";
        for(String s : List)
        {
            returner += s;
        }
        return returner;
    }
    enum STATE
    {
        FLUX,
        INTEGER,
        UNDETERMINEDSTRING,
        DETERMINEDSTRING,
        SLASHSTRING,
        UNMOVABLE
    }
    enum TYPE
    {

    }
    boolean isInts(char[] Chars)
    {
        for(int i = 0; i < Chars.length; i++)
        {
            if(!isInt(Chars[i]))
            {
                return false;
            }
        }
        return true;
    }
    boolean isAcceptedDelims(char[] Chars)
    {
        for(int i = 0; i < Chars.length; i++)
        {
            if(!isAcceptedDelim(Chars[i]))
            {
                return false;
            }
        }
        return true;
    }
    boolean isInt(char date)
    {
        return Character.isDigit(date);
    }
    boolean isAcceptedDelim(char date)
    {
        if(date == '/' || date == '-'){
            return true;//TODO: Edward you didn't finish this line
        }else{
            return false;
        }
    }
    String validDate(String date)
    {
        String returner = "";
        //Check for 6
        char [] g = {date.charAt(0),date.charAt(2), date.charAt(4), date.charAt(5)};
        char [] f = {date.charAt(1),date.charAt(3)};
        //check for 8
        char [] a = {date.charAt(0),date.charAt(1),date.charAt(2),date.charAt(3),date.charAt(4),date.charAt(5),date.charAt(6),date.charAt(7)};
        if(isInts(a)){
            returner = date.substring(0,7);
        }
        char [] d = {date.charAt(0),date.charAt(1),date.charAt(3),date.charAt(4),date.charAt(6),date.charAt(7),date.charAt(8),date.charAt(9)};
        char [] b = {date.charAt(0),date.charAt(1),date.charAt(3),date.charAt(4),date.charAt(6),date.charAt(7)};
        char [] c = {date.charAt(2), date.charAt(5)};
        if(isInts(d) && isAcceptedDelims(c)){
            returner = date.substring(0,9);
        }else if(isInts(b) && isAcceptedDelims(c)){
            returner = date.substring(0,7);
        }
        char [] e = {date.charAt(0),date.charAt(2),date.charAt(4),date.charAt(5),date.charAt(6),date.charAt(7)};
        char [] j = {date.charAt(1),date.charAt(3)};
        if(isInts(e) && isAcceptedDelims(j)){
            returner = date.substring(0,7);
        }else if(isInts(g) && isAcceptedDelims(f)){
            returner = date.substring(0,5);
        }
        char [] k = {date.charAt(0),date.charAt(2),date.charAt(3),date.charAt(5),date.charAt(6),date.charAt(7),date.charAt(8)};
        char [] h = {date.charAt(1),date.charAt(4)};
        char [] i = {date.charAt(0),date.charAt(2),date.charAt(3),date.charAt(5),date.charAt(6)};
        if(isInts(k) && isAcceptedDelims(h)){
            returner = date.substring(0,8);
        }else if(isInts(i)&&isAcceptedDelims(h)){
            returner = date.substring(0,6);
        }
        char [] l = {date.charAt(0),date.charAt(1),date.charAt(3),date.charAt(5),date.charAt(6),date.charAt(7),date.charAt(8)};
        char [] m = {date.charAt(2),date.charAt(4)};
        char [] n = {date.charAt(0),date.charAt(1),date.charAt(3),date.charAt(5),date.charAt(6)};
        if(isInts(l) && isAcceptedDelims(m)){
            returner = date.substring(0,8);
        }else if(isInts(n)&&isAcceptedDelims(m)){
            returner = date.substring(0,6);
        }
        String [] o = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
        for(String x:o){
            if(date.contains(x)){
                int p = date.indexOf(x);
                if(p<2){
                    char [] w = {date.charAt(p+3),date.charAt(p+4),date.charAt(p+5),date.charAt(p+6),date.charAt(p+7),date.charAt(p+8)};
                }else if(p<4){
                    char [] q = {date.charAt(p-2),date.charAt(p-1),date.charAt(p+3),date.charAt(p+4),date.charAt(p+5),date.charAt(p+6)};
                    char [] r = {date.charAt(p-2),date.charAt(p-1),date.charAt(p+3),date.charAt(p+4)};
                    char [] s = {date.charAt(p-1),date.charAt(p+3),date.charAt(p+4)};
                    char [] t = {date.charAt(p-1),date.charAt(p+3),date.charAt(p+4),date.charAt(p+5),date.charAt(p+6)};
                    char [] u = {date.charAt(p+3),date.charAt(p+4),date.charAt(p+5),date.charAt(p+6)};
                    if(isInts(q)){
                        returner = date.substring(p-2,p+6);
                    }else if(isInts(r)){
                        returner = date.substring(p-2,p+4);
                    }else if(isInts(s)){
                        returner = date.substring(p-1,p+4);
                    }else if(isInts(t)){
                        returner = date.substring(p-1,p+6);
                    }else if(isInts(u)){
                        returner = date.substring(p+3,p+6);
                    }
                }else if(p<6){
                    char [] v = {date.charAt(p+3),date.charAt(p+4)};
                    if(isInts(v)){
                        returner = date.substring(p+3,p+4);
                    }
                }
            }
        }

        return returner;
    }
    //public static ExpirationDate giveDate(ArrayList<String> text){

    //}
}