package com.vishnu.userservice.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "micro_user")
public class User {
@Id
@Column(name = "ID")
private String userId;
    @Column(name = "NAME")
  private String name;
    @Column(name = "EMAIL" ,length =30)
  private String email;
    @Column(name = "ABOUT")
  private String about;
    @Column(name = "WEIGHT")
  private String weight;

  @Column(name = "COLOR")
  private String color;

  @Transient
private List<Rating> ratings;



}
