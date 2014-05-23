package kz.kerey.logic.services;

import javax.inject.Inject;
import javax.jws.WebService;

import kz.kerey.logic.ejbs.GoodEJB;
import kz.kerey.logic.services.types.GoodRequest;
import kz.kerey.logic.services.types.GoodResponse;

@WebService
public class GoodService {

	@Inject
	GoodEJB goodBean;
	
	public GoodResponse createGood(GoodRequest request) {
		return goodBean.createGood(request);
	}
	
}
