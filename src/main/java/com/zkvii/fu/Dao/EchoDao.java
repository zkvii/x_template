package com.zkvii.fu.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zkvii.fu.forms.TableForm;

@Mapper
public interface EchoDao {

    @Select("SELECT (column_name as columnName , data_type as columnType) FROM "+
    "information_schema.columns WHERE table_name = #{tableName}")
    TableForm getTableInfo(String tableName);
}