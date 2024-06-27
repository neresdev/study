package com.util.entities;

import java.time.LocalDate;
import java.util.List;

public class Report {
    private LocalDate mostSalesDate;
    private List<LocalDate> biggestSalesDates;
    private List<Integer> mostSalesClients;

    public Report(LocalDate mostSalesDate, List<LocalDate> biggestSalesDates, List<Integer> mostSalesClients) {
        this.mostSalesDate = mostSalesDate;
        this.biggestSalesDates = biggestSalesDates;
        this.mostSalesClients = mostSalesClients;
    }
}
