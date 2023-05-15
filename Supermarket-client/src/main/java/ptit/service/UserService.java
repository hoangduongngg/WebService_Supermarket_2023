package ptit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import ptit.model.Manager;
import ptit.model.User;
import ptit.model.WarehouseWorker;

import java.net.URI;

@Service
public class UserService extends AbsService{
    public User validate(User loginUser){
        URI uri = UriComponentsBuilder.fromHttpUrl(ServiceURL.USER_SERVICE_URL + "/validate")
                        .queryParam("username", loginUser.getUsername())
                                .queryParam("password", loginUser.getPassword())
                                        .build().toUri();
        User response = rest.postForObject(uri, loginUser, User.class);
        if (response != null){
            if (response.getUserType().equalsIgnoreCase("MANAGER")){
                return new Manager(response);
            }
            if (response.getUserType().equalsIgnoreCase("WAREHOUSE_WORKER")){
                return new WarehouseWorker(response);
            }
        }
        return null;
    }
}
