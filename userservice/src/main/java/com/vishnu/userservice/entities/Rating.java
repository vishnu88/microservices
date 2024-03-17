package com.vishnu.userservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private String userId;
    private String hotelId;
    private String ratingId;
    private int rating;
    private String remark;

    private Hotel hotel;
}
