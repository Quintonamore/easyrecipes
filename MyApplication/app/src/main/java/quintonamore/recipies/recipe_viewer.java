package quintonamore.recipies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import quintonamore.recipies.parsers.p_food;

public class recipe_viewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_viewer);
        p_food parse = (p_food) getIntent().getSerializableExtra("Recipe");

        TextView t  = (TextView)findViewById(R.id.textView2);
        t.setText(parse.r_parse.getIName(0));

    }
}
