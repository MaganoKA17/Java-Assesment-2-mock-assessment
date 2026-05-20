package za.co.wethinkcode.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {

    // TODO: declare private fields:
    // courseCode (String)
    // courseName (String)
    // maxCapacity (int)
    // enrolledStudents (List<Student>)
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private List<Student> enrolledStudents;

    // TODO: implement constructor:
    // Course(String courseCode, String courseName, int maxCapacity)
    //
    // Rules:
    // - maxCapacity must be greater than 0
    // - initialise enrolledStudents as new ArrayList<>()

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        if (maxCapacity <= 0) throw new IllegalArgumentException();
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }


    // TODO: implement getters:
    // String getCourseCode()
    // String getCourseName()
    // int getMaxCapacity()

    public String getCourseCode() {return this.courseCode;}

    public String getCourseName() {return this.courseName;}

    public int getMaxCapacity() {return this.maxCapacity;}


    // TODO: implement enrolStudent(Student student)
    // - return false if course is full
    // - return false if student already enrolled
    // - otherwise add student and return true

    public boolean enrolStudent(Student student){
        if (enrolledStudents.size() >= maxCapacity) return false;

        for (Student s: enrolledStudents){
            if (s.getId() == student.getId()) return false;
        }
        enrolledStudents.add(student);
        return true;
    }

    // TODO: implement removeStudentById(int studentId)
    // - remove matching student
    // - return true if removed
    // - otherwise false
    public boolean removeStudentById(int id){
        for (Student s : this.enrolledStudents){
            if (s.getId() == id){
                this.enrolledStudents.remove(s);
                return true;
            }
        }
        return false;
    }

    // TODO: implement getEnrolledStudents()
    // - return defensive copy
    public List<Student> getEnrolledStudents(){
        return List.copyOf(this.enrolledStudents);
    }

    // TODO: implement getTotalStudents()
    // - return number of enrolled students
    public int getTotalStudents(){
        return this.enrolledStudents.size();
    }

    // TODO: implement hasStudent(String studentName)
    // - return true if student exists by name
    public boolean hasStudent(String n){
        for(Student s : this.enrolledStudents){
            if(s.getName().equals(n)) return true;
        }
        return false;
    }

    // TODO: override toString()
    // Example:
    // Course: CSC101 - Introduction to Programming
    @Override
    public String toString(){
        return getCourseCode() + "-" + getCourseName();
    }
}