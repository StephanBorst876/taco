package tacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author FeniksBV
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String Home() {
        return "home";
    }
}
