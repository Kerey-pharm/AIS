package kz.kerey.business.good.service;

import javax.inject.Inject;
import javax.jws.WebService;

import kz.kerey.business.good.ejb.GoodEJB;
import kz.kerey.business.good.validator.GoodValidator;
import kz.kerey.business.good.wrapper.Good;
import kz.kerey.exceptions.ServiceException;

@WebService
public class GoodService {

	@Inject
	GoodEJB goodBean;
	
	@Inject
	GoodValidator validator;
	
	public void createGood(Good request) throws ServiceException {
		validator.validate(request);
	}
	
}
