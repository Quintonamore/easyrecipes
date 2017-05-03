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
        //THis test requires that this webpage stays the same, changes can cause the parser to not funciton correctly.
        p_food t = new p_food("http://www.food.com/recipe/bourbon-chicken-45809");

        assertEquals(t.r_parse.recipeName, "Bourbon Chicken");

        System.out.println(t.toString());

    }

    @Test
    public void ingredientTestNet() throws Exception {
        //Test requires that this webpage stays the same
        p_foodnetwork t = new p_foodnetwork("http://www.foodnetwork.com/recipes/slow-cooker-corned-beef-and-cabbage-recipe");

        assertEquals(t.r_parse.getIAmount(0), "2 stalks celery, halved");
        assertEquals(t.r_parse.getIAmount(t.r_parse.getNumIngredients()-1), "salt and pepper to tast");

    }

    @Test
    public void nameTestNet() throws Exception {
        //Test requires this webpage to exist, same with other tests.
        p_foodnetwork t = new p_foodnetwork("http://www.foodnetwork.com/recipes/tyler-florence/chicken-parmesan-recipe");

        assertEquals(t.r_parse.recipeName, "Chicken Parmesan");


    }

    @Test
    public void ingredientTestFood() throws Exception {
        //Test for food.com ingredients
        p_food t = new p_food("http://www.food.com/recipe/raspberry-lime-iced-tea-9499");

        assertEquals(t.r_parse.getIAmount(0), "1 1⁄2 cups slightly defrosted frozen raspberries");
        assertEquals(t.r_parse.getIAmount(t.r_parse.getNumIngredients()-1), "4 cups ice-brewed black tea or 4 cups ice-brewed green tea");
    }
}