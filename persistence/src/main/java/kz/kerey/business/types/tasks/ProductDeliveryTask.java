package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.kerey.business.types.points.Point;

@Entity
@DiscriminatorValue("ProductDeliveryTask")
public class ProductDeliveryTask extends Task {

	@ManyToOne
	private Point fromPoint;

	public Point getFromPoint() {
		return fromPoint;
	}

	public void setFromPoint(Point fromPoint) {
		this.fromPoint = fromPoint;
	}
	
}