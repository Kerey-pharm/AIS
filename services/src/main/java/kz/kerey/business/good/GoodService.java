package kz.kerey.business.good;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class GoodService {

	@Inject
	GoodEJB goodBean;
	
	@Inject
	GoodValidator validator;
	
	@WebMethod
	public void delete(
			@WebParam(name="id")
			Long id) throws ValidatorException {
		if (id==null || id==0L)
			throw new ValidatorException(Constants.objectIsNull, "ID is null");
		goodBean.delete(id);
	}
	
	@WebMethod
	public void createGood(GoodWrapper request) throws ValidatorException {
		validator.validate(request);
		goodBean.createGood(request);
	}
	
	@WebMethod
	public List<GoodWrapper> getGoodListFiltered(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage, 
			@WebParam(name="filter")
			String filter) throws ValidatorException {
		if (filter==null || filter.trim().length()==0)
			return goodBean.getGoodList(paged, pageNum, perPage);
		return goodBean.getGoodListFiltered(paged, pageNum, perPage, filter);
	}

	@WebMethod
	public List<GoodWrapper> getGoodList(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage) throws ValidatorException {
		return goodBean.getGoodList(paged, pageNum, perPage);
	}
	
}
