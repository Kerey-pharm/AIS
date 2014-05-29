package kz.kerey.business.point;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import kz.kerey.business.wrappers.DistributorWrapper;
import kz.kerey.business.wrappers.WarehouseWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class PointService {

	@Inject
	WarehouseValidator warehouseValidator;
	
	@Inject
	DistributorValidator distributorValidator;
	
	@Inject
	PointEJB bean;
	
	public List<DistributorWrapper> getDistributorList(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage) throws ValidatorException {
		if (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0))
			throw new ValidatorException(Constants.rangeIsIncorrect,"rangeIsIncorrect");
		return bean.getDistributorList(paged, pageNum, perPage);
	}
	
	public List<WarehouseWrapper> getWarehouseList(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage) throws ValidatorException {
		if (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0))
			throw new ValidatorException(Constants.rangeIsIncorrect,"rangeIsIncorrect");
		return bean.getWarehouseList(paged, pageNum, perPage);
	}
	
	@WebMethod
	public List<DistributorWrapper> getDistributorListFiltered(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage, 
			@WebParam(name="filter")
			String filter) throws ValidatorException {
		if (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0))
			throw new ValidatorException(Constants.rangeIsIncorrect,"rangeIsIncorrect");
		if (filter==null || filter.trim().length()==0)
			return bean.getDistributorList(paged, pageNum, perPage);
		return bean.getDistributorListFiltered(paged, pageNum, perPage, filter);
	}
	
	@WebMethod
	public List<WarehouseWrapper> getWarehouseListFiltered(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage, 
			@WebParam(name="filter")
			String filter) throws ValidatorException {
		if (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0))
			throw new ValidatorException(Constants.rangeIsIncorrect,"rangeIsIncorrect");
		if (filter==null || filter.trim().length()==0)
			return bean.getWarehouseList(paged, pageNum, perPage);
		return bean.getWarehouseListFiltered(paged, pageNum, perPage, filter);
	}
	
	@WebMethod
	public void deleteDistributor(
			@WebParam(name="id")
			Long id) throws ValidatorException {
		this.deletePoint(id);
	}
	
	@WebMethod
	public void deleteWarehouse(
			@WebParam(name="id")
			Long id) throws ValidatorException {
		this.deletePoint(id);
	}
	
	private void deletePoint(Long id) throws ValidatorException {
		if (id==null || id==0)
			throw new ValidatorException(Constants.objectIsNull, "ID is NULL");
		bean.deletePoint(id);
	}
	
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
