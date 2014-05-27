package kz.kerey.business.types.tasks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import kz.kerey.business.types.points.Point;

@Entity
@DiscriminatorValue("ProductMovementTask")
public class ProductMovementTask extends Task {

	@ManyToOne
	private Point fromPoint;
	
	@ManyToOne
	private Point toPoint;

	public Point getFromPoint() {
		return fromPoint;
	}

	public void setFromPoint(Point fromPoint) {
		this.fromPoint = fromPoint;
	}

	public Point getToPoint() {
		return toPoint;
	}

	public void setToPoint(Point toPoint) {
		this.toPoint = toPoint;
	}
	
}