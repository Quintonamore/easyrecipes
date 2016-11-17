package quintonamore.recipies.models;

import java.util.ArrayList;

/**
 * Created by Quinton on 11/16/2016.
 * Recipe class that holds information for the recipie including steps & ingredients.
 * Should only add the steps once all of the ingredients are added.
 */

public class recipe {
    private ArrayList<ingredient> i_list ;
    private ArrayList<step> steps ;
    String recipeName;

    /**
     * Take in the name, and assign it to recipeName, then instantiate i_list and steps.
     * @param name
     */
    public recipe(String name){
        i_list = new ArrayList<ingredient>();
        steps = new ArrayList<step>();

        recipeName = name;
    }

    /**
     * Add an ingredient to the list.
     * @param name
     * @param amount
     */
    public void addIngredient(String name, String amount){
        ingredient i = new ingredient(name, amount);
        i_list.add(i);
    }

    /**
     * Adds the steps, and uses the ingredient list to generate references.
     * Please put the steps in order, doesn't really work otherwise. Or at least work correctly.
     * @param txt
     */
    public void addStep(String txt){
        step s = new step(txt, i_list);
        steps.add(s);
    }

}

class ingredient {

    String name, ammount;

    /**
     * Ingredient object that holds the name and amount both in strings.
     * @param n
     * @param a
     */
    ingredient(String n, String a){
        name = n.toLowerCase();
        ammount = a;
    }

    /**
     * Returns the name of the ingredient.
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the ammount of the ingredient
     * @return
     */
    public String getAmmount(){
        return ammount;
    }
}

class step {
    String stepText;
    ArrayList<Integer> i_reference;

    /**
     * Step object that holds the step text, and also any references to ingredients held in
     * an array list in reference to the recipe.
     * @param txt
     * @param list
     */
    step(String txt, ArrayList<ingredient> list){
        i_reference = new ArrayList<Integer>();

        //Loop to check to see if there are any ingredient references in the step.
        for(int i = 0; i < list.size(); i++){
            if(txt.toLowerCase().contains(list.get(i).getName())){
                i_reference.add(i);
            }
        }

        stepText = txt;
    }

    ArrayList<Integer> getI_reference(){
        return i_reference;
    }

    String getStepText(){
        return stepText;
    }
}
