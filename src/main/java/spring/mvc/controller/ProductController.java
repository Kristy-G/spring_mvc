package spring.mvc.controller;

import dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "product_list";
    }

    @GetMapping("/info/{id}")
    public String getStudentInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/add")
    public String getProductAddFrom() {
        return "product_form";
    }

    @PostMapping("/add")
    public String saveStudent(@RequestParam Integer id,
                              @RequestParam String title,
                              @RequestParam Float cost) {
        productService.save(new Product(id, title, cost));
        return "redirect:all";
    }
}
