package ptit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ptit.model.*;
import ptit.service.SupplierService;
import ptit.service.WarehouseService;

import java.util.ArrayList;

@Controller
@RequestMapping("/warehouse/import")
public class BillCreationController {
    private WarehouseService warehouseService;
    private SupplierService supplierService;

    @Autowired
    public BillCreationController(WarehouseService warehouseService, SupplierService supplierService) {
        this.warehouseService = warehouseService;
        this.supplierService = supplierService;
    }
    @GetMapping("/addsup")
    public int addsup(){
        WarehouseWorker warehouseWorker = new WarehouseWorker();
        warehouseWorker.setId(1L);
        warehouseWorker.setUsername("1");
        warehouseWorker.setPassword("1");
        ImportBill bill = new ImportBill();
        Product product1 = new Product();

        product1.setId(1L);
        ImportDetail billDetail1 = new ImportDetail();
        billDetail1.setUnitPrice(10f);
        billDetail1.setQuantity(10);
        billDetail1.setProduct(product1);
        billDetail1.setImportBill(bill);

        Product product2 = new Product();
        product2.setId(2L);
        ImportDetail billDetail2 = new ImportDetail();
        billDetail2.setUnitPrice(20f);
        billDetail2.setQuantity(20);
        billDetail2.setProduct(product2);
        billDetail2.setImportBill(bill);

        Supplier supplier = new Supplier();
        supplier.setId(6L);

        bill.setCreator(warehouseWorker);
        bill.setSupplier(supplier);
        bill.setCreatedTime(new java.sql.Date(new java.util.Date().getTime()));
        bill.setDetails(new ArrayList<>(){{add(billDetail1);add(billDetail2);}});
        warehouseService.saveImportBill(bill);
        return 1;
    }
    @GetMapping("/delsup")
    public int delsup(){
        return 1;
    }
    @GetMapping("/getipd")
    public int getipd(){
        return 1;
    }
}
