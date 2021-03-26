package cookingguide.controllers;

import cookingguide.models.Recipe;
import cookingguide.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/add-new-recipe")
    public String addNewRecipe(@RequestParam("recipeName") String recipeName,
                               @RequestParam("recipePortion") int recipePortion,
                               @RequestParam("description") String description,
                               @RequestParam("ingrTitles") String ingrTitles,
                               @RequestParam("ingrAmounts") String ingrAmounts,
                               @RequestParam("ingrUnits") String ingrUnits) {
        Recipe recipe = new Recipe(recipeName, recipePortion,0, description,"");
        String [] titles= ingrTitles.split(",");
        String [] units= ingrUnits.split(",");
        String [] amounts= ingrAmounts.split(",");
        
        return "redirect:/index";
    }

}
