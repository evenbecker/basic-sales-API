package com.even.exercice.Controller;

import com.even.exercice.Dto.CreateSaleDto;
import com.even.exercice.Entity.Sale;
import com.even.exercice.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale createSale(@RequestBody CreateSaleDto saleDto) {
        return saleService.createSale(saleDto.getValue(), saleDto.getSellerId());
    }

    @GetMapping
    public Collection<Sale> getAllSales() {
        return saleService.getAllSales();
    }
}
