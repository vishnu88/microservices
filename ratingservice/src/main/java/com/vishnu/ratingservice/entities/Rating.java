package com.vishnu.ratingservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Rating")
public class Rating {
    @Id
    private String id;

    private String hotelId;


    private String userId;
    private int rating;
    private String remark;
}
