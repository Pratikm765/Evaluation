package com.project.pavani.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.pavani.config.Constants;
import com.project.pavani.models.enumerations.UserType;
import com.sun.istack.NotNull;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ayush.pandey
 */

@Entity
@Table(name = "user")
public class UserModel extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Pattern(regexp = Constants.USER_ID_REGEX)
	private String userId;

	@JsonIgnore
	@NotNull
	@Size(min = 60, max = 60)
	@Column(name = "password_hash", length = 60, nullable = false)
	private String password;

	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;

	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	@Column(length = 254, unique = true)
	private String email;

	@NotNull
	@Column(nullable = false)
	private boolean activated = false;

	@Size(max = 256)
	@Column(name = "image_url", length = 256)
	private String imageUrl;

	@Size(max = 20)
	@Column(name = "activation_key", length = 20)
	@JsonIgnore
	private String activationKey;

	@Column(name = "activation_date", length = 20)
	@JsonIgnore
	private Instant activationDate;

	@Column(name = "activation_attempts", length = 20)
	@JsonIgnore
	private Integer activationAttempts = 5;

	@Size(max = 20)
	@Column(name = "reset_key", length = 20)
	@JsonIgnore
	private String resetKey;

	@Column(name = "reset_date")
	private Instant resetDate = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_type")
	private UserType userType;

	@OneToMany(mappedBy = "interviewee")
	@Column(name = "interviews_given")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<InterviewModel> interviewsGiven = new HashSet<>();

	@OneToMany(mappedBy = "interviewer")
	@Column(name = "interviews_taken")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<InterviewModel> interviewsTaken = new HashSet<>();

	//Why Not one to many? Answer : for safer side
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "user_authority",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
	@BatchSize(size = 20)
	private Set<Authority> authorities = new HashSet<>();


	public Long getId() {
		return id;
	}

	public UserModel setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserModel setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserModel setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserModel setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserModel setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserModel setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean isActivated() {
		return activated;
	}

	public UserModel setActivated(boolean activated) {
		this.activated = activated;
		return this;
	}

	public Instant getActivationDate() {
		return activationDate;
	}

	public UserModel setActivationDate(Instant activationDate) {
		this.activationDate = activationDate;
		return this;
	}
	public Integer getActivationAttempts() {
		return this.activationAttempts;
	}

	public UserModel setActivationAttempts(Integer activationAttempts) {
		this.activationAttempts = activationAttempts;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public UserModel setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public UserModel setActivationKey(String activationKey) {
		this.activationKey = activationKey;
		return this;
	}

	public String getResetKey() {
		return resetKey;
	}

	public UserModel setResetKey(String resetKey) {
		this.resetKey = resetKey;
		return this;
	}

	public Instant getResetDate() {
		return resetDate;
	}

	public UserModel setResetDate(Instant resetDate) {
		this.resetDate = resetDate;
		return this;
	}

	public Set<InterviewModel> getInterviewsGiven() {
		return interviewsGiven;
	}

	public UserModel setInterviewGiven(Set<InterviewModel> interviewsGiven) {
		this.interviewsGiven = interviewsGiven;
		return this;
	}

	public UserModel removeInterviewsGiven(InterviewModel interviewGiven) {
		this.interviewsGiven.remove(interviewGiven);
		return this;
	}

	public UserModel addInterviewsGiven(InterviewModel interviewGiven) {
		this.interviewsGiven.add(interviewGiven);
		return this;
	}


	public Set<InterviewModel> getInterviewsTaken() {
		return interviewsTaken;
	}

	public UserModel setInterviewsTaken(Set<InterviewModel> interviewsTaken) {
		this.interviewsTaken = interviewsTaken;
		return this;
	}

	public UserModel removeInterviewsTaken(InterviewModel interviewTaken) {
		this.interviewsGiven.remove(interviewTaken);
		return this;
	}

	public UserModel addInterviewsTaken(InterviewModel interviewTaken) {
		this.interviewsTaken.add(interviewTaken);
		return this;
	}


	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public UserModel setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
		return this;
	}

	public UserModel removeAuthorities(Authority authority) {
		this.authorities.remove(authority);
		return this;
	}

	public UserModel addAuthorities(Authority authority) {
		this.authorities.add(authority);
		return this;
	}

	public UserType getUserType() {
		return userType;
	}

	public UserModel setUserType(UserType userType) {
		this.userType = userType;
		return this;
	}

}
