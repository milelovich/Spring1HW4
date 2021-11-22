package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository { // репозиторий - хранилище данных, просто их хранит и ничего не делает
    // обычное прилож состоит из 3-х слоев - это контроллер, его задача получить запрос и передать куда-то на обработку.
    // Далее идет слой сервисов - они выполняют основную бизнес-логику, обрабатывают данные, помечается аннотацией   @Service
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Water", 1),
                new Product(2L, "Cola", 1),
                new Product(3L, "Milk", 1),
                new Product(4L, "Vodka", 1)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id)); // удаляем из прод  того, чей айди равен искомому
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
