package quintonamore.recipies;

import org.junit.Test;

import quintonamore.recipies.parsers.p_food;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    /*
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    */
    @Test
    public void t() throws Exception {
        p_food t = new p_food("http://www.food.com/recipe/bourbon-chicken-45809");
        System.out.println(t.r_parse.getIName(0) + t.r_parse.getIAmount(0));
    }
}