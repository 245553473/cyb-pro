package com.qwwaq.cyb.service.mapper;


import com.qwwaq.cyb.entity.Article;
import com.qwwaq.cyb.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account,password) values (#{name},#{account},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insertUser(User user);

    @Select("select id from user where account=#{account}")
    @ResultType(Integer.class)
    Integer queryIdByAccount(@Param("account")String account);

    @Select("select name  from user where id =#{id}")
    @ResultType(String.class)
    String queryNameById(@Param("id")Integer id);

    @Select("select image_address  from user where id =#{id}")
    @ResultType(String.class)
    String queryImageById(@Param("id")Integer id);


    @Select("select id,name,account,password,introduction,image_address from user where id =#{id}")
    @Results(id = "userMap",value = {
            @Result(column = "id",property = "id",jdbcType = JdbcType.INTEGER,javaType = Integer.class),
            @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "account",property = "account",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "password",property = "password",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "introduction",property = "introduction",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "image_address",property = "imageAddress",jdbcType = JdbcType.VARCHAR,javaType = String.class)
    })
    User queryUser(@Param("id") Integer id);

    @Select("select id,name,introduction,image_address from user where id =#{id}")
    @Results(id = "simpleUserMap",value = {
            @Result(column = "id",property = "id",jdbcType = JdbcType.INTEGER,javaType = Integer.class),
            @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "introduction",property = "introduction",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "image_address",property = "imageAddress",jdbcType = JdbcType.VARCHAR,javaType = String.class)
    })
    User querySimpleUserInfo(@Param("id") Integer id);

    @Select("select id,name,account,introduction,image_address from user  where account =#{account}")
    @Results(id = "simpleUserInfo",value = {
            @Result(column = "id",property = "id",jdbcType = JdbcType.INTEGER,javaType = Integer.class),
            @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "account",property = "account",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "introduction",property = "introduction",jdbcType = JdbcType.VARCHAR,javaType = String.class),
            @Result(column = "image_address",property = "imageAddress",jdbcType = JdbcType.VARCHAR,javaType = String.class)
    })
    User queryUserByAccount(@Param("account") String account);

    @Select("select id,name,account,introduction,image_address from user  where id =#{id}")
    @ResultMap("simpleUserInfo")
    User querySimpleUserInfoWithId(@Param("id") Integer id);


    @Select("select password from user where account =#{account}")
    @ResultType(String.class)
    String queryPasswordByAccount(@Param("account") String account);

    @Update("update user set password =#{password} where id =#{id}")
    Integer updatePassword(@Param("id") Integer id,@Param("password")String password);

    @UpdateProvider(type = MapperGenerator.class,method = "updateUserString")
    @ResultType(Integer.class)
    Integer updateUser(User user);

    @Update("update user set name=#{name},introduction=#{introduction},image_address=#{imageAddress} where id= #{id}")
    Integer updateInfo(User user);

    @Delete("delete from user where id =#{id}")
    Integer removeUser(@Param("id") Integer id);
}