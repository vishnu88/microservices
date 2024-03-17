package com.vishnu.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "HOTEL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Hotel {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "about")
    private String about;

}
