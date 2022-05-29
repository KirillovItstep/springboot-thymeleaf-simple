package org.itstep.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {

    @RequestMapping("/products")
    public String viewHomePage(Model model) {
        Product prod1 = new Product(1L, "SS-S9", "Sam Sung Galaxy S9", "samsung.jpg");
        Product prod2 = new Product(2L, "NK-5P", "Nokia 5.1 Plus", null);
        Product prod3 = new Product(3L, "IP-7", "iPhone 7", "iphone.jpg");

        List<Product> list = new ArrayList<>();
        list.add(prod1);
        list.add(prod2);
        list.add(prod3);
        model.addAttribute("products", list);
        return "products";
    }
}