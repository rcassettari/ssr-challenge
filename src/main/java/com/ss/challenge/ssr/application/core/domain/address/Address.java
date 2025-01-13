package com.ss.challenge.ssr.application.core.domain.address;

public class Address {

    private String streetType;

    private String street;

    private String city;

    private String state;

    private String cep;

    public Address() {
    }

    public Address(String streetType, String street, String city, String state, String cep) {
        this.streetType = streetType;
        this.street = street;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
