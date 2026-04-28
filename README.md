# UC-006: Employee Payroll System

## Problem Statement
Design and implement a robust Employee Payroll System to manage employee records, compute complex salary structures (Basic, HRA, PF, ESI, TDS), and handle payroll lifecycles including HR selection and Finance Officer approval.

## Approach & Logic
The solution follows Object-Oriented Programming (OOP) principles to ensure modularity and scalability:
* **Encapsulation:** Used an abstract `Employee` class to protect sensitive salary data while allowing extensions for different worker types.
* **Role-Based Workflow:** Implemented `HRManager` for period selection and `FinanceOfficer` for approval, mimicking a real-world corporate hierarchy.
* **Salary Computation Model:**
    * Basic = 50% of CTC
    * HRA = 40% of Basic
    * PF = 12% of Basic | ESI = 0.75% of Gross
* **Exception Handling:** Logic includes placeholders for handling missing bank details (E1) and duplicate processing (E3).

## Steps to Execute
1.  **Requirement:** Ensure Java Development Kit (JDK) 8 or higher is installed.
2.  **Clone the Repo:** `git clone https://github.com/[Your-Username]/Employee-Payroll-System.git`
3.  **Compile:**
    `javac Main.java`
4.  **Run:**
    `java Main`
5.  **Input:** Follow the console prompts to enter Employee ID, Name, and CTC.
