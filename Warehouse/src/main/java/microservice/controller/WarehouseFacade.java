package microservice.controller;

import microservice.controller.chain.SupplierDeleter;
import microservice.controller.chain.ProductImporter;
import microservice.model.ImportBill;
import microservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseFacade {
    // Chains
    private ProductImporter productImporter;
    private SupplierDeleter supplierDeleter;

    // Services
    private AbsService productService;
    private AbsService supplierService;
    private AbsService importBillService;
    private AbsService importBillDetailService;

    @Autowired
    public WarehouseFacade(
            ProductService productService,
            SupplierService supplierService,
            ImportBillService importBillService,
            ImportDetailService importDetailService) {
        this.productService = productService;
        this.supplierService = supplierService;
        this.importBillService = importBillService;
        this.importBillDetailService = importDetailService;

        initChains();
    }
    private void initChains(){
        // Import products chain
        ProductImporter importBillCreator = new ProductImporter(importBillService);
        ProductImporter detailsCreator = new ProductImporter(importBillDetailService);
        ProductImporter productImporter = new ProductImporter(productService);

        this.productImporter = importBillCreator;
        importBillCreator.setNextChain(detailsCreator);
        detailsCreator.setNextChain(productImporter);

        // Delete supplier chain
        SupplierDeleter deleteImportBillDetails = new SupplierDeleter(importBillDetailService);
        SupplierDeleter deleteImportBill = new SupplierDeleter(importBillService);
        SupplierDeleter supplierChain = new SupplierDeleter(supplierService);
        supplierDeleter = deleteImportBillDetails;
        deleteImportBillDetails.setNextChain(deleteImportBill);
        deleteImportBill.setNextChain(supplierChain);
    }
    public boolean doImportGoodsChaining(ImportBill importBill){
        return productImporter.doChaining(importBill);
    }
    public boolean doDeleteSupplierChaining(Long supplierId){
        return supplierDeleter.doChaining(supplierId);
    }
}
