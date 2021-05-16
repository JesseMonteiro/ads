package com.ads.system.ads.controller.form;

import com.ads.system.ads.model.Advertising;

import java.time.LocalDate;
import java.util.Date;

public class AdvertisingForm {
    private String name;
    private String client;
    private LocalDate startDate;
    private LocalDate endDate;
    private double  investmentPerDay;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getInvestmentPerDay() {
        return investmentPerDay;
    }

    public void setInvestmentPerDay(double investmentPerDay) {
        this.investmentPerDay = investmentPerDay;
    }

    public Advertising converter() {
        return new Advertising(name, client, startDate, endDate, investmentPerDay);
    }
}
