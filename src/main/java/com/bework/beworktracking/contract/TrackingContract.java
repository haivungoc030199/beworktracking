package com.bework.beworktracking.contract;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TrackingContract {

    private long userId;

    private String username;

    private String fullName;

    private String avatar;


}
