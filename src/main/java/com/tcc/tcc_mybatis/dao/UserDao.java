package com.tcc.tcc_mybatis.dao;
import com.tcc.tcc_mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper//将其声明为一个数据库接口
public interface UserDao {
    //@Results是结果映射表，@Result中property是User类的属性名，
    // colomn是数据库表的字段名
    //@Select、 @Insert 分别代表了执行的真实SQL
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
    })
    @Select("select * from user where age = #{age}")
    List<User> get(int age);

    @Insert("insert into user(name , age) values (#{name} , #{age})")
    void insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void  batchIndeleteUser(int id);

    @Update("UPDATE user SET name = #{name}, age = #{age} where id = #{id}")
    void batchInupdateUser(User user);

    @Select("select * from user where id = #{id}")
    List<User> batchInselectUser(int id);


}
