package com.vishnu.userservice.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponse {
    private   String httpStatus;
    private   String message;
    private   boolean status;

}
