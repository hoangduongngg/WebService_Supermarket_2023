package microservice.controller;


import microservice.chain.ImportGoods;
import microservice.chain.ImportGoodsChain;
import microservice.model.ImportBill;
import microservice.service.ImportBillDetailService;
import microservice.service.ImportBillService;
import microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseFacade {
    private ImportGoods productService;
    private ImportGoods importBillService;
    private ImportGoods importBillDetailService;
    private ImportGoodsChain importGoodsChains;

    @Autowired
    public WarehouseFacade(ProductService productService, ImportBillService importBillService, ImportBillDetailService importBillDetailService) {
        this.productService = productService;
        this.importBillService = importBillService;
        this.importBillDetailService = importBillDetailService;
    }
    public boolean doImportGoodsChaining(ImportBill importBill){
        if (importGoodsChains == null){
            ImportGoodsChain productImporter = new ImportGoodsChain(productService);
            ImportGoodsChain importBillCreator = new ImportGoodsChain(importBillService);
            ImportGoodsChain detailCreator = new ImportGoodsChain(importBillDetailService);

            productImporter.setNextChain(importBillCreator);
            importBillCreator.setNextChain(detailCreator);
            importGoodsChains = productImporter;
        }
        return importGoodsChains.importGoods(importBill);
    }
}
