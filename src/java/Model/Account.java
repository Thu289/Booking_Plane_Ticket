/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
public class Account {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String role;
    private boolean status;
    private String note;
    private boolean gender;
    private String dob;
    private String name_supplier;

    public Account() {
    }

    public Account(String username, String password, String phone, String email, String address, String role, boolean status, String note, boolean gender, String dob) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.status = status;
        this.note = note;
        this.gender=gender;
        this.dob=dob;
    }

    public Account(int id, String username, String password, String phone, String email, String address, String role, boolean status, String note, boolean gender, String dob) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.status = status;
        this.note = note;
        this.gender = gender;
        this.dob = dob;
    }

    public Account(int id, String username, String password, String phone, String email, String address, String role, boolean status, String note, boolean gender, String dob, String name_supplier) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.status = status;
        this.note = note;
        this.gender = gender;
        this.dob = dob;
        this.name_supplier = name_supplier;
    }

    public Account(int id, String username, String phone, String email, String address, boolean gender, String dob) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public Account(int id, String username, String phone, String email, String address, boolean gender) {
        this.id=id;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

 

    public String getName_supplier() {
        return name_supplier;
    }

    public void setName_supplier(String name_supplier) {
        this.name_supplier = name_supplier;
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public boolean isStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public String getDob() {
        return dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    
    
    
}
