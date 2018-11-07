package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @GetMapping("/concerts")
    public String concerts() {
        return "concerts";
    }

    @GetMapping("/festival")
    public String festival() {
        return "festival";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }

    @GetMapping("/parties")
    public String parties() {
        return "parties";
    }

    @GetMapping("/sports")
    public String sports() {
        return "sports";
    }

    @GetMapping("/theater")
    public String theater() {
        return "theater";
    }

    @GetMapping("/upcoming")
    public String upcoming() {
        return "upcoming";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signin(){ return "signin"; }
}
