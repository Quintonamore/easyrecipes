package quintonamore.recipies;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import quintonamore.recipies.parsers.p_food;
import quintonamore.recipies.parsers.p_foodnetwork;
import quintonamore.recipies.parsers.recipeParse;

import static quintonamore.recipies.R.layout.activity_recipe_viewer;

/**
 * A simple view for the recipe.
 */
public class recipe_viewer extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_viewer);

        recipeParse parse;

        try {
            parse = (p_food) getIntent().getSerializableExtra("Recipe");
        }catch(java.lang.ClassCastException e){
            parse = (p_foodnetwork) getIntent().getSerializableExtra("Recipe");
        }

        TextView RName;

        while((RName = (TextView) findViewById(R.id.textViewRecipe)) == null){
            // Just loop! Still working out why this works. Not good at all.
        }

        RName.setText(parse.getRecipe().recipeName);


        RName.append("\n\n" + "Ingredients\n\n");

        int ingCount = parse.getRecipe().getNumIngredients();
        int stepsCount = parse.getRecipe().getNumSteps();

        for(int i = 0; i <ingCount; i++){
            RName.append(i+1 +") " + parse.getRecipe().getIAmount(i)+ "\n");
        }
        RName.append("\nSteps\n\n");
        for(int i = 0; i <stepsCount-1; i++){

            RName.append(i+1 +") " + parse.getRecipe().getStepText(i) + "\n\n");
        }
    }
}
