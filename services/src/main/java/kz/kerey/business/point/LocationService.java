package kz.kerey.business.point;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import kz.kerey.business.wrappers.LocationWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class LocationService {

	@Inject
	LocationEJB bean;
	
	@Inject
	LocationValidator locationValidator;
	
	@WebMethod
	public List<LocationWrapper> getLocationList(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage) throws ValidatorException {
		if (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0))
			throw new ValidatorException(Constants.rangeIsIncorrect,"rangeIsIncorrect");
		return bean.getLocationList(paged, pageNum, perPage);
	}
	
	@WebMethod
	public List<LocationWrapper> getLocationListFiltered(
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
			return bean.getLocationList(paged, pageNum, perPage);
		return bean.getLocationListFiltered(paged, pageNum, perPage, filter);
	}
	
	@WebMethod
	public void deleteLocation(
			@WebParam(name="id")
			Long id) throws ValidatorException {
		if (id==null || id==0)
			throw new ValidatorException(Constants.objectIsNull,"ID which is provided is NULL");
		bean.deleteLocation(id);
	}
	
	@WebMethod
	public void createLocation(LocationWrapper location) throws ValidatorException {
		locationValidator.validate(location);
		bean.createLocation(location);
	}
	
}