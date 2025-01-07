// filepath: /Users/macbookair/Documents/workspace/tienda-ropa-123/src/main/java/net/enjoy/springboot/registrationlogin/controller/PolosController.java
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
public class PolosController {

    @Autowired
    private ProductService productService;

    @GetMapping("/polos")
    public String showPolosPage(Model model) {
        List<String> brands = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("polo"))
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("brands", brands);
        return "polos";
    }

    @PostMapping("/polos")
    public String checkPolosAvailability(@RequestParam String brand,
                                         @RequestParam String size,
                                         Model model) {
        List<Product> polos = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("polo") &&
                        p.getBrand().equalsIgnoreCase(brand) &&
                        p.getSize().equalsIgnoreCase(size))
                .collect(Collectors.toList());

        if (!polos.isEmpty()) {
            model.addAttribute("availability", "SI HAY STOCK");
            model.addAttribute("availabilityColor", "green");
            model.addAttribute("brand", brand);
            model.addAttribute("size", size);
            model.addAttribute("price", polos.get(0).getPrice());
        } else {
            model.addAttribute("availability", "NO DISPONIBLE");
            model.addAttribute("availabilityColor", "red");
        }

        List<String> brands = productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("polo"))
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("brands", brands);

        return "polos";
    }

    @GetMapping("/polos/sizes")
    @ResponseBody
    public List<String> getSizesByBrand(@RequestParam String brand) {
        return productService.findAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase("polo") &&
                        p.getBrand().equalsIgnoreCase(brand))
                .map(Product::getSize)
                .distinct()
                .collect(Collectors.toList());
    }
}