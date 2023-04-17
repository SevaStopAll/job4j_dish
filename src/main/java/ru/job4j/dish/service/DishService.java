package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.domain.Dish;
import ru.job4j.dish.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishService {
    private final DishRepository dishes;

    public Optional<Dish> add(Dish dish) {
        return Optional.of(dishes.save(dish));
    }

    public boolean update(Dish dish) {
        if (dishes.findById(dish.getId()).isPresent()) {
        dishes.save(dish);
        return true;
        }
        return false;
    }

    public boolean delete(Dish dish) {
        if (dishes.findById(dish.getId()).isPresent()) {
            dishes.delete(dish);
            return true;
        }
        return false;
    }

    public List<Dish> findAll() {
        return dishes.findAll();
    }

    public Optional<Dish> findById(int id) {
        return Optional.of(dishes.findById(id).get());
    }
}
