package Employee_Payroll_System;
import java.util.ArrayList;

 abstract class Employee{
     private  String name;
     private int id;

     public Employee(String name,int id){
         this.name=name;
         this.id=id;
     }
     public String getName(){
         return this.name;
     }
     public int getId(){
         return this.id;
     }
     public abstract double calculateSalary();

     @Override
     public String toString(){
         return "Employee [name ="+this.name+", id = "+this.id+", salary = "+calculateSalary()+"]";
     }

}
class  FullTimeEmployee extends  Employee{
     private  double monthlySalary;

     public FullTimeEmployee(String name,int id,double monthlySalary){
         super(name,id);
         this.monthlySalary=monthlySalary;

     }
     @Override
    public double calculateSalary(){
         return monthlySalary;
     }
}

class PartTimeEmployee extends Employee{
     private  int hourWorked;
     private  double hourlyRate;

     public  PartTimeEmployee(String name ,int id , int hourlyRate,int hourWorked){
         super(name,id);
         this.hourlyRate=hourlyRate;
         this.hourWorked=hourWorked;
     }
     @Override
    public double calculateSalary(){
         return hourWorked*hourlyRate;
     }
}
class Payrollsystem{
     private  ArrayList<Employee> employeeList;
     public  Payrollsystem(){
         employeeList=new ArrayList<>();
     }
     public void addEmployee(Employee employee){
         employeeList.add(employee);
     }

     public void removeEmployee(int id){
         Employee employeeToRemove =null;

         for(Employee employee:employeeList){
             if(employee.getId()==id){
                 employeeToRemove=employee;
                 break;
             }
         }
         if(employeeToRemove!=null){
             employeeList.remove(employeeToRemove);
         }
     }
     public void display(){
         for(Employee employee:employeeList){
             System.out.println(employee);
         }
     }
}
public class Main {
    public static void main(String[] args) {
        Payrollsystem payrollsystem=new Payrollsystem();
        FullTimeEmployee emp1=new FullTimeEmployee("akshay",1,5000);
        PartTimeEmployee emp2=new PartTimeEmployee("nikhil",2,500,6);

        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("Intiall Employee Details :");
        payrollsystem.display();


        payrollsystem.removeEmployee(1);
        System.out.println("Remaining Employee Details :");
        payrollsystem.display();


    }
}
