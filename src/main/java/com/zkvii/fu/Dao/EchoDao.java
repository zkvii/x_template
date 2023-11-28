package com.zkvii.fu.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zkvii.fu.forms.TableForm;

import java.util.List;

@Mapper
public interface EchoDao {

    @Select("SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = 'dev'")
    List<String> getAllTables();
    @Select("SELECT COLUMN_NAME as columnName," +
            "COLUMN_TYPE as columnType," +
            "TABLE_NAME as tableName," +
            "COLUMN_COMMENT as columnComment," +
            "IS_NULLABLE as isNullable" +
            " FROM information_schema.columns WHERE table_name = #{tableName}")
    List<TableForm> getTableInfo(String tableName);

}