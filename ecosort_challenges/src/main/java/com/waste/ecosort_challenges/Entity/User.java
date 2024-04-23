package com.waste.ecosort_challenges.Entity;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Name can not blank")
    private String userName;
    @Column(unique = true)
    private String email;
    private String Gender;
    @NotBlank
    @Size(min = 8, message = "The length of the password must be same")
    private String password;
    @NotBlank
    @Size(min = 8, message = "The password and conform password must same")
    private String conformPassword;
    @NotBlank
    @Size(min = 10, max = 10, message = "Enter the valid mobile number")
    private String mobileNo;
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConformPassword() {
        return conformPassword;
    }

    public void setConformPassword(String conformPassword) {
        this.conformPassword = conformPassword;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User() {
    }

    public User(Integer id, @NotBlank(message = "Name can not blank") String userName, @UniqueElements String email,
            String gender,
            @NotBlank @Size(min = 8, message = "The length of the password must be same") String password,
            @NotBlank @Size(min = 8, message = "The password and conform password must same") String conformPassword,
            @NotBlank @Size(min = 10, max = 10, message = "Enter the valid mobile number") String mobileNo,
            String location) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        Gender = gender;
        this.password = password;
        this.conformPassword = conformPassword;
        this.mobileNo = mobileNo;
        this.location = location;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", Gender=" + Gender + ", password="
                + password + ", conformPassword=" + conformPassword + ", mobileNo=" + mobileNo + ", location="
                + location
                + "]";
    }

}
