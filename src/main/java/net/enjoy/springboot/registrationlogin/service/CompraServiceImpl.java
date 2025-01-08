package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.entity.Compra;
import net.enjoy.springboot.registrationlogin.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public void saveCompra(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public Compra getLastCompra() {
        return compraRepository.findTopByOrderByIdDesc();
    }
}