package repo;

import model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer,Long> {




}
