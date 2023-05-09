package microservice.user.controller;

import microservice.user.model.Customer;
import microservice.user.model.Manager;
import microservice.user.model.User;
import microservice.user.model.WarehouseWorker;
import microservice.user.repository.CustomerRepository;
import microservice.user.repository.ManagerRepository;
import microservice.user.repository.WarehouseWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private CustomerRepository customerRepository;
    private WarehouseWorkerRepository warehouseWorkerRepository;
    private ManagerRepository managerRepository;

    @Autowired
    public UserRestController(CustomerRepository customerRepository, WarehouseWorkerRepository warehouseWorkerRepository, ManagerRepository managerRepository) {
        this.customerRepository = customerRepository;
        this.warehouseWorkerRepository = warehouseWorkerRepository;
        this.managerRepository = managerRepository;
    }
    @GetMapping("/validate")
    public Map<String, Object> validate(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        Map<String, Object> response = new HashMap<>();
        Optional<User> userFind = managerRepository.findByUsernameAndPassword(username, password);
        response.put("userType", "MANAGER");
        if (userFind.isEmpty()){
            userFind = warehouseWorkerRepository.findByUsernameAndPassword(username, password);
            response.put("userType", "WAREHOUSE_WORKER");
        }
        if (userFind.isEmpty()){
            userFind = customerRepository.findByUsernameAndPassword(username, password);
            response.put("userType", "CUSTOMER");
        }
        if (userFind.isEmpty()){
            response.put("userType", "NOT_FOUND");
            return response;
        }
        response.put("user", userFind.get());
        return response;
    }
}
