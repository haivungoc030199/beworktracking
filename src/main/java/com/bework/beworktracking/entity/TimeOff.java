package com.bework.beworktracking.entity;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeOff {

    private long id;

    private Timestamp timeoffDate;

    private Timestamp timeoffReason;

    private long isLeave;

    private long approvedBy;

    private String approveStatus;

    private String rejectReason;

    private long createdBy;

    private Timestamp createdAt;

}
