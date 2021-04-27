package cookingguide.controllers;

import cookingguide.models.User;
import cookingguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/register", "/"})
    public String showRegisterPage(){

        return "registration";
    }

    @RequestMapping("/registerNew")
    public String registerNewUser(@RequestParam("fullName") String fullName,
                                  @RequestParam("location") String location,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password){

        User user = new User(fullName,location,email,passwordEncoder.encode(password));
        userService.saveUser(user);
        return"redirect:/login";
    }


}
