package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ProductMarginTask")
public class ProductMarginTask extends Task {

}