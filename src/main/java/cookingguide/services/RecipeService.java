package cookingguide.services;

import cookingguide.models.Recipe;
import cookingguide.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public void saveRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }
    public void removeRecipe(Recipe recipe){
        recipeRepository.delete(recipe);
    }
    public List<Recipe> getAllRecipes(){
        return (List<Recipe>) recipeRepository.findAll();
    }

    public Recipe getRecipeById(Integer id){
        return recipeRepository.findById(id).get();
    }

    public List<Recipe> getRecipeByUsername(String username){
        List<Recipe> allRecipes = getAllRecipes();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes){
            if (recipe.getUser().getUsername().equals(username)){
                filteredRecipes.add(recipe);
            }
        }
        return filteredRecipes;

    }

    public int getRecipeCountByUsername(String username){
        return getRecipeByUsername(username).size();
    }



}
