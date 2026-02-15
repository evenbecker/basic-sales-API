package com.even.exercice.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.*;
import java.util.Locale;

@Component
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    private int id;

    @NotNull
    private float value;

    @ManyToOne
    private Seller seller;

    @NotNull
    private long dateLong;

    @NotNull
    private LocalDate saleDate;

    public Sale() { }

    public Sale(int id, long date, float value) {
        setId(id);
        setDate(date);
        setValue(value);
        setDateLong(date);
    }

    public Sale(int id, long date, float value, Seller seller) {
        setId(id);
        setDate(date);
        setValue(value);
        setSeller(seller);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return saleDate;
    }

    public void setDate(long date) {
        this.saleDate = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
        setDateLong(date);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    private void setDateLong(long date) {
        this.dateLong = date;
    }

    public long getDateLong() {
        return dateLong;
    }
}
