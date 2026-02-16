package com.even.exercice.Controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.even.exercice.Dto.CreateSaleDto;
import com.even.exercice.Entity.Sale;
import com.even.exercice.Entity.Seller;
import com.even.exercice.Service.SaleService;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@WebMvcTest(SaleController.class)
public class SaleControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private SaleService saleService;

    @Test
    public void getAllSales() throws Exception {

        Sale sale = new Sale(153468, 1553228667949L, 50.50f, new Seller(123456, "Teste"));
        List<Sale> saleList = Collections.singletonList(sale);

        System.out.println(new Gson().toJson(saleList));

        given(saleService.getAllSales()).willReturn(saleList);
        mvc.perform(get("/sales"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("[{'id':153468,'value':50.5,'seller':{'sellerId':123456,'sellerName':'Teste'},'dateLong':1553228667949,'date':'2019-03-22'}]"));

    }

    @Test
    public void createSale() throws Exception {

        CreateSaleDto dto = new CreateSaleDto(50.5f, 123456);
        Sale sale = new Sale(153468, 1553228667949L, 50.50f, new Seller(123456, "Teste"));


        given(saleService.createSale(sale.getValue(), sale.getSeller().getSellerId())).willReturn(sale);
        mvc.perform(post("/sales")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id':153468,'value':50.5,'seller':{'sellerId':123456,'sellerName':'Teste'},'dateLong':1553228667949,'date':'2019-03-22'}"));
    }

    //400 - Bad Request - Type Mismatch
    @Test
    public void createSaleMismatch() throws Exception {

        mvc.perform(post("/sales")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{'value':'50.5','sellerId':'123456'}"))
                .andExpect(status().isBadRequest());
    }

}
