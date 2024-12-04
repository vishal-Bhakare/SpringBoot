package org.example.repository;

import org.example.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Student student) {
        String sql = "INSERT INTO students (name, ,course, grade) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getCourse(), student.getGrade());
    }

    public List<Student> getAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    public int update(Student student) {
        String sql = "UPDATE students SET name = ?, course = ?, grade = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getCourse(), student.getGrade(), student.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("course"),
                rs.getString("grade")
        );
    }
}
