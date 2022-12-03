package com.driver;

import ch.qos.logback.core.joran.action.AbstractEventEvaluatorAction;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Student st;
    Teacher t;
    Map<String,Student>studentMap = new HashMap<>();
    Map<String,Teacher>TeacherMap = new HashMap<>();
    Map<String,List<String>>studentTeacherPair = new HashMap<>();


    public void addStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        TeacherMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if(!studentMap.containsKey(teacher)){
            studentTeacherPair.put(teacher,new ArrayList<>());
        }
        studentTeacherPair.get(teacher).add(student);
    }
    public Student callStudentByName(String name) {
        return studentMap.get(name);
    }

    public Teacher callTeacherByName(String name) {
        return TeacherMap.get(name);
    }

    public List<String> callStudentByTeacherName(String teacher) {
        return studentTeacherPair.get(teacher);
    }

    public List<String> fetchAllStudentsName() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherByName(String teacher) {

        for (String sn : studentTeacherPair.get(teacher)) {
            studentMap.remove(sn);
        }
        TeacherMap.remove(teacher);
        studentTeacherPair.remove(teacher);
    }
    public void deleteAllTeachers() {
        for(String t : studentTeacherPair.keySet()) {
            for(String s : studentTeacherPair.get(t)) {
                studentMap.remove(s);
            }
        }
        TeacherMap = new HashMap<>();
        studentTeacherPair.clear();
    }
}
