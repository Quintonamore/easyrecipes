package quintonamore.recipies.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;

import quintonamore.recipies.models.recipe;

/**
 * Created by Quinton on 11/16/2016.
 * Parser to grab information from a URL then parse it into a recipe object. This class
 * specifically grabs a recipe from food.com
 */

public class p_food implements Serializable{

    public recipe r_parse;

    public p_food(String url){
        Document doc = new Document("T");
        Elements ingredients;
        Elements steps;

        //Try to connect to the user's given url.
        try {
            doc = Jsoup.connect(url).get();
        } catch(java.io.IOException e){
            //Some error handling later. Q you should do this.
        }

        ingredients = doc.getElementsByAttribute("data-ingredient");
        steps = doc.getElementsByClass("directions");
        steps = steps.select("li");

        //Get the name of the recipe
        Elements name = doc.getElementsByClass("recipe");
        name = name.select("h1");
        String t = name.text();

        r_parse = new recipe(t);

        //Parse the elements and add them to r_parse.
        for(Element element : ingredients){
            String temp = element.text();
            int i = 0;
            while(i < temp.length() && !Character.isAlphabetic(i))i++;

            String a = temp.substring(0, i);
            String in = temp.substring(i);

            r_parse.addIngredient(in, a);
        }

        //Parse the steps into r_parse
        for(Element element : steps ){
            r_parse.addStep(element.text());
        }


    }
}
