package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sauce;

    private final String bunName = "white bun";
    private final float bunPrice = 100F;
    private final IngredientType sauceType = IngredientType.SAUCE;
    private final String sauceName = "sour cream";
    private final float saucePrice = 200F;
    private final IngredientType fillingType = IngredientType.FILLING;
    private final String fillingName = "dinosaur";
    private final float fillingPrice = 200F;

    Burger burger = new Burger();

    @Test
    public void addIngredientTest() {
        burger.addIngredient(filling);

        Assert.assertTrue(burger.ingredients.size() == 1 && burger.ingredients.contains(filling));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(filling);
        burger.removeIngredient(0);

        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(1,0);

        Assert.assertEquals(burger.ingredients.indexOf(filling), 1);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(filling.getPrice()).thenReturn(200F);

        burger.setBuns(bun);
        burger.addIngredient(filling);

        Assert.assertEquals(burger.getPrice(), 100F*2 + 200F, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(filling.getType()).thenReturn(fillingType);
        Mockito.when(filling.getName()).thenReturn(fillingName);
        Mockito.when(filling.getPrice()).thenReturn(fillingPrice);
        Mockito.when(sauce.getType()).thenReturn(sauceType);
        Mockito.when(sauce.getName()).thenReturn(sauceName);
        Mockito.when(sauce.getPrice()).thenReturn(saucePrice);

        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        String receipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName,
                fillingType.toString().toLowerCase(), fillingName,
                sauceType.toString().toLowerCase(), sauceName,
                bunName,
                bunPrice*2 + saucePrice + fillingPrice);

        Assert.assertEquals(burger.getReceipt(), receipt);
    }
}