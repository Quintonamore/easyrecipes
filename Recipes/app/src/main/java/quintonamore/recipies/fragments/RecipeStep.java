package quintonamore.recipies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import quintonamore.recipies.R;

/**
 * Created by teas9 on 4/5/2017.
 */

public class RecipeStep extends Fragment{


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_recipe_viewer, container, false);

    }
}
