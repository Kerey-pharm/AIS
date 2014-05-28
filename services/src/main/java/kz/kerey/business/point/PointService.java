package kz.kerey.business.point;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import kz.kerey.exceptions.ValidatorException;

@WebService
public class PointService {

	@Inject
	WarehouseValidator warehouseValidator;
	
	@Inject
	DistributorValidator distributorValidator;
	
	@Inject
	PointEJB bean;
	
	@WebMethod
	public void createWarehouse(WarehouseWrapper obj) throws ValidatorException {
		warehouseValidator.validate(obj);
		bean.createWarehouse(obj);
	}
	
	@WebMethod
	public void createDistributor(DistributorWrapper obj) throws ValidatorException {
		distributorValidator.validate(obj);
		bean.createDistributor(obj);
	}
	
}
