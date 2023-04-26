package api_ws.repository;

import api_ws.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductReopsitory extends JpaRepository<Product, Integer> {
    Optional<Product> findById (Integer id);
    List<Product> findByNameLike (String name);
}
