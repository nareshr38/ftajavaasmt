package com.fta.javaasmt.predicates;

public class Product {
    private String prodName;
    private ProductCategory prodCategory;
    private ProductGrade prodGrade;
    private double prodPrice;

    public Product(String prodName, double prodPrice) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdCategory(ProductCategory prodCategory) {
        this.prodCategory = prodCategory;
    }

    public void setProdGrade(ProductGrade prodGrade) {
        this.prodGrade = prodGrade;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Product(String prodName, ProductCategory prodCategory, ProductGrade prodGrade, double prodPrice) {
        this.prodName = prodName;
        this.prodCategory = prodCategory;
        this.prodGrade = prodGrade;
        this.prodPrice = prodPrice;
    }

    public String getProdName() {
        return prodName;
    }

    public ProductCategory getProdCategory() {
        return prodCategory;
    }

    public ProductGrade getProdGrade() {
        return prodGrade;
    }

    public double getProdPrice() {
        return prodPrice;
    }

}
