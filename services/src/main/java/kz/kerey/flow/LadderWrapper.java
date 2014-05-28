package kz.kerey.flow;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LadderWrapper {

	private Long id;
	private String name;
	private List<StepWrapper> steps;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<StepWrapper> getSteps() {
		return steps;
	}
	public void setSteps(List<StepWrapper> steps) {
		this.steps = steps;
	}
	
}
