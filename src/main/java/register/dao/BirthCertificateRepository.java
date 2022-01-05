package register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import register.domain.BirthCertificate;

@Repository
public interface BirthCertificateRepository extends JpaRepository<BirthCertificate, Long> {

}
