package cookingguide.initialData;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.models.UnitOfMeasurements;
import cookingguide.repositories.IngredientRepository;
import cookingguide.repositories.RecipeRepository;
import cookingguide.services.IngredientService;
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
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientRepository ingredientRepository;

    //add the @PostConstruct
    @PostConstruct
    public void initializedInfo(){

        Recipe recipe1 = new Recipe(1,"Bibimbap", 2, 1000, "Korean Dish With Beef And Veggies","https://media.istockphoto.com/photos/bi-bim-bap-picture-id183752521?k=6&m=183752521&s=612x612&w=0&h=GfrqG2gYZbmBbUpETOCAzgDz2SttMP2em5EztLB6mF4=");
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

        recipe1.getIngredientList().add(ingredient1);
        recipe1.getIngredientList().add(ingredient2);
        recipe1.getIngredientList().add(ingredient3);
        recipe1.getIngredientList().add(ingredient4);
        recipe1.getIngredientList().add(ingredient5);
        recipe1.getIngredientList().add(ingredient6);
        recipe1.getIngredientList().add(ingredient7);
        recipe1.getIngredientList().add(ingredient8);
        recipe1.getIngredientList().add(ingredient9);
        recipe1.getIngredientList().add(ingredient10);
        recipe1.getIngredientList().add(ingredient11);
        recipe1.getIngredientList().add(ingredient12);
        recipe1.getIngredientList().add(ingredient13);
        recipe1.getIngredientList().add(ingredient14);
        recipe1.getIngredientList().add(ingredient15);

        Recipe recipe2 = new Recipe(2,"Steak", 1, 300, "Juicy american style steak","https://pixabay.com/get/g9175fcf554b250869089399151359deeefac9ffdbf9bd46a438a00c0af14e766a1eb5acc522291956dfe15ea67305701_640.jpg");
        Ingredient ing1 = new Ingredient("Rib Eye",200, UnitOfMeasurements.GR);
        Ingredient ing2 = new Ingredient("Olive oil",1, UnitOfMeasurements.TBSP);
        Ingredient ing3 = new Ingredient("Salt",1.5, UnitOfMeasurements.TSP);
        Ingredient ing4 = new Ingredient("Pepper",1.5, UnitOfMeasurements.TSP);

        recipe2.getIngredientList().add(ing1);
        recipe2.getIngredientList().add(ing2);
        recipe2.getIngredientList().add(ing3);
        recipe2.getIngredientList().add(ing4);

        Recipe recipe3 = new Recipe(3,"Shakshuka", 2, 250,"Tunisian and Israelian dish","https://pixabay.com/get/gb2a9c4f3719b499d86bbb8addb2f05fe53145849beb6e44d102971af7a88604be86da1b9a4315bfaa8ddc6900d1beaba_640.jpg" );
        Ingredient ing_1 = new Ingredient("Eggs",2, UnitOfMeasurements.Pieces);
        Ingredient ing_2 = new Ingredient("Tomato pure",2, UnitOfMeasurements.TBSP);
        Ingredient ing_3 = new Ingredient("Paprika Powder",1.2, UnitOfMeasurements.TSP);
        Ingredient ing_4 = new Ingredient("Salt",1.2, UnitOfMeasurements.TSP);
        Ingredient ing_5 = new Ingredient("Fresh Tomatoes",4, UnitOfMeasurements.Pieces);

        recipe3.getIngredientList().add(ing_1);
        recipe3.getIngredientList().add(ing_2);
        recipe3.getIngredientList().add(ing_3);
        recipe3.getIngredientList().add(ing_4);
        recipe3.getIngredientList().add(ing_5);




////        recipe1.getIngredientList().add(
////                new Ingredient("Rice", 1, UnitOfMeasurements.CUP )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Carrot(s)", 1, UnitOfMeasurements.Piece )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Zucchini", 1, UnitOfMeasurements.Piece )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Mushroom(s)", 50, UnitOfMeasurements.GR  )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Bean Sprouts", 150, UnitOfMeasurements.GR  )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Egg(s)", 2, UnitOfMeasurements.Pieces  )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Soy Sauce", 2, UnitOfMeasurements.TBSP )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Sesame Oil", 2, UnitOfMeasurements.TBSP )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Onion(s)", 1, UnitOfMeasurements.Piece  )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves  )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Sugar", 1, UnitOfMeasurements.TSP  )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Pepper", 1.5, UnitOfMeasurements.TSP   )
////        );
////        recipe1.getIngredientList().add(
////                new Ingredient("Apple(or Korean Pear)", 1, UnitOfMeasurements.Piece  )
////        );
//        //********************************************************************************************************************************//
//        Recipe recipe2 = new Recipe("Pasta Alfredo",2,350,"Creamy Pasta With Chicken");
//        recipe2.getIngredientList().add(
//                new Ingredient("Chinese Cabbage", 2, UnitOfMeasurements.Pieces)
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("pasta", 200, UnitOfMeasurements.GR)
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("Mushroom(s)", 100, UnitOfMeasurements.GR)
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("Milk", 100, UnitOfMeasurements.ML )
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("Cream", 100, UnitOfMeasurements.ML)
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves)
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("Small shallot", 1, UnitOfMeasurements.Piece )
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("salt", 1.5, UnitOfMeasurements.TSP)
//        );
//        recipe2.getIngredientList().add(
//                new Ingredient("pepper", 1.5, UnitOfMeasurements.TSP)
//        );
//        //********************************************************************************************************************************//
//        Recipe recipe3 = new Recipe("Kimchi",2, 1000, "Korean Cabbage Salad");
//
//        recipe3.getIngredientList().add(
//                new Ingredient("Chinese Cabbage", 2, UnitOfMeasurements.Pieces)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Korean Chilli Powder", 4, UnitOfMeasurements.TBSP)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Fish Sauce", 3, UnitOfMeasurements.TBSP)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Salt", 100, UnitOfMeasurements.GR )
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Spring Onion", 3, UnitOfMeasurements.Pieces )
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("onion", 1, UnitOfMeasurements.Piece)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Garlic(s)", 10, UnitOfMeasurements.Cloves)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Flour", 2, UnitOfMeasurements.TBSP)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Water", 100, UnitOfMeasurements.ML)
//        );
//        recipe3.getIngredientList().add(
//                new Ingredient("Carrot(s)", 2, UnitOfMeasurements.Pieces)
//        );


        //********************************************************************************************************************************//

        recipeService.saveRecipe(recipe1);
        for(Ingredient ingredient : recipe1.getIngredientList()){
            ingredient.setRecipe(recipe1);
            ingredientRepository.save(ingredient);
        }

        recipeService.saveRecipe(recipe2);
        for(Ingredient ingredient : recipe2.getIngredientList()){
            ingredient.setRecipe(recipe2);
            ingredientRepository.save(ingredient);
        }

        recipeService.saveRecipe(recipe3);
        for (Ingredient ingredient : recipe3.getIngredientList()){
            ingredient.setRecipe(recipe3);
            ingredientRepository.save(ingredient);
        }

//        recipeService.saveRecipe(recipe1);
//        recipeService.saveRecipe(recipe2);
//        recipeService.saveRecipe(recipe3);
//
//        ingredientRepository.save(recipe1.getIngredientList().get(0));
//        ingredientRepository.save(recipe1.getIngredientList().get(1));


        System.out.println(ingredientRepository.findIngredientsByRecipe(recipe1));







    }

}
