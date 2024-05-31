package com.example.Hib;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT")
public class Student {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MARK")
    private Integer mark;

    @Column(name = "NAME")
    private String name;


}
