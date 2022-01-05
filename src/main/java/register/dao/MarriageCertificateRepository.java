package register.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import register.domain.MarriageCertificate;

@Repository
public interface MarriageCertificateRepository extends JpaRepository<MarriageCertificate, Long> {

	Optional<MarriageCertificate> findByWifeAndHusbandAndIssueDateAndNumber(Long personId, Long personId2, LocalDate marriageCertificateDate,
			String marriageCertificateNumber);

}
