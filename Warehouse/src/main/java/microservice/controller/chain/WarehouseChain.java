package microservice.controller.chain;

import microservice.service.AbsService;

public abstract class WarehouseChain
        <S extends AbsService, K>{
    protected WarehouseChain nextChain;
    protected S doChainService;
    public WarehouseChain(S doChainService){
        this.doChainService = doChainService;
    }
    public void setNextChain(WarehouseChain nextChain){
        this.nextChain = nextChain;
    }
    public boolean doChaining(K k){
        return nextChain == null || nextChain.doChaining(k);
    }
}
