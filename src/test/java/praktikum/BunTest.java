package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private final String name = "red bun";
    private final float price = 300F;

    Bun bun = new Bun(name, price);

    @Test
    public void getName() {
        Assert.assertEquals(bun.getName(), name);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bun.getPrice(), price, 0);
    }
}