package api_ws.controller;

import api_ws.model.entity.Product;
import api_ws.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CustomerHomeController {
    private ProductService productService;
    @GetMapping("/home")
    public ResponseEntity<List<Product>> loadCustomerHome() {
        String txtSearch = null;
        if (txtSearch == null) {
            //Load Top 50 Product
        }
        else {
            //Search
            txtSearch = "Nike"; //test
            List<Product> listP = productService.findProductsByName(txtSearch);
            return ResponseEntity.ok(listP);
        }
        return ResponseEntity.notFound().build();
    }

}
