package register.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ro_passport")
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passport_id")
	private Long passportId;
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name="person_id")
//	@Column(name="person", nullable=false)
	private Person person;
	@Column(name="seria", nullable = false)
	private String seria;
	@Column(name="number", nullable = false)
	private String number;
	@Column(name="issue_date", nullable = false)
	private LocalDate issueDate;
	
	@Column(name="issue_department", nullable = false)
	private String issueDepartment;
	
	
	public Long getPassportId() {
		return passportId;
	}
	public void setPassportId(Long passportId) {
		this.passportId = passportId;
	}
	public String getSeria() {
		return seria;
	}
	public void setSeria(String seria) {
		this.seria = seria;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getIssueDepartment() {
		return issueDepartment;
	}
	public void setIssueDepartment(String issueDepartment) {
		this.issueDepartment = issueDepartment;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
	
}
