package kz.kerey.business.point;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.points.Warehouse;

@XmlRootElement
public class WarehouseWrapper extends PointWrapper {
	
	public static WarehouseWrapper fromEntity(Warehouse obj) {
		WarehouseWrapper res = new WarehouseWrapper();
		PointWrapper.fromEntity(res, obj);
		return res;
	}
	
	public static Warehouse toEntity(WarehouseWrapper obj) {
		Warehouse res = new Warehouse();
		PointWrapper.toEntity(res, obj);
		return res;
	}
	
}