package register.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import register.domain.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select pr FROM Person pr where pr.firstName =:firstName AND "
			+ "pr.lasName =:lasName AND pr.patronymic = :patronymic "
			+ "AND pr.dateOfBirth=:dateOfBirth")
	
	Optional<Person> findPerson(
			@Param("firstName")String firstName,
			@Param("lasName")String lasName,
			@Param("patronymic")String patronymic,
			@Param("dateOfBirth")LocalDate dateOfBirth
			);

}
