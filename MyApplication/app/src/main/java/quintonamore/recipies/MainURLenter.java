package quintonamore.recipies;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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

        Toolbar tbar = (Toolbar) findViewById(R.id.urlToolbar);
        setSupportActionBar(tbar);

        //Web View Setup
        WebView b = (WebView) findViewById(R.id.webView);


        //Setting edits needed to view webpages.
        b.getSettings().setJavaScriptEnabled(true);

        b.getSettings().setAllowContentAccess(true);
        b.getSettings().setAllowFileAccess(true);
        b.getSettings().setDatabaseEnabled(true);
        b.getSettings().setDomStorageEnabled(true);

        b.setWebViewClient(new WebViewClient());

        //Set the webview to the only site I have set up data scraping from.
        b.loadUrl("http://www.food.com/recipe");


    }


    public void onClick(View view) throws ExecutionException, InterruptedException {

        //Old get the recipe from text.
        //EditText t = (EditText)findViewById(R.id.url_input);

        WebView wbv = (WebView) findViewById(R.id.webView);
        String s = wbv.getUrl();

        RetrieveData d = new RetrieveData();
        d.execute(s);
        p_food parse = d.get();

        Intent intent = new Intent(this, recipe_viewer.class);
        //Send the parsed recipe through the intent.
        intent.putExtra("Recipe", parse);
        startActivity(intent);
    }

}
