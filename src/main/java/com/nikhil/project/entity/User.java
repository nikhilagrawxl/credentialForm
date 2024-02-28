package com.nikhil.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    public enum Role {
        ADMIN,
        DEFAULT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="full_name")
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name="password")
    private String password;

    @Column(name="mobile_no")
    private String mobileNo;

    @Column(name="verify")
    private boolean verify;

    public User() {
    }

    public User(String fullName, Role role, String password, String mobileNo, boolean verify) {
        this.fullName = fullName;
        this.role = role;
        this.password = password;
        this.mobileNo = mobileNo;
        this.verify = verify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", verify=" + verify +
                '}';
    }
}
