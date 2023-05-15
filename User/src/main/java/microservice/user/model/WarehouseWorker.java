package microservice.user.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "WAREHOUSE_WORKER")
public class WarehouseWorker extends User{

}
