package ro.mycode.employerAPI.service;



import ro.mycode.employerAPI.exceptions.EmployerNotFoundException;
import ro.mycode.employerAPI.exceptions.EmployerFoundException;
import ro.mycode.employerAPI.model.Employer;
import org.springframework.stereotype.Service;
import ro.mycode.employerAPI.repo.EmployerRepo;

import javax.transaction.Transactional;
import java.util.List;



@Service
public class EmployeeService {

    private EmployerRepo employerRepo;

    public EmployeeService(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }

    public List<Employer> showEmployers(){
        return employerRepo.findAll();
    }


    public void add(Employer e) throws EmployerFoundException {
        Employer pos = employerRepo.findByFirstNameAndLastName(e.getFirstName(),e.getLastName());

        if(pos == null ){
            this.employerRepo.save(e);
        }else{
            throw new EmployerFoundException("This employer exist!");
        }
    }

    public void remove(String firstName,String lastName) throws EmployerFoundException, EmployerNotFoundException {
        Employer pos = employerRepo.findByFirstNameAndLastName(firstName,lastName);

        if(pos!= null){
            this.employerRepo.delete(pos);
        }else{
            throw new EmployerNotFoundException("Employer not found !");
        }
    }

    public Employer getEmployer(String firstName,String lastName){
        return this.employerRepo.findByFirstNameAndLastName(firstName,lastName);
    }
    public boolean contains(String firstName,String lastName){
        if(employerRepo.getEmployerID(firstName,lastName) == -1){
            return false;
        }
        return true;
    }

    @Transactional
    public void updateGender(String firstName,String lastName,String newGender){

            this.employerRepo.updateGender(newGender,firstName,lastName);

    }

    @Transactional
    public void updateEmail(String firstName,String lastName,String email){

            this.employerRepo.updateEmail(email,firstName,lastName);


    }

    @Transactional
    public void updateAdress(String firstName,String lastName,String adress){


            this.employerRepo.updateAdress(adress,firstName,lastName);

    }

    @Transactional
    public void updateSalary(String firstName,String lastName,int salary){

       this.employerRepo.updateSalary(salary,firstName,lastName);

    }

    @Transactional
    public void updateDepartment(String firstName,String lastName,String department){
        this.employerRepo.updateDepartment(department,firstName,lastName);
    }





}
