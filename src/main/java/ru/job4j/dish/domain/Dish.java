package ru.job4j.dish.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Dish {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter
        private int id;
        @Getter
        @Setter
        private String name;
        @Getter
        @Setter
        private String description;
}
