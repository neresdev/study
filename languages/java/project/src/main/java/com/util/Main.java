package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.util.entities.Report;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) throws IOException {
        File input = new File("input.txt");
        createReport(input);
    }

    public static Report createReport(File input) throws IOException {
        LocalDate mostSalesDate = null;
        Integer actualMostSaleCount = 0;
        List<LocalDate> biggestSalesDates = new ArrayList<>();
        List<DateSales> dateSales = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Integer> mostSalesClients = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        String line;

        

        while ((line = br.readLine()) != null) {
            String[] splitStr = line.split(",");

            LocalDate saleDate = LocalDate.parse(splitStr[0], DateTimeFormatter.BASIC_ISO_DATE);
            
            Integer clientId = null;
            try{
                clientId = Integer.parseInt(splitStr[1]);
            }catch(Exception e){
                System.out.println("Invalid clientId in input file.");
                continue;
            }

            Integer saleCount = Integer.parseInt(splitStr[2]);
            Integer saleValue = Integer.parseInt(splitStr[3]);
            clients.add(new Client(clientId, saleCount, saleValue));

            if(saleCount > actualMostSaleCount){
                actualMostSaleCount = saleCount;
                mostSalesDate = saleDate;
            }
            dateSales.add(new DateSales(saleDate, saleValue));
            
        }

        
        Collections.sort(dateSales, (ds1, ds2) -> Integer.compare(ds2.getSalesQuantity(), ds1.getSalesQuantity()));
        Collections.sort(clients, (c1, c2) -> Integer.compare(c2.getSaleCount(), c1.getSaleCount()));

        for(int i = 0; i <= 2; i++) {
            if(!biggestSalesDates.contains(dateSales.get(i).getDate()) && mostSalesClients.size() <= 3){
                biggestSalesDates.add(dateSales.get(i).getDate());
            }
            
        }
        for(int i = 0; i <= 2; i++) {
            if(!mostSalesClients.contains(clients.get(i).getClientId()) && mostSalesClients.size() <= 3){
                mostSalesClients.add(clients.get(i).getClientId());
            }
            
        }

        br.close();

        return new Report(mostSalesDate, biggestSalesDates, mostSalesClients);
    }

    
}

class DateSales{
    private LocalDate date;
    
    private Integer salesQuantity;
    
    
    public DateSales(LocalDate date, Integer salesQuantity) {
        this.date = date;
        this.salesQuantity = salesQuantity;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Integer getSalesQuantity() {
        return salesQuantity;
    }
    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    
}

class Client {
    
    private Integer clientId;
    
    private Integer saleCount;
    
    private Integer saleValue;

    public Client(Integer clientId, Integer saleCount, Integer saleValue) {
        this.clientId = clientId;
        this.saleCount = saleCount;
        this.saleValue = saleValue;
    }
    
    public Integer getClientId() {
        return clientId;
    }
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    public Integer getSaleCount() {
        return saleCount;
    }
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
    public Integer getSaleValue() {
        return saleValue;
    }
    public void setSaleValue(Integer saleValue) {
        this.saleValue = saleValue;
    }

    
}