package register.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import register.domain.Passport;
import register.domain.Person;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{
	Optional<Passport> findByNumberAndSeriaAndIssueDate(String PassportNumber, String PassportSeria, LocalDate issueDate);
}
