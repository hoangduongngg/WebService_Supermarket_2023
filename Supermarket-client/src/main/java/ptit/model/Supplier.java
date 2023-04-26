package ptit.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Supplier {
    private static final long serialVersionUID = 100000000000000L;
    private Long id;
    private String name;
    private String description;
    private String phoneNumber;
}
