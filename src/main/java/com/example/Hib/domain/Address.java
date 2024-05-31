package com.example.Hib.domain;

import jakarta.persistence.*;

@Entity
public class Address {

    /*
user_id int PK
address_line_1 varchar(200)
address_line_2 varchar(200)
city varchar(100)
region varchar(100)
country varchar(100)
zip_code varchar(15)
     */

    private Long userId;
    private User user;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String region;
    private String country;
    private String zipCode;


    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @OneToOne
    @MapsId // foreign key
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(length = 100)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
