//package za.co.wethinkcode;
//
//import org.junit.jupiter.api.Test;
//import za.co.wethinkcode.model.Submission;
//import za.co.wethinkcode.model.Student;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SubmissionTest {
//
//    @Test
//    void testSubmissionCreation() {
//        Student student =
//                new Student(1, "John");
//
//        Submission submission =
//                new Submission(101,
//                        student,
//                        "Java Basics");
//
//        assertEquals(101,
//                submission.getSubmissionId());
//
//        assertEquals(student,
//                submission.getStudent());
//
//        assertEquals("Java Basics",
//                submission.getAssignmentTitle());
//
//        assertFalse(
//                submission.isProcessed());
//    }
//
//    @Test
//    void testMarkProcessed() {
//        Student student =
//                new Student(1, "Sarah");
//
//        Submission submission =
//                new Submission(102,
//                        student,
//                        "Databases");
//
//        submission.markProcessed();
//
//        assertTrue(
//                submission.isProcessed());
//    }
//
//    @Test
//    void testStudentReferenceStored() {
//        Student student =
//                new Student(5, "Nova");
//
//        Submission submission =
//                new Submission(103,
//                        student,
//                        "Algorithms");
//
//        assertEquals("Nova",
//                submission.getStudent().getName());
//    }
//
//    @Test
//    void testDifferentSubmissionsIndependent() {
//        Student student1 =
//                new Student(1, "John");
//
//        Student student2 =
//                new Student(2, "Sarah");
//
//        Submission submission1 =
//                new Submission(201,
//                        student1,
//                        "Java");
//
//        Submission submission2 =
//                new Submission(202,
//                        student2,
//                        "SQL");
//
//        assertNotEquals(
//                submission1.getSubmissionId(),
//                submission2.getSubmissionId());
//
//        assertNotEquals(
//                submission1.getStudent(),
//                submission2.getStudent());
//    }
//
//    @Test
//    void testToString() {
//        Student student =
//                new Student(1, "Emma");
//
//        Submission submission =
//                new Submission(301,
//                        student,
//                        "Web Development");
//
//        String output =
//                submission.toString();
//
//        assertTrue(output.contains("301"));
//        assertTrue(output.contains("Emma"));
//        assertTrue(output.contains("Web Development"));
//    }
//
//    @Test
//    void testInitiallyNotProcessed() {
//        Student student =
//                new Student(1, "Kai");
//
//        Submission submission =
//                new Submission(401,
//                        student,
//                        "Testing");
//
//        assertFalse(
//                submission.isProcessed());
//    }
//
//    @Test
//    void testProcessedStateRemainsTrue() {
//        Student student =
//                new Student(1, "Luna");
//
//        Submission submission =
//                new Submission(501,
//                        student,
//                        "OOP");
//
//        submission.markProcessed();
//        submission.markProcessed();
//
//        assertTrue(
//                submission.isProcessed());
//    }
//}