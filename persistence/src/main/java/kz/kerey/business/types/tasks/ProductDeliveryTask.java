package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ProductDeliveryTask")
public class ProductDeliveryTask extends Task {

}