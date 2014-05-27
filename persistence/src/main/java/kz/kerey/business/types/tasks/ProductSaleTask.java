package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ProductSaleTask")
public class ProductSaleTask extends Task {

}