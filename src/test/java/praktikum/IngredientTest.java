package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Chili sauce", 100f},
                {IngredientType.FILLING, "Beef", 200f},
                {IngredientType.SAUCE, "Sour cream", 50f},
                {IngredientType.FILLING, "Cheese", 150f}
        });
    }

    @Test
    public void shouldGetCorrectType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void shouldGetCorrectName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void shouldGetCorrectPrice() {
        assertEquals(price, ingredient.getPrice(), 0.01f);
    }
}