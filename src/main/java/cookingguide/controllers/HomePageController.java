package cookingguide.controllers;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HomePageController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value={ "/","/index", "/home"})
    public String showHomePage(Model model){
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        List<Recipe> topThreeRecipes = new ArrayList<>();
        //these to see 3 recipes on the screen
        topThreeRecipes.add(allRecipes.get(0));
        topThreeRecipes.add(allRecipes.get(1));
        topThreeRecipes.add(allRecipes.get(2));
        model.addAttribute("recipes",topThreeRecipes );
        model.addAttribute("category","All Recipes");

        return "index";
    }

    @RequestMapping("/showNewRecipeForm")
    public String showNewRecipePage(){

        return"add-new-recipe";
    }

    @RequestMapping("/showRecipesForCategory/{category}")
    public String searchByCategory(@PathVariable("category") String category, Model model){

        List<Recipe> recipes = recipeService.getAllRecipes();

        List<Recipe> recipesByCategory = new ArrayList<>();
        for (Recipe recipe : recipes){
            if (recipe.getCategory().equalsIgnoreCase(category)){
                recipesByCategory.add(recipe);
            }
        }
        model.addAttribute("recipes",recipesByCategory);
        model.addAttribute("category", category);

        return "index";
    }

    @RequestMapping("/searchForRecipe")
    public String searchForRecipe(@RequestParam("searchTerm") String searchKeyword, Model model){
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        List<Recipe> selectedRecipes = new ArrayList<>();
        if (searchKeyword.isEmpty()){
            model.addAttribute("recipes", allRecipes);
            return "index";
        }
        for (Recipe recipe: allRecipes){
            if (recipe.getName().toLowerCase().contains(searchKeyword.toLowerCase())){
                selectedRecipes.add(recipe);
            }
            List<Ingredient> allRecipeIngredients =recipe.getIngredientList();
            for (Ingredient ingredient: allRecipeIngredients){
                if(ingredient.getIngredientName().toLowerCase().contains(searchKeyword.toLowerCase())){
                    selectedRecipes.add(recipe);
                }
            }
        }
        model.addAttribute("recipes", selectedRecipes);

        return "index";
    }
}
