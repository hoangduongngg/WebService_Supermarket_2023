package ptit.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Supplier {
    protected Long id;
    protected String name;
    protected String description;
    protected String phoneNumber;
    public Supplier(Long id){
        this.id = id;
    }
}
