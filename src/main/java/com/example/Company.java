package com.example;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
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
    private String domain;
}
