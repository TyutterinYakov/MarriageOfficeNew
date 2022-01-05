package register.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name="ro_person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="sex", discriminatorType= DiscriminatorType.INTEGER)  ///2-husband 1-wife
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private Long personId;
	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="last_name", nullable = false)
	private String lasName;
	@Column(name="patronymic")
	private String patronymic;
	@Column(name="date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	@OneToOne(cascade= {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="person")
	private BirthCertificate birthCertificate;
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="person")
	private List<Passport> passports;
	
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Passport> getPassports() {
		return passports;
	}
	public void setPassports(List<Passport> passports) {
		this.passports = passports;
	}
	public BirthCertificate getBirthCertificate() {
		return birthCertificate;
	}
	public void setBirthCertificate(BirthCertificate birthCertificate) {
		this.birthCertificate = birthCertificate;
	}
	
	
	
	
}
