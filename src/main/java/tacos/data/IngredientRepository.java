package tacos.data;

import tacos.domain.Ingredient;

/**
 *
 * @author FeniksBV
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);

}
