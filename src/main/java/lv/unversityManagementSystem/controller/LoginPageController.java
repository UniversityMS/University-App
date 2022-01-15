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

//    @GetMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//
//            if (statusCode == HttpStatus.FORBIDDEN.value()) {
//                return "error/error-403";
//            }
//        }
//        return "error/error";
//    }
}
