package za.co.wethinkcode;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.model.Assignment;
import za.co.wethinkcode.model.Submission;

import static org.junit.jupiter.api.Assertions.*;

public class AssignmentTest {

    @Test
    void testAssignmentCreation() {
        Assignment assignment = new Assignment(1, "OOP Project", 100);

        assertEquals(1, assignment.getAssignmentId());
        assertEquals("OOP Project", assignment.getTitle());
        assertEquals(100, assignment.getTotalMarks());
    }

    @Test
    void testInvalidNegativeMarks() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Assignment(1, "Database Project", -10);
        });
    }

    @Test
    void testInvalidMarksAboveHundred() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Assignment(1, "Networking Task", 120);
        });
    }

    @Test
    void testAddSubmission() {
        Assignment assignment = new Assignment(1, "Java Task", 100);

        Submission submission =
                new Submission(1, 10, 1, 85);

        assignment.addSubmission(submission);

        assertEquals(1, assignment.getSubmissionCount());
    }

    @Test
    void testMultipleSubmissions() {
        Assignment assignment = new Assignment(1, "Algorithms", 100);

        assignment.addSubmission(
                new Submission(1, 10, 1, 80));

        assignment.addSubmission(
                new Submission(2, 11, 1, 90));

        assertEquals(2, assignment.getSubmissionCount());
    }

    @Test
    void testGetSubmissionsDefensiveCopy() {
        Assignment assignment = new Assignment(1, "Security", 100);

        assignment.addSubmission(
                new Submission(1, 10, 1, 75));

        var submissions = assignment.getSubmissions();

        submissions.clear();

        assertEquals(1, assignment.getSubmissionCount());
    }

    @Test
    void testSubmissionCreation() {
        Submission submission =
                new Submission(1, 20, 5, 88);

        assertEquals(1, submission.getSubmissionId());
        assertEquals(20, submission.getStudentId());
        assertEquals(5, submission.getAssignmentId());
        assertEquals(88, submission.getMarksAwarded());
    }

    @Test
    void testUpdateSubmissionMarks() {
        Submission submission =
                new Submission(1, 20, 5, 70);

        submission.updateMarks(95);

        assertEquals(95, submission.getMarksAwarded());
    }

    @Test
    void testInvalidNegativeSubmissionMarks() {
        Submission submission =
                new Submission(1, 20, 5, 70);

        assertThrows(IllegalArgumentException.class, () -> {
            submission.updateMarks(-5);
        });
    }

    @Test
    void testInvalidSubmissionMarksAboveHundred() {
        Submission submission =
                new Submission(1, 20, 5, 70);

        assertThrows(IllegalArgumentException.class, () -> {
            submission.updateMarks(120);
        });
    }
}