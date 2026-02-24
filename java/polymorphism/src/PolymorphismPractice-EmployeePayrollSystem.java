package package1;

// Basic practice with abstract methods for overriding and enforcing new different calculations.

public class Main {
    static  abstract class Employee{
        private  String name;
        private double baseSalary;

        public void setName(String name){
            if(name == null || name.isBlank()){
                System.out.println("Name must not be blank.");
                return;
            }
            this.name = name;
        }
        public  void setBaseSalary(double baseSalary){
            if(baseSalary <= 0){
                System.out.println("Base salary most positive.");
                return;
            }
            this.baseSalary = baseSalary;
        }
        public String getName(){
            return  name;
        }
        public double getBaseSalary(){
            return baseSalary;
        }
        public abstract double calculatePay();

        public String describe(){
            return "Employee: " + getName() + " earns " + calculatePay() + " this period.";
        }
    }
    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double baseSalary){
            super.setName(name);
            super.setBaseSalary(baseSalary);
        }
        double calculatedPay;
        @Override
        public double calculatePay(){
            calculatedPay = getBaseSalary() * 1.2;
            return calculatedPay;
        }
        @Override
        public String describe(){
            return "Full-time: " + getName() + " earns " + calculatePay() + ".";
        }
    }
    static class PartTimeEmployee extends Employee{
        private double hoursWorked;
        public PartTimeEmployee(String name, double baseSalary, double hoursWorked){
           super.setName(name);
           super.setBaseSalary(baseSalary);
           if(hoursWorked < 0){
               System.out.println("Hours worked must be greater than or equal to 0.");
               return;
           }
           this.hoursWorked = hoursWorked;
        }
        public void setHoursWorked(double hours){
            if(hours < 0){
                System.out.println("Hours worked cannot be negative.");
                return;
            }
            this.hoursWorked = hours;
        }
        double calculatedPay;
        @Override
        public double calculatePay(){
            calculatedPay = getBaseSalary() * hoursWorked;
            return calculatedPay;
        }
        @Override
        public String describe(){
            return "Part-time: " + getName() + " earns " + calculatePay() + " for " + hoursWorked + " hours.";
        }
    }
    static class ContractEmployee extends Employee{
        private int projectsCompleted;

        public ContractEmployee(String name, double baseSalary, int projectsCompleted){
            super.setName(name);
            super.setBaseSalary(baseSalary);
            if(projectsCompleted < 0){
                System.out.println("Completed projects must be greater than or equal to zero.");
                return;
            }
            this.projectsCompleted = projectsCompleted;
        }
        public void setProjectsCompleted(int p){
            if(p < 0){
                System.out.println("Projects cannot be negative.");
                return;
            }
            this.projectsCompleted = p;
        }
        double calculatedPay;
        @Override
        public double calculatePay(){
            calculatedPay = getBaseSalary() + (projectsCompleted * 150);
            return calculatedPay;
        }
        @Override
        public String describe(){
            return "Contract: " + getName() + " earns " + calculatePay() + " with " + projectsCompleted + " projects.";
        }
    }
    public static void main (String[] args){
        Employee[] employees = new Employee[4];

        employees[0] = new FullTimeEmployee("John", 3000.0);
        employees[1] = new PartTimeEmployee("Mia", 100,5.0);
        employees[2] = new ContractEmployee("Abe", 2300.0, 3);
        employees[3] = new FullTimeEmployee("Karen", 4000.0);

        for(Employee e : employees){
            System.out.println(e.describe());
        }
    }
}
