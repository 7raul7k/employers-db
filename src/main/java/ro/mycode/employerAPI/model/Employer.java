package ro.mycode.employerAPI.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity(name = "Employer")
@Table(name = "employers")

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Employer implements Comparable<Employer> {
    @GeneratedValue (
        strategy = GenerationType.AUTO
    )
    @Id

    private long id;
    private String firstName;
    private String lastName;
    private String gender;

    private String email;
    private String adress;
    private int salary;
    private String department;


    public Employer(String firstName, String lastName, String gender, String email, String adress, int salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.adress = adress;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString(){
        String text = "";
        text += "ID: " + id;
        text += "\nFirst name: "+firstName;
        text += "\n Last name: " + lastName;
        text += "\n Gender: " + gender;
        text += "\n Email: "+ email;
        text += "\n Adress: " + adress;
        text += "\n Salary: $ " + salary;
        text += "\n Department: " + department;
        text += "\n======================================\n";
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Employer m = (Employer) obj;
        if(this.firstName.equals(m.firstName)&&this.lastName.equals(m.lastName)&&this.gender.equals(m.gender)&&this.adress.equals(m.adress)&&this.salary==m.salary&&this.department.equals(department)){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Employer o) {

       if(o.salary < this.salary){
           return 1;
       }else if (o.salary > this.salary){
           return -1;
       }
       return 0;
    }
}
