package kz.kerey.business.types.tasks;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import kz.kerey.business.types.documents.Document;
import kz.kerey.business.user.User;
import kz.kerey.flow.Ladder;
import kz.kerey.flow.Step;

@Entity
public class TaskHistoryItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Task task;
	
	@Column
	private Date dateStarted;
	
	@Column
	private Date dateFinished;
	
	@Column
	private String comment;
	
	@ManyToOne
	private User userFinished;
	
	@ManyToOne
	private Step step;
	
	@ManyToOne
	private Ladder ladder;
	
	@OneToMany
	private List<Document> documents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUserFinished() {
		return userFinished;
	}

	public void setUserFinished(User userFinished) {
		this.userFinished = userFinished;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public Ladder getLadder() {
		return ladder;
	}

	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}