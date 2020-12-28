package cookingguide.initialData;

import cookingguide.models.Recipe;
import cookingguide.repositories.RecipeRepository;
import cookingguide.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class InitialData {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeService recipeService;

    //add the @PostConstruct
    @PostConstruct
    public void initializedInfo(){
        Recipe recipe1 = new Recipe()

    }

}
