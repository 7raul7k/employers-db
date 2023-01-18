package ro.mycode.employerAPI.repo;

import ro.mycode.employerAPI.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer,Long> {


    @Query("Select employer FROM Employer employer where employer.firstName = ?1 AND employer.lastName = ?2")
    Employer findByFirstNameAndLastName(String firstName,String lastName);





}
