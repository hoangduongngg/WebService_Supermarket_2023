package ptit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    protected Long id;
    protected String username;
    protected String password;
    protected String name;
    protected String telephone;
    protected String email;
    protected String userType;
    public User(User user){
        this(user.id, user.username, user.password, user.name, user.telephone, user.email, user.userType);
    }
}
