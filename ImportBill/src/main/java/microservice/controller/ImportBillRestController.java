package microservice.controller;

import microservice.model.ImportBill;
import microservice.repository.ImportBillEntityRepoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/import-bill", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImportBillRestController {
    private final ImportBillEntityRepoAdapter importBillEntityRepoAdapter;

    @Autowired
    public ImportBillRestController(ImportBillEntityRepoAdapter importBillEntityRepoAdapter){
        this.importBillEntityRepoAdapter = importBillEntityRepoAdapter;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImportBill save(@RequestBody ImportBill importBill){
        return importBillEntityRepoAdapter.save(importBill);
    }
    @PostMapping(value = "/by-supplier/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public long deleteAllBySupplierId(@RequestBody Long supplierId) {
        return importBillEntityRepoAdapter.deleteAllBySupplierId(supplierId);
    }
}
