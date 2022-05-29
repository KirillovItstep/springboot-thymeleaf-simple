package org.itstep.flowers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FlowerController {

    @RequestMapping("/flowers")
    public String getFlowers(Model model) {
        String[] flowers = new String[] { "Rose", "Lily", "Tulip", "Carnation", "Hyacinth" };
        model.addAttribute("flowers", flowers);
        return "flowers";
    }
}
