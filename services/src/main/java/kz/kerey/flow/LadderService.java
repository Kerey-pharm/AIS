package kz.kerey.flow;

import javax.inject.Inject;
import javax.jws.WebService;

import kz.kerey.business.wrappers.LadderWrapper;
import kz.kerey.business.wrappers.StepWrapper;
import kz.kerey.exceptions.ValidatorException;

@WebService
public class LadderService {

	@Inject
	LadderEJB bean;
	
	public void createLadder(LadderWrapper obj) throws ValidatorException {
		bean.createLadder(obj);
	}

	public void addStepToLadder(StepWrapper step, LadderWrapper ladder) {
		bean.addStepToLadder(step, ladder);
	}
	
}
