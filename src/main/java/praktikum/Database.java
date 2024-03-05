package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun(Constants.BLACK_BUN, 100));
        buns.add(new Bun(Constants.WHITE_BUN, 200));
        buns.add(new Bun(Constants.RED_BUN, 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, Constants.HOT_SAUCE, 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, Constants.SOUR_CREAM, 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, Constants.CHILI_SAUCE, 300));

        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

}