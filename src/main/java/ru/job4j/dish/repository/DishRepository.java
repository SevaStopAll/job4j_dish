package ru.job4j.dish.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dish.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {

    List<Dish> findAll();
}
