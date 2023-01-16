package service;


import exceptions.*;
import model.Employer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repo.EmployerRepo;

import java.util.List;



@Component

public class EmployeeService {

    private EmployerRepo employerRepo;

    public EmployeeService(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }

    public List<Employer> showEmployers(){
        return employerRepo.findAll();
    }

    public void add(Employer employer) throws EmployerFoundException {
        if(this.employerRepo.findByFirstNameAndLastName(employer.getFirstName(),employer.getLastName()) == null){
            this.employerRepo.save(employer);
        }else{
          throw new EmployerFoundException("Employer was found!");
        }
    }

    public void remove(String firstName,String lastName) throws EmployerNotFoundException {
        Employer employer = this.employerRepo.findByFirstNameAndLastName(firstName,lastName);
        if(employer != null){
            this.employerRepo.delete(employer);
        }else{
            throw new EmployerNotFoundException("Employer not found!");
        }
    }

}
