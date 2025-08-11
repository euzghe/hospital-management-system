import db.DatabaseManager;
import models.Patient;
import models.Doctor;
import models.Appointment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- HASTANE YÖNETİM SİSTEMİ ---");
            System.out.println("1. Hasta Ekle");
            System.out.println("2. Doktor Ekle");
            System.out.println("3. Randevu Oluştur");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // dummy

            switch (choice) {
                case 1:
                    System.out.print("Ad: ");
                    String pName = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String pSurname = scanner.nextLine();
                    System.out.print("TC No: ");
                    String pTC = scanner.nextLine();
                    System.out.print("Doğum Tarihi (yyyy-mm-dd): ");
                    String pBirth = scanner.nextLine();
                    System.out.print("Telefon: ");
                    String pPhone = scanner.nextLine();
                    System.out.print("Email: ");
                    String pEmail = scanner.nextLine();

                    Patient patient = new Patient(0, pName, pSurname, pTC, pBirth, pPhone, pEmail);
                    DatabaseManager.insertPatient(patient);
                    break;

                case 2:
                    System.out.print("Ad: ");
                    String dName = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String dSurname = scanner.nextLine();
                    System.out.print("Uzmanlık: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Bölüm ID: ");
                    int departmentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Telefon: ");
                    String dPhone = scanner.nextLine();
                    System.out.print("Email: ");
                    String dEmail = scanner.nextLine();

                    Doctor doctor = new Doctor(0, dName, dSurname, specialization, departmentId, dPhone, dEmail);
                    DatabaseManager.insertDoctor(doctor);
                    break;

                case 3:
                    System.out.print("Hasta ID: ");
                    int patientId = scanner.nextInt();

                    System.out.print("Doktor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine(); // dummy
                    System.out.print("Randevu Tarihi (yyyy-mm-dd hh:mm:ss): ");
                    String date = scanner.nextLine();

                    Appointment appointment = new Appointment(0, patientId, doctorId, date, "active");
                    DatabaseManager.insertAppointment(appointment);
                    break;

                case 4:
                    running = false;
                    System.out.println("Çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }

        scanner.close();
    }
}
