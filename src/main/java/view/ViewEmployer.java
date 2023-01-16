package view;

import model.Employer;
import org.springframework.stereotype.Component;
import service.EmployeeService;

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
        System.out.println("Press 1 to show employers_");

    }

    public void play(){
        boolean running = true;

        while (running){
            show();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: showEmployers();
                    break;
                default:
            }
        }

    }

    private void showEmployers() {
        List<Employer> employerList = employeeService.showEmployers();

        for(Employer m : employerList){
            System.out.println(m);
        }
    }


}
