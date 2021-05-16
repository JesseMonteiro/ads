package com.ads.system.ads.controller.dto;

import com.ads.system.ads.model.Advertising;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AdvertisingDto {

    private long id;
    private String name;
    private String client;
    private LocalDate startDate;
    private LocalDate endDate;
    private double  investmentPerDay;

    public AdvertisingDto(Advertising advertising){
        this.id = advertising.getId();
        this.name = advertising.getName();
        this.client = advertising.getClient();
        this.startDate = advertising.getStartDate();
        this.endDate = advertising.getEndDate();
        this.investmentPerDay = advertising.getInvestmentPerDay();

    }

    public static List<AdvertisingDto> converter(List<Advertising> advertisings) {
        return advertisings.stream().map(AdvertisingDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClient() {
        return client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getInvestmentPerDay() {
        return investmentPerDay;
    }



}
