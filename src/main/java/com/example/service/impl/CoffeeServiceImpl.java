package com.example.service.impl;

import com.example.entity.Coffee;
import com.example.exception.CoffeeNotFoundException;
import com.example.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private  final List<Coffee> coffeeList = new ArrayList<>();
    public CoffeeServiceImpl() {
        IO.println("---------------cons start------------------");
        coffeeList.add(
                new Coffee(1, "Cappuccino", "Hot Coffee", 450, 25)
        );
        coffeeList.add(
                new Coffee(2, "Latte", "Hot Coffee", 280, 20)
        );
        coffeeList.add(
                new Coffee(3, "Espresso", "Hot Coffee", 220, 30)
        );
        coffeeList.add(
                new Coffee(4, "Cold Coffee", "Cold Coffee", 160, 15)
        );
        coffeeList.add(
                new Coffee(5, "best", "Cold Coffee", 120, 15)
        );
        coffeeList.add(
                new Coffee(6, "medium", "Hot Coffee", 180, 15)
        );
        IO.println("---------------cons end and coffee list is ready------------------");
    }


    @Override
    public List<Coffee> getAllCoffees() {
        return coffeeList;
    }

    @Override
    public Coffee getCoffeeById(int id) {
        for (Coffee coffee : coffeeList) {
            if (coffee.getId() == id) {
                return coffee;
            }
        }
        throw new CoffeeNotFoundException("Coffee with ID " + id + " not found");
    }


    @Override
    public Coffee addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
        return  coffee;

    }

    @Override
    public Coffee updateCoffee(int id, Coffee coffee) {
        Coffee existingCoffee = getCoffeeById(id);
        existingCoffee.setName(coffee.getName());
        existingCoffee.setCategory(coffee.getCategory());
        existingCoffee.setPrice(coffee.getPrice());
        existingCoffee.setStock(coffee.getStock());
        return existingCoffee;
    }

    @Override
    public void deleteCoffee(int id) {
        Coffee coffee = getCoffeeById(id);
        coffeeList.remove(coffee);

    }

    @Override
    public List<Coffee> searchByName(String name) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            if (coffee.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {
                result.add(coffee);
            }
        }
        return result;
    }

    @Override
    public List<Coffee> getByCategory(String category) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            if (coffee.getCategory()
                    .equalsIgnoreCase(category)) {
                result.add(coffee);
            }
        }
        return result;
    }

    @Override
    public Coffee updateStock(int id, int stock) {
        Coffee coffee = getCoffeeById(id);
        coffee.setStock(stock);
        return coffee;
    }

    @Override
    public List<Coffee> getByARange(double startPrice, double endPrice) {

        return coffeeList.stream()
                .filter(c-> c.getPrice()>=startPrice & c.getPrice()<=endPrice).toList();

    }
}
