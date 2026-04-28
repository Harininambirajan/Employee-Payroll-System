import java.util.*;

abstract class Employee {
    protected int empid;
    protected String empname;
    protected float empsalary;
    protected boolean ispaid;

    public Employee(int id, String name, float salary) {
        this.empid = id;
        this.empname = name;
        this.empsalary = salary;
        this.ispaid = false;
    }

    public abstract void displayInfo();

    public boolean isPaid() { return ispaid; }
    public void setPaid(boolean paid) { ispaid = paid; }

    public float calculateNetSalary() {
        float basic = 0.5f * empsalary;
        float hra = 0.4f * basic;
        float allowance = empsalary - basic - hra;
        float pf = 0.12f * basic;
        float esi = 0.0075f * empsalary;
        return empsalary - (pf + esi);
    }

    public int getEmpid() { return empid; }
    public String getEmpname() { return empname; }
}

class Worker extends Employee {
    public Worker(int id, String name, float salary) {
        super(id, name, salary);
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println("Employee ID: " + empid);
        System.out.println("Employee Name: " + empname);
        System.out.println("Salary: " + calculateNetSalary());
        System.out.println("Paid: " + ispaid);
    }
}

class HRManager {
    protected int hrid;
    protected String hrname;
    protected boolean isPeriodSelected;

    public HRManager(int id, String name) {
        this.hrid = id;
        this.hrname = name;
        this.isPeriodSelected = false;
    }

    public void selectPeriod(Employee e) {
        isPeriodSelected=true;
        System.out.println(hrid + " " + hrname + " selected payroll period for employee " + e.getEmpid() + " " + e.getEmpname());
    }
}

class FinanceOfficer {
    protected int fid;
    protected String fname;
    protected boolean isApproved;

    public FinanceOfficer(int id, String name) {
        this.fid = id;
        this.fname = name;
        this.isApproved = false;
    }

    public void approvePayment(Employee e) {
        isApproved = true;
        e.setPaid(true);
        float netSalary = e.calculateNetSalary();
        System.out.println(fid + " " + fname + " approved salary transfer of " + netSalary + " to " + e.getEmpid() + " " + e.getEmpname());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees to payroll: ");
        int n = sc.nextInt();

        HRManager hr = new HRManager(201, "Priya");
        FinanceOfficer fo = new FinanceOfficer(301, "Nambirajan");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Employee Salary: ");
            float salary = sc.nextFloat();

            Employee e = new Worker(id, name, salary);

            hr.selectPeriod(e);
            fo.approvePayment(e);

            e.displayInfo();
        }
    }
}
