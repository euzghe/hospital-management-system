package models;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String birthDate;
    private String phone;
    private String email;

    // Constructor
    public Patient(int id, String firstName, String lastName, String nationalId, String birthDate, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    // GETTERS
    public int getId() { return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getNationalId() { return nationalId; }

    public String getBirthDate() { return birthDate; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    // SETTERS
    public void setId(int id) { this.id = id; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setEmail(String email) { this.email = email; }
}
