package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void putStudent(Student student) {
        studentRepository.addStudent(student);
    }
    public void putTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }
    public void putStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByitsname(String name) {
        return studentRepository.callStudentByName(name);
    }

    public Teacher getTeacherByitsname(String name) {
        return studentRepository.callTeacherByName(name);
    }

    public List<String> getStudentbyitsTeachername(String teacher) {
        return studentRepository.callStudentByTeacherName(teacher);
    }

    public List<String> getAllStudentsName() {
        return studentRepository.fetchAllStudentsName();
    }

    public void removeTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllteacher() {
        studentRepository.deleteAllTeachers();
    }



}
