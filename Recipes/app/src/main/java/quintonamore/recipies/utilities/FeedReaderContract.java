package quintonamore.recipies.utilities;

import android.provider.BaseColumns;

/**
 * Created by teas9 on 3/12/2017.
 *
 * FeedReaderContract class as to keep the standard naming variables for the SQLite database.
 *
 */

public class FeedReaderContract {

    private FeedReaderContract(){}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "recipe";
        public static final String COLUMN_NAME_TITLE = "body";
    }
}
