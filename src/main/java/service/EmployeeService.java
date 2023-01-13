package service;

import org.springframework.stereotype.Component;
import repo.EmployerRepo;

@Component
public class EmployeeService {

    private EmployerRepo employerRepo;

    public EmployeeService(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }
}
