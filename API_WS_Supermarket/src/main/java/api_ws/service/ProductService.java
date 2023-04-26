package api_ws.service;

import api_ws.model.entity.Product;
import api_ws.repository.ProductReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductReopsitory productRepository;
    public List<Product> findProductsByName (String name) {
        return productRepository.findByNameLike("%" + name + "%");
    }
}
