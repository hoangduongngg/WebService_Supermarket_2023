package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WarehouseApplication {
    public static final String PRODUCT_SERVICE_URL = "http://localhost:8081/api/product";
    public static final String IMPORT_BILL_SERVICE_URL = "http://localhost:8080/api/import-bill";
    public static final String SUPPLIER_SERVICE_URL = "http://localhost:8082/api/import-bill";
    public static final String IMPORT_BILL_DETAIL_SERVICE_URL = "http://localhost:8083/api/import-bill-detail";
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(WarehouseApplication.class, args);
    }

}
