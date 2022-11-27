package com.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Middle {
    @Id
    @GeneratedValue
    private int id;

    private String facebook;
    private String twitter;
    private String name;
    private String logo;
    private String icon;
    private String empoyees;
    private String address;
}
