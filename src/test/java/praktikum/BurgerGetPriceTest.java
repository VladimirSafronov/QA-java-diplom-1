package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Параметризованные тесты Burger.getPrice()
 */
@RunWith(Parameterized.class)
public class BurgerGetPriceTest {

  private Burger burger;

  /**
   * Первый параметр
   */
  @Parameter(0)
  public Bun bun;

  /**
   * Второй параметр
   */
  @Parameter(1)
  public Ingredient[] ingredients;

  /**
   * Третий параметр
   */
  @Parameter(2)
  public float price;

  /**
   * Метод инициализирующий параметры для тестов
   */
  @Parameters
  public static Object[][] setParameters() {
    return new Object[][]{
        {new Bun(Constants.WHITE_BUN, Constants.FIRST_PRICE), new Ingredient[]{
            new Ingredient(IngredientType.SAUCE, Constants.CHILI_SAUCE, Constants.FIRST_PRICE),
            new Ingredient(IngredientType.FILLING, Constants.SAUSAGE, Constants.SECOND_PRICE)},
            500f},
        {new Bun(Constants.BLACK_BUN, Constants.SECOND_PRICE), new Ingredient[]{
            new Ingredient(IngredientType.SAUCE, Constants.HOT_SAUCE, Constants.THIRD_PRICE),
            new Ingredient(IngredientType.FILLING, Constants.CUTLET, Constants.SECOND_PRICE)},
            900f},
        {new Bun(Constants.RED_BUN, Constants.THIRD_PRICE), new Ingredient[]{
            new Ingredient(IngredientType.SAUCE, Constants.SOUR_CREAM, Constants.SECOND_PRICE),
            new Ingredient(IngredientType.FILLING, Constants.CUTLET, Constants.SECOND_PRICE),
            new Ingredient(IngredientType.FILLING, Constants.SAUSAGE, Constants.THIRD_PRICE)},
            1300f}
    };
  }

  /**
   * Создание данных перед каждым тестом
   */
  @Before
  public void setTestData() {
    burger = new Burger();
    burger.setBuns(bun);
    for (Ingredient ingredient : ingredients) {
      burger.addIngredient(ingredient);
    }
  }

  @Test
  public void getPriceTest() {
    Assert.assertEquals(price, burger.getPrice(), 0.0);
  }
}
