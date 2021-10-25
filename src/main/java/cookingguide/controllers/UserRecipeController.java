package cookingguide.controllers;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.models.UnitOfMeasurements;
import cookingguide.models.User;
import cookingguide.services.IngredientService;
import cookingguide.services.RecipeService;
import cookingguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/add-new-recipe")
    public String addNewRecipe(@RequestParam("recipeName") String recipeName,
                               @RequestParam("recipePortion") int recipePortion,
                               @RequestParam("description") String description,
                               @RequestParam("ingrTitles") String ingrTitles,
                               @RequestParam("ingrAmounts") String ingrAmounts,
                               @RequestParam("ingrUnits") String ingrUnits,
                               @RequestParam("category") String category
    ) {
        Recipe recipe = new Recipe(recipeName, recipePortion,0, description,"",category);
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

        Authentication authenticationDetails = SecurityContextHolder.getContext().getAuthentication();
        String username = authenticationDetails.getPrincipal().toString();
        User user = userService.loadUserByUsername(username);
        recipe.setUser(user);
        recipe.setIngredientList(ingredientList);
        recipeService.saveRecipe(recipe);
        
        return "redirect:/index";
    }

    @RequestMapping("/getRecipesByUserId/{id}")
    public String getRecipesByUserId(@PathVariable int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return"user-page";
    }

    @RequestMapping("/getCurrentUserRecipes")
    public String getCurrentUserRecipes(Model model){
        String currentUserUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.loadUserByUsername(currentUserUsername);
        List<Recipe> allRecipesForCurrentUser = recipeService.getRecipeByUsername(currentUserUsername);
        currentUser.setRecipeCount(allRecipesForCurrentUser.size());
        model.addAttribute("user" , currentUser);
        return "user-page";

    }



}
