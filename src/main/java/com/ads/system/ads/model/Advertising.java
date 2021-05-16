package com.ads.system.ads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class Advertising {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String client;
    private LocalDate startDate;
    private LocalDate endDate;
    private double  investmentPerDay;



    public Advertising(String name, String client, LocalDate startDate, LocalDate endDate, double investmentPerDay) {
        this.name = name;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.investmentPerDay = investmentPerDay;
    }

    public Advertising() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertising that = (Advertising) o;
        return id == that.id && Double.compare(that.investmentPerDay, investmentPerDay) == 0 && Objects.equals(name, that.name) && Objects.equals(client, that.client) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, client, startDate, endDate, investmentPerDay);
    }

    /**
     * Receive the number of views and calculate the number of shares
     *
     * @param views
     * @return number of shares
     */
    public static double shareCalculate(double views) {
        // For every 100 people who view, 12 click
        double click =  views * 0.12;
        // for every 20 people who click, 3 people share on social networks
        return click * 0.15;
    }


    public double totalInvested(int daysFilter) {
        Period diference = Period.between(this.getStartDate(), this.getEndDate());
        int days = Math.abs(diference.getDays());
        days++;
        if(daysFilter > 0 && daysFilter < days){
            return this.getInvestmentPerDay()*daysFilter;
        }
        return days * this.getInvestmentPerDay();
    }

    public double maxViews(int days) {
        double amountInvested = totalInvested(days)*30;

        double countViews = amountInvested;


        // the inicial reach for first share
        double callShare = amountInvested;
        double shareAtual = amountInvested;
        do {
            shareAtual = shareCalculate(callShare);
            // accumulates the reach of sharing
            countViews = countViews + shareAtual*40;

            callShare = shareAtual*40;
        } while(shareAtual >= 1);
            return countViews;
    }

    public double maxClicks(int days) {

        return maxViews(days)*0.12;
    }

    public double maxShare(int days) {
        double amountInvested = totalInvested(days)*30;
        double countShare = 0;


        // the inicial reach for first share
        double visualization = amountInvested;
        double shareActual = 0;
        do {
            shareActual = shareCalculate(visualization);

            // accumulates the reach of sharing
            countShare = countShare + shareActual;
            visualization = shareActual*40;
        } while(shareActual >= 1);

        return countShare;
    }
}
