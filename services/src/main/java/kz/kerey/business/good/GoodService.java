package kz.kerey.business.good;

import javax.inject.Inject;
import javax.jws.WebService;

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