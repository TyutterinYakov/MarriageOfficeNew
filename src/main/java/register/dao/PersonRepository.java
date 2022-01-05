package register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import register.domain.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
