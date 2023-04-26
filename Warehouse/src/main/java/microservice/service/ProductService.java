package microservice.service;

import microservice.WarehouseApplication;
import microservice.chain.ImportGoods;
import microservice.model.ImportBill;
import microservice.model.ImportBillDetail;
import microservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService extends AbsService implements ImportGoods {
    @Override
    public boolean save(ImportBill importBill) {
        List<Product> products = new ArrayList<>();
        for (ImportBillDetail importBillDetail:importBill.getDetails()){
            Product product = importBillDetail.getProduct();
            product.setQuantity(importBillDetail.getQuantity());
            products.add(product);
        }
        Integer response = rest.postForObject(
                WarehouseApplication.PRODUCT_SERVICE_URL + "/import",
                products,
                Integer.class);
        return response == importBill.getDetails().size();
    }
}
