package quintonamore.recipies;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import quintonamore.recipies.parsers.p_food;
import quintonamore.recipies.utilities.RetrieveData;

import static quintonamore.recipies.R.id.gen_recipe;
import static quintonamore.recipies.R.id.url_input;

public class MainURLenter extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_urlenter);

    }


    public void onClick(View view) throws ExecutionException, InterruptedException {

        EditText t = (EditText)findViewById(R.id.url_input);
        String s = t.getText().toString();

        RetrieveData d = new RetrieveData();
        d.execute(s);
        p_food parse = d.get();

        Intent intent = new Intent(this, recipe_viewer.class);
        //Send the parsed recipe through the intent.
        intent.putExtra("Recipe", parse);
        startActivity(intent);
    }

}
