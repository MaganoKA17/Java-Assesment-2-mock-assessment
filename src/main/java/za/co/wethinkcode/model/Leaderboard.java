package za.co.wethinkcode.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Leaderboard {

    // TODO: declare private fields:
    // rankings (List<Student>)
    // studentLookup (HashMap<Integer, Student>)

    // TODO: implement constructor:
    // Leaderboard()
    //
    // - initialise rankings as new ArrayList<>()
    // - initialise studentLookup as new HashMap<>()

    // TODO: implement addStudent(Student student)
    // - add student to rankings
    // - add student to studentLookup
    // - call updateRankings()

    // TODO: implement getStudentById(int studentId)
    // - return student from HashMap
    // - return null if not found

    // TODO: implement getTopStudent()
    // - return first student in rankings
    // - return null if rankings empty

    // TODO: implement getRankings()
    // - return defensive copy

    // TODO: implement updateRankings()
    //
    // Ranking Rules:
    // - highest GPA first
    // - if GPA ties, preserve insertion order
    //
    // Hint:
    // - use Comparator

    // TODO: implement totalStudents()
    // - return number of students

    // TODO: override toString()
    // Example:
    // Leaderboard:
    // 1. John - GPA 3.9
    // 2. Sarah - GPA 3.7
}