/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author ASUS
 */
public class GetSet_Edit_Profile {
    String username,Email,MobileNO,Location,FilePath;

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }
    byte[] Profilepicture;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobileNO() {
        return MobileNO;
    }

    public void setMobileNO(String MobileNO) {
        this.MobileNO = MobileNO;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public byte[] getProfilepicture() {
        return Profilepicture;
    }

    public void setProfilepicture(byte[] Profilepicture) {
        this.Profilepicture = Profilepicture;
    }
    
}
