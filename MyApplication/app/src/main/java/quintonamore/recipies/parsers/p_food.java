package quintonamore.recipies.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import quintonamore.recipies.models.recipe;

/**
 * Created by Quinton on 11/16/2016.
 * Parser to grab information from a URL then parse it into a recipe object. This class
 * specifically grabs a recipe from food.com
 */

public class p_food {

    recipe r_parse;
    Document doc ;
    public Elements ingredients;
    public Elements steps;

    public p_food(String url){
        //Try to connect to the user's given url.
        try {
            doc = Jsoup.connect(url).get();
        } catch(java.io.IOException e){
            //Some error handling later.
        }

        ingredients = doc.getElementsByAttribute("data-ingredient");
        steps = doc.getElementsByClass("directions");
        steps = steps.select("li");

        //Get the name of the recipe
        Elements name = doc.getElementsByClass("recipe");
        name = name.select("h1");
        String t = name.text();

        r_parse = new recipe(t);

        for(Element element : ingredients){
            String temp = element.text();
            int i = 0;
            while(i < temp.length() && !Character.isAlphabetic(i))i++;

        }

    }
}
