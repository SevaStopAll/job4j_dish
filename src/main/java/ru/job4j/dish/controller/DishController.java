package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.dish.domain.Dish;
import ru.job4j.dish.service.DishService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishes;

    @GetMapping("/")
    public List<Dish> findAll() {
        return dishes.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var dish = this.dishes.findById(id);
        return new ResponseEntity<>(
                dish.orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "This dish is not found. Please, check id one more time."
                )),
                HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Optional<Dish>> create(@RequestBody Dish dish) {
        var name = dish.getName();
        var description = dish.getDescription();
        if (name == null || description == null) {
            throw new NullPointerException("This dish is not found. Please, check id one more time ");
        }
        return new ResponseEntity<>(
                this.dishes.add(dish),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Dish dish) {
        var name = dish.getName();
        var description = dish.getDescription();
        if (name == null || description == null) {
            throw new NullPointerException("Login and password mustn't be empty");
        }
        if (dishes.update(dish)) {
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
