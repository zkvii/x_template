package com.zkvii.fu.forms;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserPrivilege {
    private String name;
    private String password;
    private String created_at;
    private String updated_at;
    private String privilege_level;
    private String privilege_name;
}
