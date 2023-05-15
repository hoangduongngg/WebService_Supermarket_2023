package ptit.service;

import org.springframework.stereotype.Service;
import ptit.model.Product;

@Service
public class ProductService extends AbsService{
    public Product[] getAll(){
        return rest.getForObject(ServiceURL.PRODUCT_SERVICE_URL, Product[].class);
    }
}
