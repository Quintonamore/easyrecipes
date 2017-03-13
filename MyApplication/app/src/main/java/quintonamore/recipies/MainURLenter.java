package quintonamore.recipies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


import java.util.concurrent.ExecutionException;

import quintonamore.recipies.parsers.p_food;
import quintonamore.recipies.parsers.p_foodnetwork;
import quintonamore.recipies.parsers.recipeParse;
import quintonamore.recipies.utilities.RetrieveData;
import quintonamore.recipies.utilities.RetrieveDataNet;

import static quintonamore.recipies.R.id.gen_recipe;

/**
 * This is where the user will find the recipe they want and then submit it
 * so that they can easily read and keep the recipe on their phone.
 *
 */
public class MainURLenter extends AppCompatActivity {

    private Button btn;
    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_urlenter);

        //Web View Setup
        WebView b = (WebView) findViewById(R.id.webView);


        //Setting edits needed to view webpages.
        b.getSettings().setJavaScriptEnabled(true);

        b.getSettings().setAllowContentAccess(true);
        b.getSettings().setAllowFileAccess(true);
        b.getSettings().setDatabaseEnabled(true);
        b.getSettings().setDomStorageEnabled(true);

        b.setWebViewClient(new WebViewClient());

        website = (String) getIntent().getSerializableExtra("url");

        //Set the webview to the only site I have set up data scraping from.
        b.loadUrl(website);


    }


    public void onClick(View view) throws ExecutionException, InterruptedException {

        //Old get the recipe from text.
        //EditText t = (EditText)findViewById(R.id.url_input);

        WebView wbv = (WebView) findViewById(R.id.webView);
        String s = wbv.getUrl();

        recipeParse parse;

        //Check to see which parser to use
        if(website == "http://www.food.com/recipe"){
            RetrieveData d = new RetrieveData();
            d.execute(s);
            parse = d.get();

        }
        else{
            RetrieveDataNet d = new RetrieveDataNet();
            d.execute(s);
            parse = d.get();
        }

        Intent intent = new Intent(this, recipe_viewer.class);
        //Send the parsed recipe through the intent.
        intent.putExtra("Recipe", parse);
        startActivity(intent);
    }

}
