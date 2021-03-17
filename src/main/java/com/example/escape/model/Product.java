package com.example.escape.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private  int pdNo;
    private  String pdName;
    private  String pdId;
    private String pdetc;

    public Product(int pdNo, String pdName, String pdId, String pdetc) {
        this.pdNo = pdNo;
        this.pdName = pdName;
        this.pdId = pdId;
        this.pdetc = pdetc;
    }
}
