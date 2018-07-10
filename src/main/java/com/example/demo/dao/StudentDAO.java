package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentDAO {

    @Select(value = "SELECT * FROM student")
    List<Student> getAllStudent();

    @Insert(value = "INSERT INTO student(student.`name`,student.`no`,student.score)\n" +
            "VALUE(#{name},#{no},#{score})")
    int insert(Student student);

    @Update(value = "UPDATE student SET student.score = #{score} WHERE student.id = #{id}")
    int update(
            @Param("id") Integer id,
           @Param("score") Double score);

}
