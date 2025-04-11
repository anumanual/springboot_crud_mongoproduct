package com.product.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.Product;
import com.product.product.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product)
    { 
        return productRepository.save(product);
    }

    public List<Product> getAllProducts()
    { 
        return productRepository.findAll();
    }

    public Optional<Product> getproductById(String id)
    { 
        return productRepository.findById(id);
    }

    public Product updateProduct(String id,Product updatedProduct)
    { 
        if(productRepository.existsById(id))
        { 
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public String deleteProduct(String id)
    { 
        productRepository.deleteById(id);
        return "Product with ID: "+id+" deleted";
    }
}
