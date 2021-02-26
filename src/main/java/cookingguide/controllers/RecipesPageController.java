package cookingguide.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipesPageController {

    @RequestMapping("")
    public String showAsianRecipes(){
        return "/asian-love-recipes";
    }



}
