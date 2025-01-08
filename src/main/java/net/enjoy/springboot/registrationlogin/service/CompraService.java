package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.entity.Compra;

public interface CompraService {
    void saveCompra(Compra compra);
    Compra getLastCompra();
}