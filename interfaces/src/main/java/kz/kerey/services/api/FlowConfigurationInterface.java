package kz.kerey.services.api;

import java.util.List;

import kz.kerey.business.types.enums.LadderProperty;
import kz.kerey.business.types.enums.StepProperty;
import kz.kerey.business.wrappers.LadderWrapper;
import kz.kerey.business.wrappers.StepWrapper;

public interface FlowConfigurationInterface {

	public void createLadder(LadderWrapper ladder);
	public void deleteLadder(Long id);
	public List<LadderWrapper> getLadderList(Boolean paged, Integer pageNum, Integer perPage);
	public void changeLadderProperty(Long id, LadderProperty property, String newValue);
	
	public void createStep(StepWrapper step);
	public void deleteStep(Long ladder, Long id);
	public void changeStepProperty(Long id, StepProperty property, String newValue);

	public List<StepWrapper> getLadderSteps(Long id);
	public void swapLadderSteps(Long ladder, Long left, Long right);
	
}
