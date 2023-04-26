package microservice.chain;

import microservice.model.ImportBill;

public interface ImportGoods {
    boolean save(ImportBill importBill);
}
