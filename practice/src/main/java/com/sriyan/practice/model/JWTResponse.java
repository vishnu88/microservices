package com.sriyan.practice.model;

import lombok.*;

import java.security.Principal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JWTResponse {
    private  String jwtToken;
    private  String userName;
}
