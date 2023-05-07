package microservice.importdetail.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Supplier {
    private Long id;
    private String name;
    private String description;
    private String phoneNumber;
}
