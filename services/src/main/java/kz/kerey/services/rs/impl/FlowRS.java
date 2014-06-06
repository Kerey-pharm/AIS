package kz.kerey.services.rs.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import kz.kerey.business.types.enums.LadderProperty;
import kz.kerey.business.types.enums.StepProperty;
import kz.kerey.business.wrappers.LadderWrapper;
import kz.kerey.business.wrappers.StepWrapper;
import kz.kerey.services.api.FlowInterface;
import kz.kerey.validators.LadderValidator;
import kz.kerey.validators.StepValidator;

public class FlowRS implements FlowInterface {

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;
	
	@EJB
	FlowInterface bean;
	
	@Inject
	LadderValidator ladderValidator;
	
	@Inject
	StepValidator stepValidator;

	@Override
	public void createLadder(LadderWrapper ladder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLadder(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LadderWrapper> getLadderList(Boolean paged, Integer pageNum,
			Integer perPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLadderProperty(Long id, LadderProperty property,
			String newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createStep(StepWrapper step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStep(Long ladder, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStepProperty(Long id, StepProperty property,
			String newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StepWrapper> getLadderSteps(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swapLadderSteps(Long ladder, Long left, Long right) {
		// TODO Auto-generated method stub
		
	}
	
}
