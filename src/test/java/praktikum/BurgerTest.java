package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    @Test
    public void shouldSetBunsAndCalculatePriceCorrectly() {
        Bun bun = new Bun("Black bun", 100f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(200f, burger.getPrice(), 0.01f);
    }

    @Test
    public void shouldAddIngredientsAndCalculateTotalPrice() {
        Bun bun = new Bun("Black bun", 100f);
        Ingredient ing1 = new Ingredient(IngredientType.FILLING, "Beef", 50f);
        Ingredient ing2 = new Ingredient(IngredientType.SAUCE, "Chili sauce", 70f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        assertEquals(320f, burger.getPrice(), 0.01f);
    }

    @Test
    public void shouldRemoveIngredientAndRecalculatePrice() {
        Bun bun = new Bun("White bun", 80f);
        Ingredient ing1 = new Ingredient(IngredientType.FILLING, "Chicken", 60f);
        Ingredient ing2 = new Ingredient(IngredientType.SAUCE, "Ketchup", 30f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);
        burger.removeIngredient(0);

        assertEquals(190f, burger.getPrice(), 0.01f);
    }

    @Test
    public void shouldMoveIngredient() {
        Bun bun = new Bun("Red bun", 120f);
        Ingredient ing1 = new Ingredient(IngredientType.FILLING, "Salmon", 150f);
        Ingredient ing2 = new Ingredient(IngredientType.SAUCE, "Soy sauce", 40f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);
        burger.moveIngredient(0, 1);

        String receipt = burger.getReceipt();
        int salmonIndex = receipt.indexOf("Salmon");
        int soyIndex = receipt.indexOf("Soy sauce");
        assertTrue(soyIndex < salmonIndex);
    }

    @Test
    public void shouldGetCorrectReceipt() {
        Bun bun = new Bun("Black bun", 100f);
        Ingredient beef = new Ingredient(IngredientType.FILLING, "Beef", 200f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Chili sauce", 50f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(beef);
        burger.addIngredient(sauce);

        String expectedReceipt =
                "(==== Black bun ====)\r\n" +
                        "= filling Beef =\r\n" +
                        "= sauce Chili sauce =\r\n" +
                        "(==== Black bun ====)\r\n" +
                        "\r\n" +
                        "Price: 450,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
    // =============== ТЕСТ С МОКАМИ ===============
    @Test
    public void shouldCalculatePriceUsingMocks() {
        Bun mockBun = mock(Bun.class);
        Ingredient mockIng1 = mock(Ingredient.class);
        Ingredient mockIng2 = mock(Ingredient.class);

        when(mockBun.getPrice()).thenReturn(90f);
        when(mockIng1.getPrice()).thenReturn(60f);
        when(mockIng2.getPrice()).thenReturn(40f);

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIng1);
        burger.addIngredient(mockIng2);

        assertEquals(280f, burger.getPrice(), 0.01f);
    }
}