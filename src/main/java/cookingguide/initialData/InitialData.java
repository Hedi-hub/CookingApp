package cookingguide.initialData;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.models.UnitOfMeasurements;
import cookingguide.repositories.RecipeRepository;
import cookingguide.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Configuration
public class InitialData {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeService recipeService;

    //add the @PostConstruct
    @PostConstruct
    public void initializedInfo(){

        Recipe recipe1 = new Recipe("Bibimbap", 2, 1000, "Korean Dish With Beef And Veggies");
        recipe1.getIngredientList().add(
                new Ingredient("Beef Steak(s)", 250, UnitOfMeasurements.GR)
        );
        recipe1.getIngredientList().add(
                new Ingredient("Rice", 1, UnitOfMeasurements.CUP )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Carrot(s)", 1, UnitOfMeasurements.Piece )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Zucchini", 1, UnitOfMeasurements.Piece )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Mushroom(s)", 50, UnitOfMeasurements.GR  )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Bean Sprouts", 150, UnitOfMeasurements.GR  )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Egg(s)", 2, UnitOfMeasurements.Pieces  )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Soy Sauce", 2, UnitOfMeasurements.TBSP )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Sesame Oil", 2, UnitOfMeasurements.TBSP )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Onion(s)", 1, UnitOfMeasurements.Piece  )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves  )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Sugar", 1, UnitOfMeasurements.TSP  )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Pepper", 1.5, UnitOfMeasurements.TSP   )
        );
        recipe1.getIngredientList().add(
                new Ingredient("Apple(or Korean Pear)", 1, UnitOfMeasurements.Piece  )
        );
        //********************************************************************************************************************************//
        Recipe recipe2 = new Recipe("Pasta Alfredo",2,350,"Creamy Pasta With Chicken");
        recipe2.getIngredientList().add(
                new Ingredient("Chinese Cabbage", 2, UnitOfMeasurements.Pieces)
        );
        recipe2.getIngredientList().add(
                new Ingredient("pasta", 200, UnitOfMeasurements.GR)
        );
        recipe2.getIngredientList().add(
                new Ingredient("Mushroom(s)", 100, UnitOfMeasurements.GR)
        );
        recipe2.getIngredientList().add(
                new Ingredient("Milk", 100, UnitOfMeasurements.ML )
        );
        recipe2.getIngredientList().add(
                new Ingredient("Cream", 100, UnitOfMeasurements.ML)
        );
        recipe2.getIngredientList().add(
                new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves)
        );
        recipe2.getIngredientList().add(
                new Ingredient("Small shallot", 1, UnitOfMeasurements.Piece )
        );
        recipe2.getIngredientList().add(
                new Ingredient("salt", 1.5, UnitOfMeasurements.TSP)
        );
        recipe2.getIngredientList().add(
                new Ingredient("pepper", 1.5, UnitOfMeasurements.TSP)
        );
        //********************************************************************************************************************************//
        Recipe recipe3 = new Recipe("Kimchi",2, 1000, "Korean Cabbage Salad");

        recipe3.getIngredientList().add(
                new Ingredient("Chinese Cabbage", 2, UnitOfMeasurements.Pieces)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Korean Chilli Powder", 4, UnitOfMeasurements.TBSP)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Fish Sauce", 3, UnitOfMeasurements.TBSP)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Salt", 100, UnitOfMeasurements.GR )
        );
        recipe3.getIngredientList().add(
                new Ingredient("Spring Onion", 3, UnitOfMeasurements.Pieces )
        );
        recipe3.getIngredientList().add(
                new Ingredient("onion", 1, UnitOfMeasurements.Piece)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Garlic(s)", 10, UnitOfMeasurements.Cloves)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Flour", 2, UnitOfMeasurements.TBSP)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Water", 100, UnitOfMeasurements.ML)
        );
        recipe3.getIngredientList().add(
                new Ingredient("Carrot(s)", 2, UnitOfMeasurements.Pieces)
        );


        //********************************************************************************************************************************//
        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);




    }

}
