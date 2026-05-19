package za.co.wethinkcode;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.model.Course;
import za.co.wethinkcode.model.Student;
import za.co.wethinkcode.service.CampusAcademySystem;
import za.co.wethinkcode.service.OnlineAcademySystem;

import static org.junit.jupiter.api.Assertions.*;

public class EdgeCaseTest {

    @Test
    void testDuplicateStudentsAllowedInAcademy() {
        OnlineAcademySystem academy =
                new OnlineAcademySystem("WeThinkCode");

        Student student1 =
                new Student(1, "John");

        Student student2 =
                new Student(1, "John");

        academy.addStudent(student1);
        academy.addStudent(student2);

        assertEquals(2,
                academy.getAllStudents().size());
    }

    @Test
    void testLargeNumberOfStudents() {
        OnlineAcademySystem academy =
                new OnlineAcademySystem("WeThinkCode");

        for (int i = 1; i <= 100; i++) {
            academy.addStudent(
                    new Student(i, "Student" + i));
        }

        assertEquals(100,
                academy.getAllStudents().size());
    }

    @Test
    void testCourseCapacityBoundary() {
        Course course =
                new Course("CSC101",
                        "Programming", 2);

        Student student1 =
                new Student(1, "John");

        Student student2 =
                new Student(2, "Sarah");

        assertTrue(course.enrolStudent(student1));
        assertTrue(course.enrolStudent(student2));

        assertEquals(2,
                course.getTotalStudents());
    }

    @Test
    void testRemovingFromEmptyAcademy() {
        CampusAcademySystem academy =
                new CampusAcademySystem("Campus");

        boolean removed =
                academy.removeStudentById(1);

        assertFalse(removed);
    }

    @Test
    void testProcessingLargeQueue() {
        OnlineAcademySystem academy =
                new OnlineAcademySystem("Queue Academy");

        for (int i = 1; i <= 50; i++) {
            academy.enqueueRegistration(
                    new Student(i, "Student" + i));
        }

        int processed = 0;

        while (academy.processNextRegistration() != null) {
            processed++;
        }

        assertEquals(50, processed);
    }

    @Test
    void testStudentNameCaseSensitivity() {
        Student student1 =
                new Student(1, "john");

        Student student2 =
                new Student(2, "John");

        assertNotEquals(
                student1.getName(),
                student2.getName()
        );
    }

    @Test
    void testQueueOrderPreserved() {
        OnlineAcademySystem academy =
                new OnlineAcademySystem("Queue Test");

        for (int i = 1; i <= 5; i++) {
            academy.enqueueRegistration(
                    new Student(i, "Student" + i));
        }

        for (int i = 1; i <= 5; i++) {
            Student processed =
                    academy.processNextRegistration();

            assertEquals(i,
                    processed.getId());
        }
    }

    @Test
    void testStudentCanRegisterMultipleCourses() {
        Student student =
                new Student(1, "Nova");

        Course course1 =
                new Course("CSC101",
                        "Programming", 20);

        Course course2 =
                new Course("DBS201",
                        "Databases", 20);

        student.registerCourse(course1);
        student.registerCourse(course2);

        assertEquals(2,
                student.getRegisteredCourses().size());
    }
}