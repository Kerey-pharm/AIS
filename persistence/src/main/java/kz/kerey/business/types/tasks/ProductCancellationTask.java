package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ProductCancellationTask")
public class ProductCancellationTask extends Task {

}