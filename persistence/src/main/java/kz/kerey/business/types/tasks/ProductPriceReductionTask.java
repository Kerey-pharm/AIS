package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ProductPriceReductionTask")
public class ProductPriceReductionTask extends Task {

}