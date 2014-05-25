package kz.kerey.business.goodtype.service;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.jws.WebService;

import kz.kerey.business.goodtype.ejb.GoodTypeEJB;
import kz.kerey.business.goodtype.validator.GoodTypeValidator;
import kz.kerey.business.goodtype.wrapper.GoodType;
import kz.kerey.exceptions.ServiceException;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class GoodTypeService {

	@Inject
	GoodTypeEJB bean;
	
	@Inject
	GoodTypeValidator validator;
	
	public void createGoodType(GoodType goodType) throws ServiceException, ValidatorException {
		validator.validate(goodType);
		try {
			bean.createGoodType(goodType);
		}
		catch (EJBException ex) {
			ex.printStackTrace();
		}
	}
	
} 
