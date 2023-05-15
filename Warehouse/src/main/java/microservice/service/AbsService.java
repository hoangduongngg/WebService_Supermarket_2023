package microservice.service;

import org.springframework.web.client.RestTemplate;

public abstract class AbsService {
    protected RestTemplate rest = new RestTemplate();
}
