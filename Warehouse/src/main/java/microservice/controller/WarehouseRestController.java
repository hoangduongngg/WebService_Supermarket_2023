package microservice.controller;

import microservice.model.ImportBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/warehouse", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class WarehouseRestController {
    private final WarehouseFacade warehouseFacade;
    @Autowired
    public WarehouseRestController(WarehouseFacade warehouseFacade){
        this.warehouseFacade = warehouseFacade;
    }

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public int importGoods(@RequestBody ImportBill importBill){
        return warehouseFacade.doImportGoodsChaining(importBill)? 1:0;
    }
    @PostMapping(value = "/delete-supplier", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public int deleteSupplier(@RequestBody Long supplierId){
        return warehouseFacade.doDeleteSupplierChaining(supplierId)?1:0;
    }
}
