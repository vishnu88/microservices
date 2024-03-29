package com.vishnu.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @Column(name = "ID")
   private String id;
    @Column(name = "CourseName")
    private String courseName;
    @Column
    private String discription;

}
