package quintonamore.recipies;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.util.concurrent.ExecutionException;

import quintonamore.recipies.parsers.p_food;
import quintonamore.recipies.utilities.RecipesDbHelper;
import quintonamore.recipies.utilities.RetrieveData;

/**
 * Site select android view, temporarily two buttons
 */
public class siteSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //RecipesDbHelper dbHelp = new RecipesDbHelper(getApplicationContext());

        //SQLiteDatabase db = dbHelp.getReadableDatabase();


    }


    /**
     * On Click for the food.com button, temporary.
     * @param view
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void onClickFood(View view) throws ExecutionException, InterruptedException {

        String str = "http://www.food.com/recipe";

        Intent intent = new Intent(this, MainURLenter.class);
        //Send the parsed recipe through the intent.
        intent.putExtra("url", str);
        startActivity(intent);
    }

    /**
     * On Click for the foodnetwork.com btn, temporary.
     * @param view
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void onClickFoodNet(View view) throws ExecutionException, InterruptedException {

        String str = "http://www.foodnetwork.com/recipes";

        Intent intent = new Intent(this, MainURLenter.class);
        //Send the parsed recipe through the intent.
        intent.putExtra("url", str);
        startActivity(intent);
    }

}
