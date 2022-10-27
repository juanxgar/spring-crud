package com.cursospring.domain.repository;

import com.cursospring.domain.Product;

import java.util.List;
import java.util.Optional;

//Esta interfaz se define para usarla en la conversion
public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<Product> getProduct(int productId);

    Product save(Product product);

    void delete(int productId);
}
