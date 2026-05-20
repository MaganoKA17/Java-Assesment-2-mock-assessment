//package za.co.wethinkcode.service;
//
//import za.co.wethinkcode.model.Classroom;
//import za.co.wethinkcode.model.Student;
//
//public class CampusAcademySystem extends AcademySystem {
//
//    public CampusAcademySystem(String academyName) {
//        super(academyName);
//    }
//
//    @Override
//    protected void processRegistration(Student student) {
//        if (student != null) {
//            System.out.println(
//                    "Campus registration processed for "
//                            + student.getName());
//        }
//    }
//
//    public void assignClassroom(Student student,
//                                Classroom classroom) {
//        classroomAssignments.put(student, classroom);
//    }
//
//    public Classroom getClassroom(Student student) {
//        return classroomAssignments.getForward(student);
//    }
//
//    public Student getStudent(Classroom classroom) {
//        return classroomAssignments.getReverse(classroom);
//    }
//}