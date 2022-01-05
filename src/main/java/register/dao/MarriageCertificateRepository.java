package register.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import register.domain.MarriageCertificate;

@Repository
public interface MarriageCertificateRepository extends JpaRepository<MarriageCertificate, Long> {
	

	@Query(nativeQuery = true, value="SELECT * FROM RO_MARRIAGE_CERTIFICATE WHERE number_certificate=?1 AND issue_date=?2 "
			+ "AND husband_id=?3 AND wife_id=?4 AND active='true'")
	
	
	Optional<MarriageCertificate> findMarriageCertifficate(
			String marriageCertificateNumber,
			LocalDate marriageCertificateDate,
			Long husband,
			Long wife
			
			
			);

}
