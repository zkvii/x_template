package com.zkvii.fu.forms;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@ToString
public class TableForm {
    private String tableName;
    private String columnName;
    private String columnType;
    private String columnComment;
    private boolean isNullable;
}
