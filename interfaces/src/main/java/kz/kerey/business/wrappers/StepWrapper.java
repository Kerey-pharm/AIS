package kz.kerey.business.wrappers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StepWrapper implements Serializable {

	private static final long serialVersionUID = 1229587624568829998L;
	
	private Long id;
	private String name;
	private String comment;
	private Long ladder;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getLadder() {
		return ladder;
	}
	public void setLadder(Long ladder) {
		this.ladder = ladder;
	}
	
}
