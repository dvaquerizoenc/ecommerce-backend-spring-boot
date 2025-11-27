package com.ecommerce.api.service;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.model.Product;
import com.ecommerce.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        product.setStock(productDTO.stock());

        Product savedProduct = productRepository.save(product);

        return new ProductDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getStock()
        );
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(product -> new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        )).toList();
    }

    public ProductDTO getProductById(long id) {
        Product product = productRepository.findById(id).get();

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }
}
