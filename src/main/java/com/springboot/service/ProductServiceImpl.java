package com.springboot.service;

import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product product = productRepository.findById(id).get();

        if (product != null) {
            productRepository.delete(product);
            return "Product delete successfully";
        } else {
            return "Product not found to delete";
        }
    }
}
