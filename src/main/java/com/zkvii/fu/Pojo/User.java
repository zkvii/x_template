package com.zkvii.fu.Pojo;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class User {

    private String name;
    private String password;
    private LocalDate created_at;
    private LocalDate updated_at;
    private long privelege_level;
    
}
