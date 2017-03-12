package quintonamore.recipies.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;

import quintonamore.recipies.models.recipe;

/**
 * This parser gets recipe information from Foodnetwork.com
 *
 * Doesn't work too well with the custom recipes, need to look into how to detect
 * and format better.
 *
 */
public class p_foodnetwork extends recipeParse implements Serializable {

    public recipe r_parse;


    public p_foodnetwork(String url){
        Document doc = new Document("T");
        Elements ingredients;
        Elements steps;

        //Try to connect to the user's given url.
        try {
            doc = Jsoup.connect(url).get();
        } catch(java.io.IOException e){
            //Some error handling later. Q you should do this.
        }

        ingredients = doc.getElementsByClass("parbase ingredients section");
        ingredients = ingredients.select("li");
        steps = doc.getElementsByClass("o-Method__m-Body");
        steps = steps.select("p");

        //Get the name of the recipe
        Elements name = doc.getElementsByClass("o-AssetTitle");
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

    /**
     * Getter for the recipe object.
     * @return
     */
    @Override
    public recipe getRecipe(){
        return r_parse;
    }
}
