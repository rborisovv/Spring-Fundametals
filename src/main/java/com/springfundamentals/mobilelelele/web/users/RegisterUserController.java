package com.springfundamentals.mobilelelele.web.users;

import com.springfundamentals.mobilelelele.bindingModel.UserRegisterDto;
import com.springfundamentals.mobilelelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegisterUserController {
    private final UserService userService;

    public RegisterUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model, UserRegisterDto userRegisterDto) {
        model.addAttribute("registerDto", userRegisterDto);
        model.addAttribute("userSession");
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegisterDto userRegisterDto) {
        this.userService.registerUser(userRegisterDto);
        return "redirect:/";
    }
}