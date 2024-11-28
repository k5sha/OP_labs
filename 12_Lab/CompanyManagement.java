import java.util.*;

class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private double salary;
    private Department department;

    // Constructors
    public Employee(String firstName, String lastName, double salary) {
        this(firstName, lastName, salary, null);
    }

    public Employee(String firstName, String lastName, double salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Department getDepartment() {
        return department;
    }

    // toString
    @Override
    public String toString() {
        return getFullName() + " (Зарплата: " + salary + ", Відділ: " + (department != null ? department.getName() : "Директор") + ")";
    }

    // Implement Comparable
    @Override
    public int compareTo(Employee other) {
        int salaryComparison = Double.compare(other.salary, this.salary);
        if (salaryComparison != 0) {
            return salaryComparison;
        } else {
            return this.getFullName().compareTo(other.getFullName());
        }
    }

    // equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return Double.compare(salary, other.salary) == 0 &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(department, other.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }
}

class Department implements Comparable<Department> {
    private String name;
    private Employee manager;
    private Set<Employee> employees;

    // Constructor
    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = new Employee(manager.getFullName().split(" ")[0], manager.getFullName().split(" ")[1], manager.getSalary(), this);
        // Initialize employees with Comparator (uses Comparator)
        this.employees = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getFullName().compareTo(e2.getFullName());
            }
        });
    }

    // Methods
    public void addEmployee(Employee employee) {
        employees.add(new Employee(employee.getFullName().split(" ")[0], employee.getFullName().split(" ")[1], employee.getSalary(), this));
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    // Implement Comparable (uses Comparable)
    @Override
    public int compareTo(Department other) {
        return this.name.compareTo(other.name);
    }

    // equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Department)) return false;
        Department other = (Department) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Company {
    private String name;
    private Employee director;
    private Set<Department> departments;

    // Constructor
    public Company(String name, Employee director) {
        this.name = name;
        this.director = new Employee(director.getFullName().split(" ")[0], director.getFullName().split(" ")[1], director.getSalary(), null);
        this.departments = new TreeSet<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Set<Employee> getAllEmployees() {
        Set<Employee> allEmployees = new TreeSet<>();
        allEmployees.add(director);
        for (Department dept : departments) {
            allEmployees.add(dept.getManager());
            allEmployees.addAll(dept.getEmployees());
        }
        return allEmployees;
    }

    public Set<Department> getDepartments() {
        return departments;
    }
}

public class CompanyManagement {

    // Завдання 1: Знайти максимальну заробітну плату серед усіх працівників
    public static double findMaxSalary(Company company) {
        double maxSalary = 0;

        // c) Типізований цикл for-each
        for (Employee employee : company.getAllEmployees()) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }

        return maxSalary;
    }

    // Завдання 2: Визначити відділи, у яких є працівники з зарплатою більшою, ніж у їхнього начальника
    public static List<String> findDepartmentsWithHigherPaidEmployees(Company company) {
        List<String> result = new ArrayList<>();

        // b) Типізований ітератор
        Iterator<Department> deptIterator = company.getDepartments().iterator();
        while (deptIterator.hasNext()) {
            Department department = deptIterator.next();
            Employee manager = department.getManager();
            Iterator<Employee> employeesIterator = department.getEmployees().iterator();

            while (employeesIterator.hasNext()) {
                Employee employee = employeesIterator.next();
                if (employee.getSalary() > manager.getSalary()) {
                    result.add(department.getName());
                    break; // Move to the next department after finding such an employee
                }
            }
        }
        return result;
    }

    // Завдання 3: Вивести інформацію про всіх працівників компанії
    public static void printAllEmployees(Company company) {
        // a) Нетипізований ітератор
        Iterator employeesIterator = company.getAllEmployees().iterator();

        while (employeesIterator.hasNext()) {
            Employee employee = (Employee) employeesIterator.next();
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        // Create company director
        Employee director = new Employee("Іван", "Іванов", 5000);
        Company company = new Company("TechCorp", director);

        // Create first department and its employees
        Employee manager1 = new Employee("Петро", "Петров", 4000);
        Department dept1 = new Department("IT", manager1);
        dept1.addEmployee(new Employee("Анна", "Смірнова", 4500)); // Employee with higher salary than manager
        dept1.addEmployee(new Employee("Олег", "Орлов", 3000));

        // Create second department and its employees
        Employee manager2 = new Employee("Марія", "Коваль", 3500);
        Department dept2 = new Department("HR", manager2);
        dept2.addEmployee(new Employee("Олена", "Новікова", 3200));
        dept2.addEmployee(new Employee("Дмитро", "Бондаренко", 3600));

        // Add departments to company
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        // Invoke tasks
        System.out.println("Максимальна зарплата: " + findMaxSalary(company));
        System.out.println("Відділи з працівниками, що отримують більше за начальника: " + findDepartmentsWithHigherPaidEmployees(company));
        printAllEmployees(company);
    }
}
