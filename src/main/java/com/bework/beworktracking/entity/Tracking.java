package com.bework.beworktracking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Tracking {

    private long id;
    private long userId;
    private String username;
    private String fullName;
    private String avatar;


    private java.sql.Timestamp startTimeFirstShift;

    private java.sql.Timestamp endTimeFirstShift;

    private java.sql.Timestamp startTimeSecondShift;

    private java.sql.Timestamp endTimeSecondShift;


}



