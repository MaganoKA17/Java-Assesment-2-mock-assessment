//package za.co.wethinkcode;
//
//import org.junit.jupiter.api.Test;
//import za.co.wethinkcode.model.Leaderboard;
//import za.co.wethinkcode.model.Student;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class LeaderboardTest {
//
//    @Test
//    void testAddStudent() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student student = new Student(1, "John");
//
//        leaderboard.addStudent(student);
//
//        assertEquals(1, leaderboard.totalStudents());
//    }
//
//    @Test
//    void testGetStudentById() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student student = new Student(1, "Sarah");
//
//        leaderboard.addStudent(student);
//
//        Student found = leaderboard.getStudentById(1);
//
//        assertNotNull(found);
//        assertEquals("Sarah", found.getName());
//    }
//
//    @Test
//    void testGetStudentByIdNotFound() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student found = leaderboard.getStudentById(999);
//
//        assertNull(found);
//    }
//
//    @Test
//    void testTopStudent() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student student1 = new Student(1, "Kai");
//        student1.updateGpa(3.2);
//
//        Student student2 = new Student(2, "Nova");
//        student2.updateGpa(3.9);
//
//        leaderboard.addStudent(student1);
//        leaderboard.addStudent(student2);
//
//        Student top = leaderboard.getTopStudent();
//
//        assertEquals("Nova", top.getName());
//    }
//
//    @Test
//    void testUpdateRankings() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student student1 = new Student(1, "Alex");
//        student1.updateGpa(2.5);
//
//        Student student2 = new Student(2, "Luna");
//        student2.updateGpa(3.7);
//
//        Student student3 = new Student(3, "Milo");
//        student3.updateGpa(3.0);
//
//        leaderboard.addStudent(student1);
//        leaderboard.addStudent(student2);
//        leaderboard.addStudent(student3);
//
//        leaderboard.updateRankings();
//
//        assertEquals("Luna",
//                leaderboard.getRankings().get(0).getName());
//
//        assertEquals("Milo",
//                leaderboard.getRankings().get(1).getName());
//
//        assertEquals("Alex",
//                leaderboard.getRankings().get(2).getName());
//    }
//
//    @Test
//    void testTieMaintainsInsertionOrder() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student student1 = new Student(1, "John");
//        student1.updateGpa(3.5);
//
//        Student student2 = new Student(2, "Sarah");
//        student2.updateGpa(3.5);
//
//        leaderboard.addStudent(student1);
//        leaderboard.addStudent(student2);
//
//        assertEquals("John",
//                leaderboard.getRankings().get(0).getName());
//
//        assertEquals("Sarah",
//                leaderboard.getRankings().get(1).getName());
//    }
//
//    @Test
//    void testDefensiveCopyRankings() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        Student student = new Student(1, "Emma");
//
//        leaderboard.addStudent(student);
//
//        var rankings = leaderboard.getRankings();
//
//        rankings.clear();
//
//        assertEquals(1, leaderboard.totalStudents());
//    }
//
//    @Test
//    void testGetTopStudentEmptyLeaderboard() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        assertNull(leaderboard.getTopStudent());
//    }
//}