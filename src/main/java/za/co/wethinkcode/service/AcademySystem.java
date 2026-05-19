package za.co.wethinkcode.service;

import za.co.wethinkcode.model.Classroom;
import za.co.wethinkcode.model.Student;

import java.util.*;

public abstract class AcademySystem {

    public AcademySystem(String academyName) {
        this.academyName = academyName;
    }

    // TODO: declare private fields:
    // academyName (String)
    // students (List<Student>)
    // registrationQueue (Queue<Student>)
    // classroomMappings (HashMap<Student, Classroom>)
    // reverseMappings (HashMap<Classroom, Student>)

    // TODO: implement constructor:
    // AcademySystem(String academyName)
    //
    // - initialise students as new ArrayList<>()
    // - initialise registrationQueue as new LinkedList<>()
    // - initialise classroomMappings as new HashMap<>()
    // - initialise reverseMappings as new HashMap<>()

    // =========================
    // STUDENT MANAGEMENT
    // =========================

    // TODO: implement addStudent(Student student)
    // - add student to list

    // TODO: implement removeStudentById(int studentId)
    // - remove matching student
    // - return true if removed
    // - otherwise false

    // TODO: implement getStudentById(int studentId)
    // - return matching student
    // - otherwise return null

    // TODO: implement getAllStudents()
    // - return unmodifiable list

    // =========================
    // REGISTRATION QUEUE
    // =========================

    // TODO: implement enqueueRegistration(Student student)
    // - add student to queue

    // TODO: implement processNextRegistration()
    // - process next student in queue
    // - remove from queue
    // - return processed student
    // - return null if queue empty

    // =========================
    // CLASSROOM MAPPINGS
    // =========================

    // TODO: implement assignClassroom(Student student, Classroom classroom)
    //
    // Rules:
    // - add mapping student -> classroom
    // - add reverse mapping classroom -> student

    // TODO: implement getClassroom(Student student)
    // - return mapped classroom

    // TODO: implement getStudent(Classroom classroom)
    // - return mapped student

    // TODO: implement academyName()
    // - return academy name

    // =========================
    // ABSTRACT BEHAVIOUR
    // =========================

    // Each subclass defines registration processing behaviour
    protected abstract void processRegistration(Student student);
}