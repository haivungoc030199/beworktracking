package com.bework.beworktracking.entity;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Overtime {

    private long id;

    private long userId;

    private String usernamme;

    private String fullName;

    private long overtime_amount;

    private Timestamp overtimeAt;

    private long createdBy;

    private Timestamp created_At;


}
