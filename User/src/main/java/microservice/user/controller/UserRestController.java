package microservice.user.controller;

import microservice.user.model.WarehouseWorker;
import microservice.user.repository.CustomerRepository;
import microservice.user.repository.WarehouseWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private CustomerRepository customerRepository;
    private WarehouseWorkerRepository warehouseWorkerRepository;

    @Autowired
    public UserRestController(CustomerRepository customerRepository, WarehouseWorkerRepository warehouseWorkerRepository) {
        this.customerRepository = customerRepository;
        this.warehouseWorkerRepository = warehouseWorkerRepository;
    }
    @GetMapping
    public int get(){
        WarehouseWorker warehouseWorker = new WarehouseWorker();
        warehouseWorker.setPassword("1");
        warehouseWorker.setEmail("1");
        warehouseWorker.setName("1");
        warehouseWorker.setUsername("1");
        warehouseWorker.setTelephone("1");

        warehouseWorkerRepository.save(warehouseWorker);
        return 1;
    }
}
