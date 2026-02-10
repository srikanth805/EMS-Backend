package com.javaguides.ems.dto;

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    // No-arg constructor
    public EmployeeDto() {
    }

    // All-args constructor
    public EmployeeDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

//we use this class for to transfer the data between client and the server
//response for restapi is employeedto
//employeemapper class to map employeedto to entity and vice versa
//if we build the restAPI than we have to convert the employee dto to entity class and vice versa
