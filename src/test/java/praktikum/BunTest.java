package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Класс с юнит тестами Bun
 */
public class BunTest {

  Bun bun;

  /**
   * Создание данных перед каждым тестом
   */
  @Before
  public void setData() {
    bun = new Bun(Constants.WHITE_BUN, Constants.HUNDRED);
  }

  /**
   * Удаление данных после каждого теста
   */
  @After
  public void cleanTestData() {
    bun = null;
  }

  /**
   * Позитивный тест получения названия
   */
  @Test
  public void getNameTest() {
    Assert.assertEquals(Constants.WHITE_BUN, bun.getName());
  }

  /**
   * Позитивный тест получения цены
   */
  @Test
  public void getPriceTest() {
    Assert.assertEquals(Constants.HUNDRED, bun.getPrice(), 0.0);
  }

  /**
   * Негативный тест получения названия
   */
  @Test
  public void getWrongNameThenFail() {
    Assert.assertNotEquals(Constants.BLACK_BUN, bun.getName());
  }

  /**
   * Негативный тест получения цены
   */
  @Test
  public void getWrongPriceThenFail() {
    Assert.assertNotEquals(Constants.HUNDRED, bun.getPrice() + 1, 0.0);
  }
}
