package com.cursospring.domain.service;

import com.cursospring.domain.Product;
import com.cursospring.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Inyectar el productRepository
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity) {
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    //Para que pueda retornar el booleano, se puede hacer una validación con getAll donde
    //se haga la busqueda del producto, se elimina y retorna true, y si no esta incluido,
    //Va a retornar false
    public boolean delete(int productId) {
        /**
         *return productRepository.getProduct(productId).map(p -> {
         *             productRepository.delete(productId);
         *             return true;
         *         }).orElse(false);
         */
        if(getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }

    }

}
