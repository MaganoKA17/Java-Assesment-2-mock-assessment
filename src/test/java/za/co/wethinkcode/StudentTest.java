package za.co.wethinkcode;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.model.Assignment;
import za.co.wethinkcode.model.Course;
import za.co.wethinkcode.model.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testStudentCreation() {
        Student student = new Student(1, "John");

        assertEquals(1, student.getId());
        assertEquals("John", student.getName());
        assertEquals(1, student.getLevel());
        assertEquals(0.0, student.getGpa());
    }

    @Test
    void testLevelUp() {
        Student student = new Student(1, "Sarah");

        student.levelUp();

        assertEquals(2, student.getLevel());
    }

    @Test
    void testUpdateGpa() {
        Student student = new Student(1, "Liam");

        student.updateGpa(3.5);

        assertEquals(3.5, student.getGpa());
    }

    @Test
    void testInvalidNegativeGpa() {
        Student student = new Student(1, "Emma");

        assertThrows(IllegalArgumentException.class, () -> {
            student.updateGpa(-1.0);
        });
    }

    @Test
    void testInvalidHighGpa() {
        Student student = new Student(1, "Kai");

        assertThrows(IllegalArgumentException.class, () -> {
            student.updateGpa(5.0);
        });
    }

    @Test
    void testRegisterCourse() {
        Student student = new Student(1, "Nova");
        Course course = new Course("CSC101", "Programming", 30);

        student.registerCourse(course);

        assertEquals(1, student.getRegisteredCourses().size());
    }

    @Test
    void testPreventDuplicateCourseRegistration() {
        Student student = new Student(1, "Mia");
        Course course = new Course("CSC101", "Programming", 30);

        student.registerCourse(course);
        student.registerCourse(course);

        assertEquals(1, student.getRegisteredCourses().size());
    }

    @Test
    void testCompleteAssignment() {
        Student student = new Student(1, "Alex");
        Assignment assignment = new Assignment(1, "OOP Project", 100);

        student.completeAssignment(assignment);

        assertEquals(1, student.getCompletedAssignments().size());
    }

    @Test
    void testDefensiveCopyRegisteredCourses() {
        Student student = new Student(1, "Rhea");
        Course course = new Course("CSC101", "Programming", 30);

        student.registerCourse(course);

        var courses = student.getRegisteredCourses();
        courses.clear();

        assertEquals(1, student.getRegisteredCourses().size());
    }

    @Test
    void testDefensiveCopyCompletedAssignments() {
        Student student = new Student(1, "Zane");
        Assignment assignment = new Assignment(1, "Database Task", 100);

        student.completeAssignment(assignment);

        var assignments = student.getCompletedAssignments();
        assignments.clear();

        assertEquals(1, student.getCompletedAssignments().size());
    }
}