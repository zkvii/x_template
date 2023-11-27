package com.zkvii.fu.forms;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TableForm {
    private String tableName;
    private String tableComment;
    private String columnName;
    private String columnType;
    private String columnComment;
    private String columnKey;
    private String columnDefault;
    private String isNullable;
}
