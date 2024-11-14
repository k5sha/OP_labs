import java.util.*;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private Department department;

    // Конструктор для ініціалізації працівника
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Конструктор для ініціалізації працівника з відділом
    public Employee(String firstName, String lastName, double salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    // Метод для отримання заробітної плати працівника
    public double getSalary() {
        return salary;
    }

    // Метод для отримання повного імені працівника
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Метод для отримання відділу працівника
    public Department getDepartment() {
        return department;
    }

    // Переозначення методу toString для відображення інформації про працівника
    @Override
    public String toString() {
        return getFullName() + " (Зарплата: " + salary + ", Відділ: " + (department != null ? department.getName() : "Директор") + ")";
    }
}

class Department {
    private String name;
    private Employee manager;
    private List<Employee> employees;

    // Конструктор для ініціалізації відділу
    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.manager = new Employee(manager.getFullName().split(" ")[0], manager.getFullName().split(" ")[1], manager.getSalary(), this);
    }

    // Метод для додавання працівника до відділу
    public void addEmployee(Employee employee) {
        employees.add(new Employee(employee.getFullName().split(" ")[0], employee.getFullName().split(" ")[1], employee.getSalary(), this));
    }

    // Метод для отримання назви відділу
    public String getName() {
        return name;
    }

    // Метод для отримання начальника відділу
    public Employee getManager() {
        return manager;
    }

    // Метод для отримання списку працівників відділу
    public List<Employee> getEmployees() {
        return employees;
    }
}

class Company {
    private String name;
    private Employee director;
    private List<Department> departments;

    // Конструктор для ініціалізації компанії
    public Company(String name, Employee director) {
        this.name = name;
        this.director = new Employee(director.getFullName().split(" ")[0], director.getFullName().split(" ")[1], director.getSalary(), null);
        this.departments = new ArrayList<>();
    }

    // Метод для додавання відділу до компанії
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Метод для отримання списку всіх працівників, включаючи директора і начальників
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(director);

        // Додаємо менеджерів та працівників усіх відділів до списку
        for (Department dept : departments) {
            allEmployees.add(dept.getManager());
            allEmployees.addAll(dept.getEmployees());
        }
        return allEmployees;
    }

    // Метод для отримання списку всіх відділів
    public List<Department> getDepartments() {
        return departments;
    }
}

public class CompanyManagement {

    // Завдання 1: Знайти максимальну заробітну плату серед усіх працівників
    // Метод обходу: c) Типізований цикл for-each
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
    // Метод обходу: b) Типізований ітератор
    public static List<String> findDepartmentsWithHigherPaidEmployees(Company company) {
        List<String> result = new ArrayList<>();

        // b) Типізований ітератор
        for (Department department : company.getDepartments()) {
            Employee manager = department.getManager();
            Iterator<Employee> employeesIterator = department.getEmployees().iterator();

            while (employeesIterator.hasNext()) {
                Employee employee = employeesIterator.next();
                if (employee.getSalary() > manager.getSalary()) {
                    result.add(department.getName());
                    break; // Переходимо до наступного відділу після знаходження такого працівника
                }
            }
        }

        return result;
    }

    // Завдання 3: Вивести інформацію про всіх працівників компанії
    // Метод обходу: a) Нетипізований ітератор
    public static void printAllEmployees(Company company) {
        // a) Нетипізований ітератор
        Iterator employeesIterator = company.getAllEmployees().iterator();

        while (employeesIterator.hasNext()) {
            Employee employee = (Employee) employeesIterator.next();
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        // Створення директора компанії
        Employee director = new Employee("Іван", "Іванов", 5000);
        Company company = new Company("TechCorp", director);

        // Створення першого відділу і його працівників
        Employee manager1 = new Employee("Петро", "Петров", 4000);
        Department dept1 = new Department("IT", manager1);
        dept1.addEmployee(new Employee("Анна", "Смірнова", 4500)); // Працівник із більшою зарплатою, ніж у начальника
        dept1.addEmployee(new Employee("Олег", "Орлов", 3000));

        // Створення другого відділу і його працівників
        Employee manager2 = new Employee("Марія", "Коваль", 3500);
        Department dept2 = new Department("HR", manager2);
        dept2.addEmployee(new Employee("Олена", "Новікова", 3200));
        dept2.addEmployee(new Employee("Дмитро", "Бондаренко", 3600));

        // Додавання відділів до компанії
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        // Виклик завдань
        System.out.println("Максимальна зарплата: " + findMaxSalary(company));
        System.out.println("Відділи з працівниками, що отримують більше за начальника: " + findDepartmentsWithHigherPaidEmployees(company));
        printAllEmployees(company);
    }
}

