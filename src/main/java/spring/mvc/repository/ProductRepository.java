package spring.mvc.repository;

import dto.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<dto.Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Product_1", 500));
        productList.add(new Product(2, "Product_2", 1000));
        productList.add(new Product(3, "Product_3", 700));
        productList.add(new Product(4, "Product_4", 850));
        productList.add(new Product(5, "Product_5", 1200));
    }

    public List<Product> getAll() {
        return new ArrayList<>(productList);
    }

    public Product findById(int id) {
        return productList.stream().filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Product student) {
        productList.add(student);
    }
}
