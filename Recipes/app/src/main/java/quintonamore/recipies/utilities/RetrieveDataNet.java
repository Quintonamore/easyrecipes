package quintonamore.recipies.utilities;

import android.os.AsyncTask;

import quintonamore.recipies.parsers.p_foodnetwork;

/**
 * Created by Quinton on 11/17/2016.
 */

public class RetrieveDataNet extends AsyncTask<String, Void, p_foodnetwork> {
    @Override
    protected p_foodnetwork doInBackground(String... strings) {
        try{
            p_foodnetwork parse = new p_foodnetwork(strings[0]);
            return parse;
        } catch (Exception e){
            return null;
        }
    }
}
