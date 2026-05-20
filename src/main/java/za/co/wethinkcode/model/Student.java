package za.co.wethinkcode.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    // TODO: declare private fields:
    // id (int)
    // name (String)
    // level (int)
    // gpa (double)
    // registeredCourses (List<Course>)
    // completedAssignments (List<Assignment>)
    private int id;
    private String name;
    private int level;
    private double gpa;
    private List<Course> registeredCourses;
    private List<Assignment> completedAssignments;

    // TODO: implement constructor:
    // Student(int id, String name)
    //
    // Initial values:
    // - level = 1
    // - gpa = 0.0
    // - registeredCourses = new ArrayList<>()
    // - completedAssignments = new ArrayList<>()

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.gpa = 0.0;
        this.level = 1;
        this.registeredCourses = new ArrayList<>();
        completedAssignments = new ArrayList<>();
    }


    // TODO: implement getters:
    // int getId()
    // String getName()
    // int getLevel()
    // double getGpa()

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public double getGpa() {
        return this.gpa;
    }


    // TODO: implement registerCourse(Course course)
    // - add course if not already registered
    public void registerCourse(Course course){
        boolean registered = false;
        for (Course c : registeredCourses){
            if (c.equals(course)){
                registered = true;
                break;
            }
        }
        if (!registered) registeredCourses.add(course);
    }

    // TODO: implement completeAssignment(Assignment assignment)
    // - add assignment to completedAssignments
    public void completeAssignment(Assignment assignment) {
        completedAssignments.add(assignment);
    }


    // TODO: implement updateGpa(double newGpa)
    // Rules:
    // - throw IllegalArgumentException if newGpa < 0
    // - throw IllegalArgumentException if newGpa > 4.0
    // - otherwise update GPA

    public void updateGpa(double newGpa){
        if (newGpa < 0 || newGpa > 4.0) throw new IllegalArgumentException();
        this.gpa = newGpa;
    }

    // TODO: implement levelUp()
    // - increase level by 1
    public void levelUp(){
        this.level++;
    }

    // TODO: implement getRegisteredCourses()
    // - return defensive copy
    public List<Course> getRegisteredCourses(){
        return List.copyOf(this.registeredCourses);
    }

    // TODO: implement getCompletedAssignments()
    // - return defensive copy
    public List<Assignment> getCompletedAssignments() {
        return List.copyOf(this.completedAssignments);
    }

    // TODO: override toString()
    // Example:
    // Student: John (Level 2, GPA 3.5)
    @Override
    public String toString(){
        return "Student: " + getName() + "(Level " + getLevel() + ", GPA " + getGpa() + ")";
    }
}



