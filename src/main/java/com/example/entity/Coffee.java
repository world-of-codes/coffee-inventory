package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coffee {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;

}
