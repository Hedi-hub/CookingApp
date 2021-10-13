package cookingguide.config;

import cookingguide.models.*;
import cookingguide.repositories.IngredientRepository;
import cookingguide.services.IngredientService;
import cookingguide.services.RecipeService;
import cookingguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class InitialData {


    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private void createAndSaveRecipe(Recipe recipe,User user ,Ingredient ... ingredients){
        for (Ingredient ingredient: ingredients){
            recipe.getIngredientList().add(ingredient);
        }

        recipe.setUser(user);
        recipeService.saveRecipe(recipe);

        for(Ingredient ingredient : recipe.getIngredientList()){
            ingredient.setRecipe(recipe);
            ingredientRepository.save(ingredient);
        }
    }

    /**
     * PostConstruct method
     */
    @PostConstruct
    public void initializedInfo(){


        User user = new User("Tom Hanks", "test@gmail.com",
                passwordEncoder.encode("test"), "USA, NY","Male" );
        userService.saveUser(user);

        User user2 = new User("Sara","sara@gmail.com",
                passwordEncoder.encode("test2"),"USA, NYC","female");
        userService.saveUser(user2);

        User user3 = new User("Heidi","heidi@gmail.com",
                passwordEncoder.encode("test3"),"Germany","female");
        userService.saveUser(user3);

        User user4 = new User("Michel","michel@gmail.com",
                passwordEncoder.encode("test4"),"USA, NYC","male");
        userService.saveUser(user4);

        User user5 = new User("Martha","martha24@gmail.com",
                passwordEncoder.encode("test5"),"Austria","female");
        userService.saveUser(user5);

        User user6 = new User("Maria","maria@gmail.com",
                passwordEncoder.encode("test2"),"Georgia","female");
        userService.saveUser(user6);


        Recipe recipe1 = new Recipe("Bibimbap", 2, 1000, "Korean Dish With Beef And Veggies","bibimbap.jpg", "Regional");
        Ingredient ingredient1 = new Ingredient("Beef Steak(s)", 250, UnitOfMeasurements.GR);
        Ingredient ingredient2 = new Ingredient("Rice", 1, UnitOfMeasurements.CUP );
        Ingredient ingredient3 = new Ingredient("Carrot(s)", 1, UnitOfMeasurements.Piece);
        Ingredient ingredient4 = new Ingredient("Zucchini", 1, UnitOfMeasurements.Piece);
        Ingredient ingredient5 = new Ingredient("Mushroom(s)", 50, UnitOfMeasurements.GR );
        Ingredient ingredient6 = new Ingredient("Bean Sprouts", 150, UnitOfMeasurements.GR );
        Ingredient ingredient7 = new Ingredient("Egg(s)", 2, UnitOfMeasurements.Pieces );
        Ingredient ingredient8 = new Ingredient("Soy Sauce", 2, UnitOfMeasurements.TBSP );
        Ingredient ingredient9 = new Ingredient("Sesame Oil", 2, UnitOfMeasurements.TBSP);
        Ingredient ingredient10 = new Ingredient("Onion(s)", 1, UnitOfMeasurements.Piece );
        Ingredient ingredient11 = new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves);
        Ingredient ingredient12 = new Ingredient("Sugar", 1, UnitOfMeasurements.TSP);
        Ingredient ingredient13 = new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves);
        Ingredient ingredient14 = new Ingredient("Pepper", 1.5, UnitOfMeasurements.TSP);
        Ingredient ingredient15 = new Ingredient("Apple(or Korean Pear)", 1, UnitOfMeasurements.Piece);

        createAndSaveRecipe(recipe1, user, ingredient1, ingredient2, ingredient3,
                ingredient4,ingredient5,ingredient6,ingredient7,ingredient8,ingredient9,
                ingredient10,ingredient11,ingredient11,ingredient12,
                ingredient13,ingredient14,ingredient15);


        Recipe recipe2 = new Recipe("Steak", 1, 300, "Juicy american style steak","steak.jpg","Seasonal");
        Ingredient ing1 = new Ingredient("Rib Eye",200, UnitOfMeasurements.GR);
        Ingredient ing2 = new Ingredient("Olive oil",1, UnitOfMeasurements.TBSP);
        Ingredient ing3 = new Ingredient("Salt",1.5, UnitOfMeasurements.TSP);
        Ingredient ing4 = new Ingredient("Pepper",1.5, UnitOfMeasurements.TSP);

        createAndSaveRecipe(recipe2, user, ing1, ing2, ing3,ing4);

        Recipe recipe3 = new Recipe("Shakshuka", 2, 250,"Tunisian and Israelian dish","food-ingredient.jpg","Regional" );
        Ingredient ing_1 = new Ingredient("Eggs",2, UnitOfMeasurements.Pieces);
        Ingredient ing_2 = new Ingredient("Tomato pure",2, UnitOfMeasurements.TBSP);
        Ingredient ing_3 = new Ingredient("Paprika Powder",1.2, UnitOfMeasurements.TSP);
        Ingredient ing_4 = new Ingredient("Salt",1.2, UnitOfMeasurements.TSP);
        Ingredient ing_5 = new Ingredient("Fresh Tomatoes",4, UnitOfMeasurements.Pieces);

        createAndSaveRecipe(recipe3, user2, ing_1, ing_2, ing_3,ing_4,ing_5);
    }

}
