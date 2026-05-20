package za.co.wethinkcode.model;

public class Submission {

    // TODO: declare private fields:
    // submissionId (int)
    // studentId (int)
    // assignmentId (int)
    // marksAwarded (int)
    private int submissionId;
    private int studentId;
    private int assignmentId;
    private int marksAwarded;

    // TODO: implement constructor:
    // Submission(int submissionId, int studentId, int assignmentId, int marksAwarded)
    //
    // Rules:
    // - marksAwarded cannot be negative
    // - marksAwarded cannot exceed 100

    public Submission(int submissionId, int studentId, int assignmentId, int marksAwarded) {
        this.submissionId = submissionId;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.marksAwarded = marksAwarded;
    }


    // TODO: implement getters:
    // int getSubmissionId()
    // int getStudentId()
    // int getAssignmentId()
    // int getMarksAwarded()

    public int getSubmissionId() {return this.submissionId;}

    public int getStudentId() {return this.studentId;}

    public int getAssignmentId() {return this.assignmentId;}

    public int getMarksAwarded() {return this.marksAwarded;}

    // TODO: implement updateMarks(int newMarks)
    //
    // Rules:
    // - throw IllegalArgumentException if newMarks < 0
    // - throw IllegalArgumentException if newMarks > 100
    // - otherwise update marksAwarded
    public void updateMarks(int newMarks){
        if (newMarks < 0 || newMarks > 100) throw new IllegalArgumentException();
        this.marksAwarded = newMarks;
    }

    // TODO: override toString()
    // Example:
    // Submission 1 | Student 10 | Assignment 5 | Marks: 85
    @Override
    public String toString(){
        return "Submission " + getSubmissionId() + "| Student " + getStudentId() +
                "| Assignment " + getAssignmentId() + "| Marks: " + getMarksAwarded();
    }
}