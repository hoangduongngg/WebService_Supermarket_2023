package microservice.controller;

import microservice.model.Product;
import microservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductRestController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductRepository supplierRepository){
        this.productRepository = supplierRepository;
    }

    @GetMapping
    public List<Product> getByNameContains(@RequestParam(name = "nameContains", required = false) String keyword){
        return keyword == null ? productRepository.findAll() : productRepository.findByNameContains(keyword);
    }
    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public int importProducts(@RequestBody List<Product> products){
        for (Product product:products){
            Product savedProduct = productRepository.findById(product.getId()).get();
            savedProduct.setQuantity(savedProduct.getQuantity() + product.getQuantity());
            productRepository.save(savedProduct);
        }
        return products.size();
    }
}
