import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!\n");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.\n");
            return;
        }
        for (Patient p : patients) {
            p.display();
        }
        System.out.println();
    }

    public static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                p.display();
                return;
            }
        }
        System.out.println("Patient not found.\n");
    }

    public static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();

        doctors.add(new Doctor(id, name, spec));
        System.out.println("Doctor added successfully!\n");
    }

    public static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.\n");
            return;
        }
        for (Doctor d : doctors) {
            d.display();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. View Doctors");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> searchPatient();
                case 4 -> addDoctor();
                case 5 -> viewDoctors();
                case 6 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!\n");
            }
        }
    }
}