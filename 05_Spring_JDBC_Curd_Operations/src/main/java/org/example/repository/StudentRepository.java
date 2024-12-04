package org.example.repository;

import org.example.Entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentRepository {

    private JdbcTemplate template;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public String saveStudent(Student stu) {
        String query = "Insert into students(name, email,course, age) values (?, ?, ?, ?)";
        template.update(query, stu.getName(), stu.getEmail(), stu.getCourse(), stu.getAge());
        return "Student Saved successfully";
    }

    public List<Student> getAllStudents() {
        String query = "SELECT * FROM students";
        return template.query(query, studentRowMapper());
    }

    // Retrieve a student by ID
    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        return template.queryForObject(query, new Object[]{id}, studentRowMapper());
    }

    public String updateStudentById(int id, Student updatedStudent) {
        String sql = "UPDATE students SET name = ?, email = ?, course = ?, age = ? WHERE id = ?";
        int rows = template.update(sql, updatedStudent.getName(), updatedStudent.getEmail(),
                updatedStudent.getCourse(), updatedStudent.getAge(), id);
        return rows > 0 ? "Student updated successfully!" : "Student not found!";
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        template.update(query, id);
    }


    public String deleteAllStudents() {
        String sql = "DELETE FROM students";
        int rows = template.update(sql);
        return rows > 0 ? "All students deleted successfully!" : "No students found to delete.";
    }

    private RowMapper<Student> studentRowMapper() {
        return (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setCourse(rs.getString("course"), 1);
            student.setAge(rs.getInt("age"));
            return student;
        };
    }


}
