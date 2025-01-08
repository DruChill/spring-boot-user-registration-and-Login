package net.enjoy.springboot.registrationlogin.controller;

import net.enjoy.springboot.registrationlogin.entity.Compra;
import net.enjoy.springboot.registrationlogin.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping("/comprar")
    public String realizarCompra(@RequestParam String customerName,
                                 @RequestParam String customerEmail,
                                 @RequestParam String productName,
                                 @RequestParam String productBrand,
                                 @RequestParam String productSize,
                                 @RequestParam Double productPrice,
                                 Model model) {
        Compra compra = new Compra();
        compra.setCustomerName(customerName);
        compra.setCustomerEmail(customerEmail);
        compra.setProductName(productName);
        compra.setProductBrand(productBrand);
        compra.setProductSize(productSize);
        compra.setProductPrice(productPrice);

        compraService.saveCompra(compra);

        model.addAttribute("compra", compra);
        return "redirect:/pagoExitoso";
    }

    @GetMapping("/pagoExitoso")
    public String mostrarPagoExitoso(Model model) {
        Compra compra = compraService.getLastCompra();
        model.addAttribute("compra", compra);
        return "pago_exitoso";
    }
}