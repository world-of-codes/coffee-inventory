package com.example.service;

import com.example.entity.Coffee;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffees();
    Coffee getCoffeeById(int id);
    Coffee addCoffee(Coffee coffee);
    Coffee updateCoffee(int id, Coffee coffee);
    void deleteCoffee(int id);
    List<Coffee> searchByName(String name);
    List<Coffee> getByCategory(String category);
    Coffee updateStock(int id, int stock);

    //add custom method
    List<Coffee> getByARange(double startPrice,double endPrice);
}
