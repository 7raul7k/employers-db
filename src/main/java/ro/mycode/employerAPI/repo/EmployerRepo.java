package ro.mycode.employerAPI.repo;

import org.springframework.data.jpa.repository.Modifying;
import ro.mycode.employerAPI.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer,Long> {


    @Query("Select employer FROM Employer employer where employer.firstName = ?1 AND employer.lastName = ?2")
    Employer findByFirstNameAndLastName(String firstName,String lastName);

    @Query(value = "SELECT COALESCE((SELECT id FROM employers WHERE first_name = ?1 AND last_name = ?2), -1)", nativeQuery = true)
    long getEmployerID(String firstName,String lastName);


    @Modifying
    @Query("UPDATE Employer c set c.gender = ?1 where c.firstName = ?2 AND c.lastName = ?3")
    void updateGender(String newGender,String firstName,String lastName);

    @Modifying
    @Query("UPDATE Employer c SET c.email = ?1 WHERE c.firstName = ?2 AND c.lastName = ?3")
    void updateEmail(String newEmail,String firstName,String lastName);

    @Modifying
    @Query("UPDATE Employer c SET c.adress = ?1 WHERE c.firstName = ?2 AND c.lastName = ?3")
    void updateAdress(String newAdress,String firstName,String lastName);

    @Modifying
    @Query("UPDATE Employer c SET c.salary = ?1 WHERE c.firstName = ?2 AND c.lastName = ?3")
    void updateSalary(int newSalary,String firstName,String lastName);

    @Modifying
    @Query("UPDATE Employer c SET c.department = ?1 WHERE c.firstName = ?2 AND c.lastName = ?3")
    void updateDepartment(String newDepartment,String firstName,String lastName);




}
