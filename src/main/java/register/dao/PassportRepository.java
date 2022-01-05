package register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import register.domain.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{

}
