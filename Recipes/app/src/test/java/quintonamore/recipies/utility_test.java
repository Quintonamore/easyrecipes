package quintonamore.recipies;

import org.junit.Test;

import quintonamore.recipies.utilities.RetrieveData;

/**
 * Created by teas9 on 4/28/2017.
 *
 * Test to run the utilities outside of the application, and ensure they work.
 */

public class utility_test {

    @Test
    public void utilTest() throws Exception{

        RetrieveData data = new RetrieveData();
        try{
            data.execute("www.google.com");
        } catch(Exception e){

        }
    }

}
