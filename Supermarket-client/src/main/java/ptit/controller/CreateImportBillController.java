package ptit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptit.model.ImportBill;
import ptit.model.ImportBillDetail;
import ptit.model.Product;
import ptit.model.Supplier;
import ptit.service.WarehouseService;

import java.util.ArrayList;

@RestController
@RequestMapping(value =  "", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CreateImportBillController {
    private WarehouseService warehouseService;

    @Autowired
    public CreateImportBillController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
    @GetMapping
    public int get(){
        ImportBill bill = new ImportBill();
        Product product1 = new Product();

        product1.setId(1L);
        ImportBillDetail billDetail1 = new ImportBillDetail();
        billDetail1.setUnitPrice(10f);
        billDetail1.setQuantity(10);
        billDetail1.setProduct(product1);
        billDetail1.setImportBill(bill);

        Product product2 = new Product();
        product2.setId(2L);
        ImportBillDetail billDetail2 = new ImportBillDetail();
        billDetail2.setUnitPrice(20f);
        billDetail2.setQuantity(20);
        billDetail2.setProduct(product2);
        billDetail2.setImportBill(bill);

        Supplier supplier = new Supplier();
        supplier.setId(9L);

        bill.setSupplier(supplier);
        bill.setCreatedTime(new java.sql.Date(new java.util.Date().getTime()));
        bill.setDetails(new ArrayList<>(){{add(billDetail1);add(billDetail2);}});
        warehouseService.save(bill);
        return 1;
    }
}
