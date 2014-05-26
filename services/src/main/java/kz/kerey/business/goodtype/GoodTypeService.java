package kz.kerey.business.goodtype;

import java.util.List;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import kz.kerey.exceptions.ServiceException;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class GoodTypeService {

	@Inject
	GoodTypeEJB bean;
	
	@Inject
	GoodTypeValidator validator;
	
	@WebMethod
	public List<GoodTypeWrapper> getGoodTypeList(
			@WebParam(name="paged")
			Boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum, 
			@WebParam(name="perPage")
			Integer perPage) throws ServiceException, ValidatorException {
		return bean.getGoodTypeList(paged, pageNum, perPage);
	}
	
	@WebMethod
	public void deleteGoodType(
			@WebParam(name="id")
			Long id) throws ServiceException, ValidatorException {
		bean.deleteGoodType(id);
	}
	
	@WebMethod
	public void createGoodType(GoodTypeWrapper goodType) throws ServiceException, ValidatorException {
		validator.validate(goodType);
		bean.createGoodType(goodType);
	}
	
} 
