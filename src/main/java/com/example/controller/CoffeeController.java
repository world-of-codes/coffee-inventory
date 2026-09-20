package com.example.controller;

import com.example.entity.Coffee;
import com.example.service.CoffeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/coffees")
@AllArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        return ResponseEntity.ok(coffeeService.getAllCoffees());//200 OK
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable int id)
    {
        return ResponseEntity.ok(coffeeService.getCoffeeById(id));
    }

    // ADD COFFEE
    @PostMapping
    public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {
        Coffee savedCoffee =coffeeService.addCoffee(coffee);
        return new ResponseEntity<>(savedCoffee,HttpStatus.CREATED);
    }

    // UPDATE COFFEE
    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable int id,@RequestBody Coffee coffee) {
        return ResponseEntity.ok(coffeeService.updateCoffee(id, coffee));
    }


    // DELETE COFFEE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoffee(@PathVariable int id) {
        coffeeService.deleteCoffee(id);
        return ResponseEntity.ok("Coffee deleted successfully");
    }


    // SEARCH
    @GetMapping("/search")
    public ResponseEntity<List<Coffee>> searchCoffee(@RequestParam String name) {
        return ResponseEntity.ok(coffeeService.searchByName(name)
        );
    }
    // CATEGORY
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Coffee>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(coffeeService.getByCategory(category)
        );
    }
    // UPDATE STOCK
    @PatchMapping("/{id}/stock")
    public ResponseEntity<Coffee> updateStock(@PathVariable int id,@RequestParam int stock) {
        return ResponseEntity.ok(coffeeService.updateStock(id, stock));
    }

        @GetMapping("/custom")
        public ResponseEntity<List<Coffee>> getByRange(@RequestParam double start,@RequestParam double end) {
            return ResponseEntity.ok(coffeeService.getByARange(start,end));

    }


    //http://localhost:6666/api/coffees/student?name=sutavro&address=kolkata
    @GetMapping("/student")
    public String take(@RequestParam String name,@RequestParam String address)
    {
        return name.toUpperCase();
    }

    //http://localhost:6666/api/coffees/candidate/amitava
    @GetMapping("/candidate/{name}")
    public String take2(@PathVariable String name)
    {
        return name.toUpperCase();
    }
}













