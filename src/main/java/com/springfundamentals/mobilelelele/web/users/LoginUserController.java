package com.springfundamentals.mobilelelele.web.users;

import com.springfundamentals.mobilelelele.bindingModel.UserLoginDto;
import com.springfundamentals.mobilelelele.service.UserService;
import com.springfundamentals.mobilelelele.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class LoginUserController {
    private final UserService userService;
    private final UserSession userSession;

    public LoginUserController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @ModelAttribute("userModel")
    public UserLoginDto initUserModel() {
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userSession", userSession);
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid UserLoginDto userModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/login";
        }

        this.userService.loginUser(userModel);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userSession.setLoggedIn(false);
        userSession.setUsername(null);
        return "redirect:/";
    }
}