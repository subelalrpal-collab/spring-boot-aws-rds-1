package com.example.spring_boot_aws_rds.repository;

import com.example.spring_boot_aws_rds.dtos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudents(){
        String sql ="select id, name from student";
        RowMapper<Student> rowMapper = new DataClassRowMapper<>(Student.class);
        List<Student> studentList = jdbcTemplate.query(sql, rowMapper);
        return studentList;
    }

    public int saveStudent(int id, String name) {
        String sql = "insert into student(id, name) values(?,?)";
        int rowNumber = jdbcTemplate.update(sql, id, name);
        return rowNumber;
    }

}
