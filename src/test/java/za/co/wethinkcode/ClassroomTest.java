package za.co.wethinkcode;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.model.Classroom;

import static org.junit.jupiter.api.Assertions.*;

public class ClassroomTest {

    @Test
    void testClassroomCreation() {
        Classroom classroom =
                new Classroom("A12", 40);

        assertEquals("A12",
                classroom.getRoomNumber());

        assertEquals(40,
                classroom.getSeatingCapacity());
    }

    @Test
    void testInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Classroom("B10", 0);
        });
    }

    @Test
    void testAssignCourseInitiallyNull() {
        Classroom classroom =
                new Classroom("C20", 25);

        assertNull(classroom.getAssignedCourse());
    }

    @Test
    void testToString() {
        Classroom classroom =
                new Classroom("D15", 35);

        String output = classroom.toString();

        assertTrue(output.contains("D15"));
        assertTrue(output.contains("35"));
    }

    @Test
    void testMultipleClassrooms() {
        Classroom classroom1 =
                new Classroom("A1", 20);

        Classroom classroom2 =
                new Classroom("B2", 30);

        assertNotEquals(
                classroom1.getRoomNumber(),
                classroom2.getRoomNumber()
        );
    }
}