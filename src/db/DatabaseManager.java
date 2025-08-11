package db;

import models.Patient;
import models.Doctor;
import models.Appointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASSWORD = "euzghe_77";

    // Veritabanına bağlan
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Hasta ekleme
    public static void insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (first_name, last_name, national_id, birth_date, phone, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getLastName());
            stmt.setString(3, patient.getNationalId());
            stmt.setString(4, patient.getBirthDate());
            stmt.setString(5, patient.getPhone());
            stmt.setString(6, patient.getEmail());

            stmt.executeUpdate();
            System.out.println("✅ Hasta başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Doktor ekleme
    public static void insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, specialization, department_id, phone, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getLastName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.setInt(4, doctor.getDepartmentId());
            stmt.setString(5, doctor.getPhone());
            stmt.setString(6, doctor.getEmail());

            stmt.executeUpdate();
            System.out.println("✅ Doktor başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Randevu ekleme
    public static void insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(3, appointment.getAppointmentDate());
            stmt.setString(4, appointment.getStatus());

            stmt.executeUpdate();
            System.out.println("✅ Randevu başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
