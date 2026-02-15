package com.even.exercice.Dao;

import com.even.exercice.Dto.DailyAvgDto;
import com.even.exercice.Entity.Sale;
import com.even.exercice.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SaleDao {

    @Autowired
    private SaleRepository saleRepository;


    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public boolean checkId(int id) {
        Iterable<Sale> saleList = saleRepository.findAll();

        for(Sale sale : saleList) {
            if(sale.getId() == id) {
                return true;
            }
        }

        return false;
    }

    public Collection<Sale> getAllSales() {
        ArrayList<Sale> saleList = new ArrayList();
        Iterable<Sale> sales = saleRepository.findAll();

        for(Sale sale : sales) {
            saleList.add(sale);
        }

        return saleList;
    }



}
