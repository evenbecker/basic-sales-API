package com.even.exercice.Controller;

import com.even.exercice.Dto.CreateSellerDto;
import com.even.exercice.Dto.DailyAvgDto;
import com.even.exercice.Entity.Seller;
import com.even.exercice.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seller createSeller(@RequestBody CreateSellerDto sellerDto){
        return sellerService.createSeller(sellerDto.getName());
    }

    @GetMapping
    public Collection<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/avg")
    public Collection<DailyAvgDto> getDailyAvg(@RequestParam long begin, @RequestParam long end){
        return sellerService.getDailyAvg(begin, end);
    }
}
