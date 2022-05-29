package org.itstep.request_response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReqResController {

    @RequestMapping("/index")
    public String getFlowers(Model model) {
        String[] colors = new String[] { "#FF0000", "#00FF00", "#0000FF"};
        model.addAttribute("colors", colors);
        return "request_response";
    }

    //Get color from browser
    @RequestMapping(value="/getcolor", method = RequestMethod.POST)
    public String getColor (@RequestBody MyColor color) { //String проходит, а объект - нет
        //System.out.println("ok");
        System.out.println(color);
        return "redirect:/index";
    }
}
