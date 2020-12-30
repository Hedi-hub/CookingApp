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
        Ingredient ingredient1 = new Ingredient("Beef Steak(s)", 250, UnitOfMeasurements.GR );
        Ingredient ingredient2 = new Ingredient("Rice", 1, UnitOfMeasurements.CUP );
        Ingredient ingredient3 = new Ingredient("Carrot(s)", 1, UnitOfMeasurements.Piece );
        Ingredient ingredient4 = new Ingredient("Zucchini", 1, UnitOfMeasurements.Piece );
        Ingredient ingredient5 = new Ingredient("Mushroom(s)", 50, UnitOfMeasurements.GR );
        Ingredient ingredient6 = new Ingredient("Bean Sprouts", 150, UnitOfMeasurements.GR );
        Ingredient ingredient7 = new Ingredient("Egg(s)", 2, UnitOfMeasurements.Pieces );
        Ingredient ingredient8 = new Ingredient("Soy Sauce", 2, UnitOfMeasurements.TBSP );
        Ingredient ingredient9 = new Ingredient("Sesame Oil", 2, UnitOfMeasurements.TBSP );
        Ingredient ingredient10 = new Ingredient("Onion(s)", 1, UnitOfMeasurements.Piece );
        Ingredient ingredient11 = new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves );
        Ingredient ingredient12 = new Ingredient("Sugar", 1, UnitOfMeasurements.TSP );
        Ingredient ingredient13 = new Ingredient("Pepper", 1.5, UnitOfMeasurements.TSP );
        Ingredient ingredient14 = new Ingredient("Apple(or Korean Pear)", 1, UnitOfMeasurements.Piece );
//        ArrayList<Ingredient> list1 = new ArrayList<>();
//        list1.add(ingredient1).add(ingredient2).add(ingredient3)
//                .add(ingredient4).add(ingredient5).add(ingredient6)
//                .add(ingredient7).add(ingredient8).add(ingredient9)
//                .add(ingredient10).add(ingredient11).add(ingredient12);

//        List<Ingredient> list1 = Arrays.asList( ingredient1,ingredient2,ingredient3,
//                ingredient4,ingredient5,ingredient6,ingredient7,ingredient8,
//                ingredient9,ingredient10,ingredient11,ingredient12,
//                ingredient13,ingredient14);
//        ArrayList<Ingredient> otherList = new ArrayList<>();
//        otherList.addAll(list1);

        //***THIS LINE WOULD BE MY LAST SOLUTION TO ADDING TO MY ARRAYLIST***
        List<Ingredient> list1 = new ArrayList<>();
        list1.addAll(asList(ingredient1,ingredient2,ingredient3,
                ingredient4,ingredient5,ingredient6,ingredient7,ingredient8,
                ingredient9,ingredient10,ingredient11,ingredient12,
                ingredient13,ingredient14));
        Recipe recipe1 = new Recipe("Bibimbap",list1, 2, 1000, "Korean Dish With Beef And Veggies");

        Ingredient ing_1 = new Ingredient("chicken Filet", 200, UnitOfMeasurements.GR );
        Ingredient ing_2 = new Ingredient("pasta", 200, UnitOfMeasurements.GR );
        Ingredient ing_3 = new Ingredient("Mushroom(s)", 100, UnitOfMeasurements.GR );
        Ingredient ing_4 = new Ingredient("Milk", 100, UnitOfMeasurements.ML );
        Ingredient ing_5 = new Ingredient("Cream", 100, UnitOfMeasurements.ML );
        Ingredient ing_6 = new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves );
        Ingredient ing_7 = new Ingredient("Small shallot", 1, UnitOfMeasurements.Piece );
        Ingredient ing_8 = new Ingredient("salt", 1.5, UnitOfMeasurements.TSP );
        Ingredient ing_9 = new Ingredient("pepper", 1.5, UnitOfMeasurements.TSP );
        List<Ingredient> list2 = new ArrayList<>();
        list2.addAll(asList(ing_1,ing_2,ing_3,ing_4,
                ing_5,ing_6,ing_7,ing_8,ing_9));
        Recipe recipe2 = new Recipe("Pasta Alfredo",list2, 2,2000,"Creamy Pasta With Chicken");

        Ingredient ing1 = new Ingredient("Chinese Cabbage", 2, UnitOfMeasurements.Pieces );
        Ingredient ing2 = new Ingredient("Korean Chilli Powder", 4, UnitOfMeasurements.TBSP );
        Ingredient ing3 = new Ingredient("Fish Sauce", 3, UnitOfMeasurements.TBSP );
        Ingredient ing4 = new Ingredient("Salt", 100, UnitOfMeasurements.GR );
        Ingredient ing5 = new Ingredient("Spring Onion", 3, UnitOfMeasurements.Pieces );
        Ingredient ing6 = new Ingredient("onion", 1, UnitOfMeasurements.Piece );
        Ingredient ing7 = new Ingredient("Garlic(s)", 10, UnitOfMeasurements.Cloves );
        Ingredient ing8 = new Ingredient("Flour", 2, UnitOfMeasurements.TBSP );
        Ingredient ing9 = new Ingredient("Water", 100, UnitOfMeasurements.ML );
        Ingredient ing10 = new Ingredient("Carrot(s)", 2, UnitOfMeasurements.Pieces );
        List<Ingredient> list3 = new ArrayList<>();
        list3.addAll(asList(ing1,ing2,ing3,ing4,ing5,
                ing6,ing7,ing8,ing9,ing10));
        Recipe recipe3 = new Recipe("Kimchi",list3, 2, 1000, "Korean Cabbage Salad");



        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);


    }

}
