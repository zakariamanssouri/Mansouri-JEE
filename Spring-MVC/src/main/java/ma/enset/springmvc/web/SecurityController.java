package ma.enset.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class SecurityController{

    @GetMapping(path = "/403")
    public String NotAuthorized() {
        return "403";
    }

}
