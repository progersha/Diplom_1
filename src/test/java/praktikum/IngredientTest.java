package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    private final IngredientType ingredientType = IngredientType.FILLING;
    private final String name = "dinosaur";
    private final float price = 200F;

    private final Ingredient ingredient = new Ingredient(ingredientType, name, price);

    @Test
    public void getPrice() {
        Assert.assertEquals(ingredient.getPrice(), price, 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(ingredient.getName(), name);
    }

    @Test
    public void getType() {
        Assert.assertEquals(ingredient.getType(), ingredientType);
    }
}