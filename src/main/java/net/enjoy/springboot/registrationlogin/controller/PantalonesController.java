// filepath: /Users/macbookair/Documents/workspace/tienda-ropa-123/src/main/java/net/enjoy/springboot/registrationlogin/controller/PantalonesController.java
package net.enjoy.springboot.registrationlogin.controller;

import net.enjoy.springboot.registrationlogin.entity.Product;
import net.enjoy.springboot.registrationlogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PantalonesController {

    @Autowired
    private ProductService productService;

    @GetMapping("/pantalones")
    public String showPantalonesPage(Model model) {
        List<String> brands = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("pantalon"))
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("brands", brands);
        return "pantalones";
    }

    @PostMapping("/pantalones")
    public String checkPantalonesAvailability(@RequestParam String brand,
                                              @RequestParam String size,
                                              Model model) {
        List<Product> pantalones = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("pantalon") &&
                        p.getBrand().equalsIgnoreCase(brand) &&
                        p.getSize().equalsIgnoreCase(size))
                .collect(Collectors.toList());

        if (!pantalones.isEmpty()) {
            model.addAttribute("availability", "SI HAY STOCK");
            model.addAttribute("availabilityColor", "green");
            model.addAttribute("brand", brand);
            model.addAttribute("size", size);
            model.addAttribute("price", pantalones.get(0).getPrice());
        } else {
            model.addAttribute("availability", "NO DISPONIBLE");
            model.addAttribute("availabilityColor", "red");
        }

        List<String> brands = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("pantalon"))
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("brands", brands);

        return "pantalones";
    }

    @GetMapping("/pantalones/sizes")
    @ResponseBody
    public List<String> getSizesByBrand(@RequestParam String brand) {
        return productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("pantalon") &&
                        p.getBrand().equalsIgnoreCase(brand))
                .map(Product::getSize)
                .distinct()
                .collect(Collectors.toList());
    }
}