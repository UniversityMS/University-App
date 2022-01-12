package lv.unversityManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPageController {

    @GetMapping("/")
    public String loginHomepage(){
        return ("greeting.html");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/lecturer")
    public String lecturer(){
        return ("<h1>Welcome Lecturer</h1>");
    }

    @GetMapping("/student")
    public String student(){
        return ("<h1>Welcome Student</h1>");
    }




}
