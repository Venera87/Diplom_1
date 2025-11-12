package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Black bun", 100f},
                {"White bun", 80f},
                {"Red bun", 120f}
        });
    }

    @Test
    public void shouldGetCorrectName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void shouldGetCorrectPrice() {
        assertEquals(price, bun.getPrice(), 0.01f);
    }
}
