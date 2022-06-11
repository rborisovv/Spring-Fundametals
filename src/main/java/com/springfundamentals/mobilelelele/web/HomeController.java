package com.springfundamentals.mobilelelele.web;

import com.springfundamentals.mobilelelele.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserSession userSession;

    public HomeController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("userSession", userSession);
        return "index";
    }
}