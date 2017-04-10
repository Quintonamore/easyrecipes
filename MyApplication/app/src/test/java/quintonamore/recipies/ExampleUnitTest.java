package quintonamore.recipies;

import org.junit.Test;

import quintonamore.recipies.parsers.p_food;
import quintonamore.recipies.parsers.p_foodnetwork;

import static org.junit.Assert.*;

/**
 * Originally generated test file, now using Example Unit Test to test the functionality
 * of the p_food class.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * Note to self, more comprehensive testing on parsers.
 */
public class ExampleUnitTest {
    /*
    @Test
    Test to make sure the food parser works properly.
    }
    */
    @Test
    public void nameTest() throws Exception {
        p_food t = new p_food("http://www.food.com/recipe/bourbon-chicken-45809");

        assertEquals(t.r_parse.recipeName, "Bourbon Chicken");

        System.out.println(t.toString());

    }

    @Test
    public void ingredientTest() throws Exception {
        p_foodnetwork t = new p_foodnetwork("http://www.foodnetwork.com/recipes/slow-cooker-corned-beef-and-cabbage-recipe");

        System.out.println(t.r_parse.recipeName);

        System.out.println(t.r_parse.getNumIngredients());



    }
}