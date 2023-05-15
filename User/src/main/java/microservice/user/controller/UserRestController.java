package microservice.user.controller;

import microservice.user.model.Customer;
import microservice.user.model.Manager;
import microservice.user.model.User;
import microservice.user.model.WarehouseWorker;
import microservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {
    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/validate")
    public User validate(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        Optional<User> userFound = userRepository.findByUsernameAndPassword(username, password);
        if (userFound.isPresent()){
            if (userFound.get() instanceof Manager) {
                User res = userFound.get();
                res.setUserType("MANAGER");
                return res;
            }
            if (userFound.get() instanceof WarehouseWorker) {
                User res = userFound.get();
                res.setUserType("WAREHOUSE_WORKER");
                return res;
            }
        }
        return null;
    }
}
