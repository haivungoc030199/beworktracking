package com.bework.beworktracking.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String fullName;
    private String avatar;
    private String role;
    private String email;
    private String userName;
    private long userId;
    private String departmentName;
    private String groupTitleName;
    private String titleName;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private  Long time;

}
