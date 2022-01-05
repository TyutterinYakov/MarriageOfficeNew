package register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import register.domain.MarriageCertificate;

@Repository
public interface MarriageCertificateRepository extends JpaRepository<MarriageCertificate, Long> {

}
