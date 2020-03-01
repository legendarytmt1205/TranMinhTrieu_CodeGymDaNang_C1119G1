package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary{
    @GetMapping("/dictionary")
    public String getDictionary(){
        return "dictionary";
    }
    @PostMapping("/dictionary")
    public ModelAndView findWord(@RequestParam(name = "key") String word){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("Goodbye", "Tạm biệt");
        dictionary.put("Page", "Trang");
        dictionary.put("computer", "Máy tính");
        String vneseWord= dictionary.get(word);

        ModelAndView modelAndView = new ModelAndView("dictionary","word",word);
        if(vneseWord==null){
            modelAndView.addObject("result","Not Found");
        }else {
            modelAndView.addObject("result",vneseWord);
        }
        return modelAndView;
    }
}