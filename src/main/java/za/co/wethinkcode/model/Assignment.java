package za.co.wethinkcode.model;

import java.util.ArrayList;
import java.util.List;

public class Assignment {

    // TODO: declare private fields:
    // assignmentId (int)
    // title (String)
    // totalMarks (int)
    // submissions (List<Submission>)
    private int assignmentId;
    private String title;
    private int totalMarks;
    private List<Submission> submissions;

    // TODO: implement constructor:
    // Assignment(int assignmentId, String title, int totalMarks)
    //
    // Rules:
    // - totalMarks cannot be negative
    // - totalMarks cannot exceed 100
    // - initialise submissions as new ArrayList<>()

    public Assignment(int assignmentId, String title, int totalMarks) {
        this.assignmentId = assignmentId;
        this.title = title;
        if (totalMarks < 0 || totalMarks > 100) throw new IllegalArgumentException();
        this.totalMarks = totalMarks;
        this.submissions = new ArrayList<>();
    }


    // TODO: implement getters:
    // int getAssignmentId()
    // String getTitle()
    // int getTotalMarks()
    public int getAssignmentId() {return this.assignmentId;}

    public String getTitle() {return this.title;}

    public int getTotalMarks() {return this.totalMarks;}


    // TODO: implement addSubmission(Submission submission)
    // - add submission to submissions list
    public void addSubmission(Submission sub){
        submissions.add(sub);
    }

    // TODO: implement getSubmissions()
    // - return defensive copy
    public List<Submission> getSubmissions() {
        return List.copyOf(this.submissions);
    }


    // TODO: implement getSubmissionCount()
    // - return number of submissions
    public int getSubmissionCount(){
        return this.submissions.size();
    }

    // TODO: override toString()
    // Example:
    // Assignment: OOP Project (100 Marks)
    @Override
    public String toString(){
        return getTitle() + "("+ getTotalMarks() + "Marks)" ;
    }
}