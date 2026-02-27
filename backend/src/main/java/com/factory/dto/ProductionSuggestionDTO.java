package com.factory.dto;

public class ProductionSuggestionDTO {

    public String productName;

    public int quantity;

    public Double totalValue;

    public ProductionSuggestionDTO(String productName, int quantity, Double totalValue) {
        this.productName = productName;
        this.quantity = quantity;
        this.totalValue = totalValue;
    }
}