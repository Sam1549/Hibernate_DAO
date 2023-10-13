package com.example.hibernate_dao.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Person {

    @EmbeddedId
    private PersonalData personalData;

    @Column
    private String phoneOfNumber;

    @Column
    private String cityOfLiving;


}
