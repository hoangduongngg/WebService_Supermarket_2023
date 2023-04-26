package microservice.chain;

import microservice.model.ImportBill;

public class ImportGoodsChain<SS extends ImportGoods> {
    private ImportGoodsChain nextChain;
    private SS savingService;
    public ImportGoodsChain(SS savingService){
        this.savingService = savingService;
    }
    public void setNextChain(ImportGoodsChain nextChain){
        this.nextChain = nextChain;
    }
    public boolean importGoods(ImportBill importBill){
        return (
            savingService.save(importBill) &&
            (nextChain == null || nextChain.importGoods(importBill))
        );
    }
}
