package kz.kerey.business.types.tasks;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import kz.kerey.business.types.GoodItem;
import kz.kerey.business.types.documents.Document;
import kz.kerey.business.types.enums.TaskStatus;
import kz.kerey.business.user.User;
import kz.kerey.flow.Ladder;
import kz.kerey.flow.Step;

@Entity
public abstract class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String taskName;
	
	@Column
	private String taskComment;
	
	@Column(nullable = false)
	private Date initialDate;

	@Column
	private Date finishDate;

	@Column(nullable = false)
	private Date deadlineDate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	@Column(nullable=false)
	private String barcode;

	@ManyToOne
	private Ladder ladder;

	@ManyToOne
	private Step step;

	@ManyToOne
	private User executor;
	
	@OneToMany
	private List<Document> documents;
	
	@OneToMany
	@OrderColumn(name="index_column")
	private List<GoodItem> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Ladder getLadder() {
		return ladder;
	}

	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public User getExecutor() {
		return executor;
	}

	public void setExecutor(User executor) {
		this.executor = executor;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<GoodItem> getItems() {
		return items;
	}

	public void setItems(List<GoodItem> items) {
		this.items = items;
	}

}