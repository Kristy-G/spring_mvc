package spring.mvc.service;

import org.springframework.stereotype.Service;
import spring.mvc.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(dto.Product student) {
        productRepository.save(student);
    }

    public dto.Product findById(int id) {
        return productRepository.findById(id);
    }

    public List<dto.Product> getAll() {
        return productRepository.getAll();
    }
}
