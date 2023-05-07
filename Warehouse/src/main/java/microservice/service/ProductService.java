package microservice.service;

import microservice.controller.chain.ImportProductInterface;
import microservice.model.ImportBill;
import microservice.model.ImportDetail;
import microservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends AbsService implements ImportProductInterface {
    private static final String IMPORT_PRODUCTS_API
            = ServiceURL.PRODUCT_SERVICE_URL + "/import";
    @Override
    public boolean save(ImportBill importBill) {
        Integer response = rest.postForObject(
                IMPORT_PRODUCTS_API,
                getProducts(importBill),
                Integer.class);
        return response == importBill.getDetails().size();
    }
    private List<Product> getProducts(ImportBill importBill){
        List<Product> products = new ArrayList<>();
        for (ImportDetail importBillDetail:importBill.getDetails()){
            Product product = importBillDetail.getProduct();
            product.setQuantity(importBillDetail.getQuantity());
            products.add(product);
        }
        return products;
    }
}
