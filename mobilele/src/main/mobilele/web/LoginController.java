package softuni.mobilele.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.mobilele.mobilele.model.service.UserLoginServiceModel;
import softuni.mobilele.mobilele.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String showLogin() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginServiceModel model) {
        if (userService.authenticate(model.getUsername(), model.getPassword())) {
            userService.loginUser(model.getUsername());
            return "redirect:/";
        } else {
            return "redirect:/users/login";
        }
    }


}
