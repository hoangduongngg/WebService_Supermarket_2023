package microservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Supplier {
    protected Long id;
    protected String name;
    protected String description;
    protected String phoneNumber;
}
