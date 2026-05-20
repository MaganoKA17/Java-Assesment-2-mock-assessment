//package za.co.wethinkcode;
//
//import org.junit.jupiter.api.Test;
//import za.co.wethinkcode.model.Classroom;
//import za.co.wethinkcode.model.Student;
//import za.co.wethinkcode.service.CampusAcademySystem;
//import za.co.wethinkcode.service.OnlineAcademySystem;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AcademySystemTest {
//
//    @Test
//    void testAddStudent() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student student = new Student(1, "John");
//
//        academy.addStudent(student);
//
//        assertEquals(1, academy.getAllStudents().size());
//    }
//
//    @Test
//    void testGetStudentById() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student student = new Student(1, "Sarah");
//
//        academy.addStudent(student);
//
//        Student found = academy.getStudentById(1);
//
//        assertNotNull(found);
//        assertEquals("Sarah", found.getName());
//    }
//
//    @Test
//    void testGetStudentNotFound() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student found = academy.getStudentById(999);
//
//        assertNull(found);
//    }
//
//    @Test
//    void testRemoveStudentById() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student student = new Student(1, "Nova");
//
//        academy.addStudent(student);
//
//        boolean removed =
//                academy.removeStudentById(1);
//
//        assertTrue(removed);
//        assertEquals(0, academy.getAllStudents().size());
//    }
//
//    @Test
//    void testRemoveStudentNotFound() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        boolean removed =
//                academy.removeStudentById(999);
//
//        assertFalse(removed);
//    }
//
//    @Test
//    void testGetAllStudentsUnmodifiable() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        academy.addStudent(new Student(1, "Kai"));
//
//        assertThrows(UnsupportedOperationException.class, () -> {
//            academy.getAllStudents().clear();
//        });
//    }
//
//    @Test
//    void testEnqueueRegistration() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student student = new Student(1, "Milo");
//
//        academy.enqueueRegistration(student);
//
//        Student processed =
//                academy.processNextRegistration();
//
//        assertNotNull(processed);
//        assertEquals("Milo", processed.getName());
//    }
//
//    @Test
//    void testProcessNextRegistrationEmptyQueue() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student processed =
//                academy.processNextRegistration();
//
//        assertNull(processed);
//    }
//
//    @Test
//    void testAssignClassroom() {
//        CampusAcademySystem academy =
//                new CampusAcademySystem("WTC Campus");
//
//        Student student = new Student(1, "Emma");
//
//        Classroom classroom =
//                new Classroom("A12", 40);
//
//        academy.assignClassroom(student, classroom);
//
//        assertEquals(classroom,
//                academy.getClassroom(student));
//    }
//
//    @Test
//    void testReverseClassroomLookup() {
//        CampusAcademySystem academy =
//                new CampusAcademySystem("WTC Campus");
//
//        Student student = new Student(1, "Alex");
//
//        Classroom classroom =
//                new Classroom("B10", 30);
//
//        academy.assignClassroom(student, classroom);
//
//        assertEquals(student,
//                academy.getStudent(classroom));
//    }
//
//    @Test
//    void testAcademyName() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("Code Academy");
//
//        assertEquals("Code Academy",
//                academy.academyName());
//    }
//
//    @Test
//    void testMultipleStudents() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        academy.addStudent(new Student(1, "John"));
//        academy.addStudent(new Student(2, "Sarah"));
//        academy.addStudent(new Student(3, "Kai"));
//
//        assertEquals(3,
//                academy.getAllStudents().size());
//    }
//
//    @Test
//    void testQueueProcessesInOrder() {
//        OnlineAcademySystem academy =
//                new OnlineAcademySystem("WeThinkCode");
//
//        Student student1 = new Student(1, "John");
//        Student student2 = new Student(2, "Sarah");
//
//        academy.enqueueRegistration(student1);
//        academy.enqueueRegistration(student2);
//
//        Student processed1 =
//                academy.processNextRegistration();
//
//        Student processed2 =
//                academy.processNextRegistration();
//
//        assertEquals("John", processed1.getName());
//        assertEquals("Sarah", processed2.getName());
//    }
//}