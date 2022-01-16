package lv.unversityManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String login() {
        return ("login/login.html");
    }

    @GetMapping("/")
    public String dashboard() {
        return ("dashboard/dashboard.html");
    }

}
