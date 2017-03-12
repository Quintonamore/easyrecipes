package quintonamore.recipies.utilities;

import android.os.AsyncTask;

import quintonamore.recipies.parsers.p_food;
import quintonamore.recipies.parsers.recipeParse;

/**
 * Created by Quinton on 11/17/2016.
 */

public class RetrieveData extends AsyncTask<String, Void, p_food> {
    @Override
    protected p_food doInBackground(String... strings) {
        try{
            p_food parse = new p_food(strings[0]);
            return parse;
        } catch (Exception e){
            return null;
        }
    }
}
