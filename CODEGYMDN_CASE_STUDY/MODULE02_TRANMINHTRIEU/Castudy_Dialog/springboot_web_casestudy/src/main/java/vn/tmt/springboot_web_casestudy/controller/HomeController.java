package vn.tmt.springboot_web_casestudy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/admin")
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("homePage/home");
        return modelAndView;
    }
}
