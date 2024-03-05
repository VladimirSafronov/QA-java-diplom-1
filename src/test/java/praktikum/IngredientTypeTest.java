package praktikum;

import org.junit.Assert;
import org.junit.Test;

/**
 * Класс с юнит тестами IngredientType
 */
public class IngredientTypeTest {

  /**
   * Тест на количество ингридиентов
   */
  @Test
  public void countOfIngredientTypes() {
    Assert.assertEquals(2, IngredientType.values().length);
  }

  /**
   * Первый ингридиент - соус
   */
  @Test
  public void firstIngredientTypeTest() {
    Assert.assertEquals(IngredientType.SAUCE, IngredientType.values()[0]);
  }

  /**
   * Второй ингридиент - начинка
   */
  @Test
  public void secondIngredientTypeTest() {
    Assert.assertEquals(IngredientType.FILLING, IngredientType.values()[1]);
  }
}
