package kz.kerey.business.goodtype;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import kz.kerey.api.GoodTypeInterface;
import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class GoodTypeService {

	@EJB
	GoodTypeInterface bean;
	
	@Inject
	GoodTypeValidator validator;
	
	@WebMethod
	public List<GoodTypeWrapper> getGoodTypeList(
			@WebParam(name="paged")
			Boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage) throws ValidatorException {
		return bean.getGoodTypeList(paged, pageNum, perPage);
	}
	
	@WebMethod
	public void deleteGoodType(
			@WebParam(name="id")
			Long id) throws ValidatorException {
		if (id==null || id==0L)
			throw new ValidatorException(Constants.objectIsNull, "ID is null");
		bean.deleteGoodType(id);
	}
	
	@WebMethod
	public void createGoodType(GoodTypeWrapper goodType) throws ValidatorException {
		validator.validate(goodType);
		bean.createGoodType(goodType);
	}
	
} 
