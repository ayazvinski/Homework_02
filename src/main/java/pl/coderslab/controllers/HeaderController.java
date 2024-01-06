package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String getUserAgent(Model model, @RequestHeader("user-agent") String userAgent){
        model.addAttribute("userAgent", userAgent);
        return "userAgent";
    }

}
