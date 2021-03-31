package cookingguide.controllers;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.models.UnitOfMeasurements;
import cookingguide.services.IngredientService;
import cookingguide.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserRecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping("/add-new-recipe")
    public String addNewRecipe(@RequestParam("recipeName") String recipeName,
                               @RequestParam("recipePortion") int recipePortion,
                               @RequestParam("description") String description,
                               @RequestParam("ingrTitles") String ingrTitles,
                               @RequestParam("ingrAmounts") String ingrAmounts,
                               @RequestParam("ingrUnits") String ingrUnits) {
        Recipe recipe = new Recipe(recipeName, recipePortion,0, description,"");
        recipeService.saveRecipe(recipe);
        String [] titles= ingrTitles.split(",");
        String [] units= ingrUnits.split(",");
        String [] amounts= ingrAmounts.split(",");

        List<Ingredient> ingredientList = new ArrayList<>();

        for (int index= 0; index< titles.length; index++){
            double amount = Double.valueOf(amounts[index]);
            String title = titles[index];
            UnitOfMeasurements unit = UnitOfMeasurements.valueOf(units[index]);
            Ingredient ingredient = new Ingredient(title, amount, unit);
            ingredientList.add(ingredient);

            ingredient.setRecipe(recipe);
            ingredientService.saveIngredient(ingredient);
        }

        recipe.setIngredientList(ingredientList);
        recipeService.saveRecipe(recipe);
        
        return "redirect:/index";
    }

}
