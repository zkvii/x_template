package com.zkvii.fu.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zkvii.fu.Pojo.User;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM Users WHERE name = #{name}")
    User getUserByName(String name);

    @Select("SELECT * FROM Users")
    List<User> getAllUsers();

    @Insert("INSERT INTO Users (name, password, created_at, updated_at, privilege_level)" +
            "VALUES (#{name}, #{password}, #{created_at}, #{updated_at}, #{privelege_level})")
    void addUser(User user);

    @Update("UPDATE Users SET name = #{name}, password = #{password},created_at = #{created_at}," +
            "updated_at = #{updated_at}, privilege_level = #{privelege_level} WHERE name = #{name}")
    void updateUser(User user);

    @Update("DELETE FROM Users WHERE name = #{name}")
    void deleteUser(User user);
}
