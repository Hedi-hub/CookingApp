package cookingguide.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegistrationController {

    @RequestMapping(value = {"/register", "/"})
    public String showRegisterPage(){
        return "/registration";
    }


}
