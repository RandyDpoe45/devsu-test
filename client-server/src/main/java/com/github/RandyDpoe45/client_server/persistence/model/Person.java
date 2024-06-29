package com.github.RandyDpoe45.client_server.persistence.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String firstName;

    protected Integer age;

    protected String identification;

    protected String address;

    protected String telephoneNumber;

    public Person(String firstName, Integer age, String identification, String address, String telephoneNumber) {
        this.firstName = firstName;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
}
