package com.project.pavani.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author ayush.pandey
 */

@Entity
public class InterviewModel  extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "scheduled_date")
	private Instant scheduledDate;

	@Column(name = "occured_date")
	private Instant occuredDate;

	@ManyToOne
	@JsonIgnoreProperties(value = "interviewsGiven", allowSetters = true)
	private UserModel interviewee;

	@ManyToOne
	@JsonIgnoreProperties(value = "interviewsTaken", allowSetters = true)
	private UserModel interviewer;


	@Lob
	@Column(name = "review")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private String review;

	@Column
	private Integer rating;

	private Boolean selected;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getScheduledDate() {
		return scheduledDate;
	}

	public InterviewModel setScheduledDate(Instant scheduledDate) {
		this.scheduledDate = scheduledDate;
		return this;
	}

	public Instant getOccuredDate() {
		return occuredDate;
	}

	public InterviewModel setOccuredDate(Instant occuredDate) {
		this.occuredDate = occuredDate;
		return this;
	}

	public UserModel getInterviewer() {
		return interviewer;
	}

	public InterviewModel setInterviewer(UserModel interviewer) {
		this.interviewer = interviewer;
		return this;
	}

	public UserModel getInterviewee() {
		return interviewee;
	}

	public InterviewModel setInterviewee(UserModel interviewee) {
		this.interviewee = interviewee;
		return this;
	}

	public String getReview() {
		return review;
	}

	public InterviewModel setReview(String review) {
		this.review = review;
		return this;
	}

	public Integer getRating() {
		return rating;
	}

	public InterviewModel setRating(Integer rating) {
		this.rating = rating;
		return this;
	}

	public Boolean getSelected() {
		return selected;
	}

	public InterviewModel setSelected(Boolean selected) {
		this.selected = selected;
		return this;
	}
}
