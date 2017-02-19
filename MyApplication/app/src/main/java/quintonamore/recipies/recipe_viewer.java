package quintonamore.recipies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import quintonamore.recipies.parsers.p_food;

import static quintonamore.recipies.R.layout.activity_recipe_viewer;

public class recipe_viewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        p_food parse = (p_food) getIntent().getSerializableExtra("Recipe");
        setContentView(R.layout.activity_recipe_viewer);

        TextView RName = (TextView) findViewById(R.id.textView);
        RName.setText(parse.r_parse.recipeName);

        RName.append("\n\n" + "Ingredients\n\n");

        int ingCount = parse.r_parse.getNumIngredients();
        int stepsCount = parse.r_parse.getNumSteps();

        for(int i = 0; i <ingCount; i++){
            RName.append(i+1 +") " + parse.r_parse.getIAmount(i)+ "\n");
        }
        RName.append("\nSteps\n\n");
        for(int i = 0; i <stepsCount-1; i++){

            RName.append(i+1 +") " + parse.r_parse.getStepText(i) + "\n\n");
        }
    }
}
