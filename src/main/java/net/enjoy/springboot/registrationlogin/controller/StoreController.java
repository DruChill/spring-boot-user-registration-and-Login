package net.enjoy.springboot.registrationlogin.controller;

import net.enjoy.springboot.registrationlogin.entity.Product;
import net.enjoy.springboot.registrationlogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {

    @Autowired
    private ProductService productService;

    @GetMapping("/tienda")
    public String showStorePage() {
        return "store";
    }

    @PostMapping("/tienda")
    public String checkProductAvailability(@RequestParam String name,
                                           @RequestParam String brand,
                                           @RequestParam String size,
                                           Model model) {
        Product product = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name) &&
                        p.getBrand().equalsIgnoreCase(brand) &&
                        p.getSize().equalsIgnoreCase(size))
                .findFirst()
                .orElse(null);

        if (product != null) {
            model.addAttribute("availability", "SI HAY STOCK");
            model.addAttribute("availabilityColor", "green");
            model.addAttribute("name", product.getName());
            model.addAttribute("brand", product.getBrand());
            model.addAttribute("size", product.getSize());
            model.addAttribute("price", product.getPrice());
        } else {
            model.addAttribute("availability", "NO DISPONIBLE");
            model.addAttribute("availabilityColor", "red");
        }

        return "store";
    }
}