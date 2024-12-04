package com.example.repository;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Student student) {
        String sql = "INSERT INTO students (id, name, course, grade) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getCourse(), student.getGrade());
    }


    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToStudent);
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, this::mapRowToStudent);
    }


    public int update(Student student) {
        String sql = "UPDATE students SET name = ?, course = ?, grade = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getCourse(), student.getGrade(), student.getId());
    }


    public int deleteById(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setCourse(rs.getString("course"));
        student.setGrade(rs.getString("grade"));
        return student;
    }
}

