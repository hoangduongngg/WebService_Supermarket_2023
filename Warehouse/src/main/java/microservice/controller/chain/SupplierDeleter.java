package microservice.controller.chain;

import microservice.service.AbsService;

public class SupplierDeleter<S extends DeleteSupplierInterface>
        extends WarehouseChain<SupplierDeleter, S, Long> {
    public SupplierDeleter(S doChainService) {
        super(doChainService);
    }
    @Override
    public boolean doChaining(Long supplierId) {
        return doChainService.delete(supplierId) && super.doChaining(supplierId);
    }
}