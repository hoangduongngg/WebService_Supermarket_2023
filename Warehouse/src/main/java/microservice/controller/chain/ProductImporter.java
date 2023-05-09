package microservice.controller.chain;

import microservice.model.ImportBill;
import microservice.service.AbsService;

public class ProductImporter<S extends ImportProductInterface>
        extends WarehouseChain<ProductImporter, S, ImportBill>{
    public ProductImporter(S doChainService) {
        super(doChainService);
    }
    @Override
    public boolean doChaining(ImportBill importBill){
        return doChainService.save(importBill) && super.doChaining(importBill);
    }
}
