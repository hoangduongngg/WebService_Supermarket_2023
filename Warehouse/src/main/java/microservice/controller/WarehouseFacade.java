package microservice.controller;

import microservice.controller.chain.SupplierDeleter;
import microservice.controller.chain.ProductImporter;
import microservice.model.ImportBill;
import microservice.model.ImportDetail;
import microservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WarehouseFacade {
    // Chains
    private ProductImporter productImporter;
    private SupplierDeleter supplierDeleter;

    // Services
    private ProductService productService;
    private SupplierService supplierService;
    private ImportBillService importBillService;
    private ImportDetailService importDetailService;

    @Autowired
    public WarehouseFacade(
            ProductService productService,
            SupplierService supplierService,
            ImportBillService importBillService,
            ImportDetailService importDetailService) {
        this.productService = productService;
        this.supplierService = supplierService;
        this.importBillService = importBillService;
        this.importDetailService = importDetailService;

        initChains();
    }
    private void initChains(){
        // Import products chain
        ProductImporter importBillCreator = new ProductImporter(importBillService);
        ProductImporter detailsCreator = new ProductImporter(importDetailService);
        ProductImporter productImporter = new ProductImporter(productService);

        this.productImporter = importBillCreator;
        importBillCreator.setNextChain(detailsCreator);
        detailsCreator.setNextChain(productImporter);

        // Delete supplier chain
        SupplierDeleter deleteImportDetails = new SupplierDeleter(importDetailService);
        SupplierDeleter deleteImportBill = new SupplierDeleter(importBillService);
        SupplierDeleter supplierChain = new SupplierDeleter(supplierService);
        supplierDeleter = deleteImportDetails;
        deleteImportDetails.setNextChain(deleteImportBill);
        deleteImportBill.setNextChain(supplierChain);
    }
    public boolean doImportGoodsChaining(ImportBill importBill){
        return productImporter.doChaining(importBill);
    }
    public boolean doDeleteSupplierChaining(Long supplierId){
        return supplierDeleter.doChaining(supplierId);
    }
}
