package entities;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private String Mail;
    private LocalDate onDate;

    private GENDER Gender;

    public Customer() {

    }

    public enum GENDER {
        MALE,
        FEMALE,
    }

    public Customer(int id, String name, String mail, LocalDate onDate, GENDER gender) {
        this.id = id;
        this.name = name;
        Mail = mail;
        this.onDate = onDate;
        Gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return Gender;
    }

    public void setGender(GENDER gender) {
        Gender = gender;
    }
}
