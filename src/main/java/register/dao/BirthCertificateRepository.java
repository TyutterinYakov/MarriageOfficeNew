package register.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import register.domain.BirthCertificate;

@Repository
public interface BirthCertificateRepository extends JpaRepository<BirthCertificate, Long> {

	@Query(nativeQuery = true, value="SELECT * FROM ro_birth_certificate WHERE number_certificate=?1 AND issue_date=?2 "
			+ "AND father_id=?3 AND mother_id=?4 AND person_id=?5")
	Optional<BirthCertificate> findBirthCertificate(String num, LocalDate issueDate, Long father, Long mother, Long person);
}
