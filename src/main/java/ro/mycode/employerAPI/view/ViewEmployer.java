package ro.mycode.employerAPI.view;

import org.springframework.stereotype.Component;
import ro.mycode.employerAPI.exceptions.EmployerFoundException;
import ro.mycode.employerAPI.exceptions.EmployerNotFoundException;
import ro.mycode.employerAPI.model.Employer;
import ro.mycode.employerAPI.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

@Component
public class ViewEmployer {

    private EmployeeService employeeService;

    private Scanner scanner;

    public ViewEmployer(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.scanner = new Scanner(System.in);
    }

    public void show(){
        System.out.println("Press 1 to show employers");
        System.out.println("Press 2 to add employers");
        System.out.println("Press 3 to delete employers");
        System.out.println("Press 4 to see if employers is in database and show data");
        System.out.println();

    }

    public void play() throws EmployerFoundException, EmployerNotFoundException {
        boolean running = true;

        while (running){
            show();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: showEmployers();
                break;
                case 2: addEmployers();
                break;
                case 3: deleteEmployers();
                break;
                case 4: employersBoolean();
                break;
                default: play();
            }
        }

    }

    private void employersBoolean() {

        System.out.println("Input first name");
        String firstName = scanner.nextLine();
        System.out.println("Input last name");
        String lastName = scanner.nextLine();

        boolean pos = this.employeeService.contains(firstName,lastName);

        if(pos){
            Employer employer = this.employeeService.getEmployer(firstName,lastName);
            System.out.println(employer);
        }
    }


    private void deleteEmployers() throws EmployerNotFoundException, EmployerFoundException {
        System.out.println("Input first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Input last name: ");
        String lastName = scanner.nextLine();
        this.employeeService.remove(firstName,lastName);
        Employer employer = this.employeeService.getEmployer(firstName,lastName);

        System.out.println(employer.toString());
    }

    private void addEmployers() throws  EmployerFoundException {
        System.out.println("Input first name:");
        String firstName = scanner.nextLine();
        System.out.println("Input last name:");
        String lastName = scanner.nextLine();
        System.out.println("Input email");
        String email = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input adress");
        String adress = scanner.nextLine();
        System.out.println("Input salary");
        int salary = Integer.parseInt(scanner.nextLine());
        System.out.println("Input department");
        String department = scanner.nextLine();

        Employer employer = new Employer(firstName,lastName,gender,email,adress,salary,department);
        this.employeeService.add(employer);
    }

    private void showEmployers() {
        List<Employer> employerList = employeeService.showEmployers();

        for(Employer m : employerList){
            System.out.println(m);
        }
    }


}
