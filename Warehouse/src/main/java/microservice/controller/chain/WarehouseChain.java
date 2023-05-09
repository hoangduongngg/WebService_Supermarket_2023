package microservice.controller.chain;

import microservice.service.AbsService;

public abstract class WarehouseChain
        <T extends WarehouseChain, S, K>{
    protected T nextChain;
    protected S doChainService;
    public WarehouseChain(S doChainService){
        this.doChainService = doChainService;
    }
    public void setNextChain(T nextChain){
        this.nextChain = nextChain;
    }
    public boolean doChaining(K k){
        return nextChain == null || nextChain.doChaining(k);
    }
}
