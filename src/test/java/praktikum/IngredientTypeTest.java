package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void shouldReturnSauceName() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void shouldReturnFillingName() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}