package za.co.wethinkcode.model;

import java.util.*;

public class Leaderboard {

    // TODO: declare private fields:
    // rankings (List<Student>)
    // studentLookup (HashMap<Integer, Student>)
    private List<Student> rankings;
    private HashMap<Integer, Student> studentLookup;

    // TODO: implement constructor:
    // Leaderboard()
    //
    // - initialise rankings as new ArrayList<>()
    // - initialise studentLookup as new HashMap<>()

    public Leaderboard() {
        this.rankings = new ArrayList<>();
        this.studentLookup = new HashMap<>();
    }


    // TODO: implement addStudent(Student student)
    // - add student to rankings
    // - add student to studentLookup
    // - call updateRankings()
    public void addStudent(Student student){

        this.rankings.add(student);
        this.studentLookup.put(student.getId(), student);
        updateRankings();
    }

    // TODO: implement getStudentById(int studentId)
    // - return student from HashMap
    // - return null if not found
    public Student getStudentById(int studentId){
         return this.studentLookup.getOrDefault(studentId, null);
    }

    // TODO: implement getTopStudent()
    // - return first student in rankings
    // - return null if rankings empty
    public Student getTopStudent(){
        if (this.rankings.isEmpty()) return null;
        return this.rankings.get(0);
    }

    // TODO: implement getRankings()
    // - return defensive copy
    public List<Student> getRankings() {
        return List.copyOf(this.rankings);
    }


    // TODO: implement updateRankings()
    //
    // Ranking Rules:
    // - highest GPA first
    // - if GPA ties, preserve insertion order
    //
    // Hint:
    // - use Comparator
    public void updateRankings() {
        this.rankings.sort(Comparator.comparingDouble(Student::getGpa).reversed());
    }

    // TODO: implement totalStudents()
    // - return number of students
    public int totalStudents(){
        return rankings.size();
    }

    // TODO: override toString()
    // Example:
    // Leaderboard:
    // 1. John - GPA 3.9
    // 2. Sarah - GPA 3.7
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Leaderboard:\n");
        for (int x = 0; x < rankings.size(); x++) {
            Student s = rankings.get(x);
            sb.append(x + 1).append(". ").append(s.getName()).append(" - GPA ").append(s.getGpa()).append("\n");
        }
        return sb.toString();
    }
}