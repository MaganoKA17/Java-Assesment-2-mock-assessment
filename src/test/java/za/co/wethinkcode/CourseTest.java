package za.co.wethinkcode;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.model.Course;
import za.co.wethinkcode.model.Student;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    void testCourseCreation() {
        Course course = new Course("CSC101", "Programming", 30);

        assertEquals("CSC101", course.getCourseCode());
        assertEquals("Programming", course.getCourseName());
        assertEquals(30, course.getMaxCapacity());
    }

    @Test
    void testInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Course("CSC101", "Programming", 0);
        });
    }

    @Test
    void testEnrolStudent() {
        Course course = new Course("CSC101", "Programming", 2);
        Student student = new Student(1, "John");

        boolean enrolled = course.enrolStudent(student);

        assertTrue(enrolled);
        assertEquals(1, course.getTotalStudents());
    }

    @Test
    void testPreventDuplicateEnrolment() {
        Course course = new Course("CSC101", "Programming", 2);
        Student student = new Student(1, "Sarah");

        course.enrolStudent(student);
        boolean result = course.enrolStudent(student);

        assertFalse(result);
        assertEquals(1, course.getTotalStudents());
    }

    @Test
    void testPreventOverCapacity() {
        Course course = new Course("CSC101", "Programming", 1);

        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Luna");

        course.enrolStudent(student1);
        boolean result = course.enrolStudent(student2);

        assertFalse(result);
        assertEquals(1, course.getTotalStudents());
    }

    @Test
    void testRemoveStudentById() {
        Course course = new Course("CSC101", "Programming", 3);
        Student student = new Student(1, "Kai");

        course.enrolStudent(student);

        boolean removed = course.removeStudentById(1);

        assertTrue(removed);
        assertEquals(0, course.getTotalStudents());
    }

    @Test
    void testRemoveStudentNotFound() {
        Course course = new Course("CSC101", "Programming", 3);

        boolean removed = course.removeStudentById(999);

        assertFalse(removed);
    }

    @Test
    void testHasStudent() {
        Course course = new Course("CSC101", "Programming", 3);
        Student student = new Student(1, "Milo");

        course.enrolStudent(student);

        assertTrue(course.hasStudent("Milo"));
        assertFalse(course.hasStudent("Alex"));
    }

    @Test
    void testDefensiveCopyEnrolledStudents() {
        Course course = new Course("CSC101", "Programming", 3);
        Student student = new Student(1, "Nova");

        course.enrolStudent(student);

        var students = course.getEnrolledStudents();
        students.clear();

        assertEquals(1, course.getTotalStudents());
    }
}