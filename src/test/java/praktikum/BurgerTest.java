package praktikum;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Класс с юнит тестами Burger
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class BurgerTest {

  private Burger burger;

  /**
   * Mock базы данных
   */
  @Mock
  Database database;

  @Mock
  Bun bunMock;

  @Mock
  Ingredient ingredientMock;

  /**
   * Метод инициализации моковой базы данных
   */
  @Before
  public void setDatabase() {
    Mockito.when(database.availableBuns()).thenReturn(List.of(
        new Bun(Constants.WHITE_BUN, Constants.FIRST_PRICE),
        new Bun(Constants.BLACK_BUN, Constants.SECOND_PRICE),
        new Bun(Constants.RED_BUN, Constants.THIRD_PRICE)
    ));

    Mockito.when(database.availableIngredients()).thenReturn(List.of(
        new Ingredient(IngredientType.SAUCE, Constants.HOT_SAUCE, Constants.FIRST_PRICE),
        new Ingredient(IngredientType.SAUCE, Constants.SOUR_CREAM, Constants.SECOND_PRICE),
        new Ingredient(IngredientType.SAUCE, Constants.CHILI_SAUCE, Constants.THIRD_PRICE),

        new Ingredient(IngredientType.FILLING, Constants.CUTLET, Constants.FIRST_PRICE),
        new Ingredient(IngredientType.FILLING, Constants.SAUSAGE, Constants.THIRD_PRICE)
    ));

    burger = new Burger();
    burger.addIngredient(database.availableIngredients().get(0));
    burger.addIngredient(database.availableIngredients().get(1));
  }

  @Test
  public void setBunsTest() {
    burger.setBuns(database.availableBuns().get(1));
    Assert.assertEquals(Constants.BLACK_BUN, burger.bun.name);
    Assert.assertEquals(Constants.SECOND_PRICE, burger.bun.getPrice(), 0.0);
  }

  @Test
  public void addIngredientTest() {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "new ingredient", Constants.FIRST_PRICE);
    int sizeOfIngredients = ingredientsCount();
    burger.addIngredient(ingredient);
    Assert.assertEquals(sizeOfIngredients + 1, burger.ingredients.size());
    Assert.assertTrue(burger.ingredients.contains(ingredient));
  }

  @Test
  public void removeIngredientTest() {
    int sizeOfIngredients = ingredientsCount();
    Ingredient removedIngredient = burger.ingredients.get(0);
    burger.removeIngredient(0);
    Assert.assertEquals(sizeOfIngredients - 1, burger.ingredients.size());
    Assert.assertFalse(burger.ingredients.contains(removedIngredient));
  }

  @Test
  public void moveIngredientTest() {
    Ingredient movedIng = new Ingredient(IngredientType.FILLING, "moved ingredient", Constants.FIRST_PRICE);
    burger.addIngredient(movedIng);
    int sizeOfIngredients = ingredientsCount();
    burger.moveIngredient(2, 0);
    Assert.assertEquals(movedIng, burger.ingredients.get(0));
    Assert.assertEquals(sizeOfIngredients, burger.ingredients.size());
  }

  @Test
  public void getReceiptTest() {
    burger.setBuns(bunMock);
    burger.ingredients.clear();
    burger.addIngredient(ingredientMock);
    Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);

    burger.getReceipt();
    Mockito.verify(bunMock, Mockito.times(2)).getName();
    int sizeOfIngredients = ingredientsCount();
    Mockito.verify(ingredientMock, Mockito.times(sizeOfIngredients)).getType();
    Mockito.verify(ingredientMock, Mockito.times(sizeOfIngredients)).getName();
  }

  private int ingredientsCount() {
    return burger.ingredients.size();
  }
}
