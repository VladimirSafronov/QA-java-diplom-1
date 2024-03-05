package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Класс с юнит тестами Ingredient
 */
public class IngredientTest {

  Ingredient ingredient;

  /**
   * Создание данных перед каждым тестом
   */
  @Before
  public void setData() {
    ingredient = new Ingredient(IngredientType.SAUCE, Constants.CHILI_SAUCE, Constants.HUNDRED);
  }

  /**
   * Удаление данных после каждого теста
   */
  @After
  public void cleanTestData() {
    ingredient = null;
  }

  /**
   * Позитивный тест получения типа
   */
  @Test
  public void getTypeTest() {
    Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
  }

  /**
   * Позитивный тест получения названия
   */
  @Test
  public void getNameTest() {
    Assert.assertEquals(Constants.CHILI_SAUCE, ingredient.getName());
  }

  /**
   * Позитивный тест получения цены
   */
  @Test
  public void getPriceTest() {
    Assert.assertEquals(Constants.HUNDRED, ingredient.getPrice(), 0.0);
  }

  /**
   * Негативный тест получения типа
   */
  @Test
  public void getWrongTypeThenFail() {
    Assert.assertNotEquals(IngredientType.FILLING, ingredient.getType());
  }

  /**
   * Негативный тест получения названия
   */
  @Test
  public void getWrongNameTest() {
    Assert.assertNotEquals(Constants.HOT_SAUCE, ingredient.getName());
  }

  /**
   * Негативный тест получения цены
   */
  @Test
  public void getWrongPriceThenFail() {
    Assert.assertNotEquals(Constants.HUNDRED, ingredient.getPrice() + 1, 0.0);
  }
}
