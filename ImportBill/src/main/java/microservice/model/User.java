package microservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class User {
    protected Long id;
    protected String username;
    protected String password;
    protected String name;
    protected String telephone;
    protected String email;
}
