# 🎓 Student Management Arena System — Java OOP Assessment

---

# Overview

In this assessment you will design and implement a Student Management Arena System in Java.

The system simulates an academic institution where students:
- register for courses
- manage assignments
- participate in classroom allocations
- compete on GPA leaderboards
- process registrations through queue systems

The skeleton project is provided. Your task is to implement the classes described in the steps below, following the principles of:
- Encapsulation
- Inheritance
- Abstraction
- Defensive Programming

---

# Learning Outcomes

- Object-Oriented Programming (Encapsulation, Inheritance, Abstraction)
- Greenfield Development
- Unit Testing with JUnit
- System Design
- Collections (ArrayList, HashMap, Queue)
- Defensive Copying
- Queue-Based Processing
- Bidirectional Mapping Logic

---

# Time Limit

3 hours

---

# Assessment Structure

| Component | Weight | Recommended Time |
|------------|--------|------------------|
| Implementation | 100% | 3 hours |

---

# Scoring

Coding Score = (tests passed / total tests) × 100%

Final Score = Coding Score

To pass, your Final Score must be 60% or higher.

---

# Project Structure

```text
student-management-arena/
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── za/
    │           └── co/
    │               └── wethinkcode/
    │                   ├── Main.java
    │                   │
    │                   ├── model/
    │                   │   ├── Student.java
    │                   │   ├── Course.java
    │                   │   ├── Assignment.java
    │                   │   ├── Classroom.java
    │                   │   ├── Submission.java
    │                   │   └── Leaderboard.java
    │                   │
    │                   └── service/
    │                       ├── AcademySystem.java
    │                       ├── OnlineAcademySystem.java
    │                       └── CampusAcademySystem.java
    │
    └── test/
        └── java/
            └── za/
                └── co/
                    └── wethinkcode/
                        ├── StudentTest.java
                        ├── CourseTest.java
                        ├── AssignmentTest.java
                        ├── LeaderboardTest.java
                        └── AcademySystemTest.java
```

---

# Running Tests

As you implement each step, run the full test suite:

```bash
mvn clean compile test
```

Your goal is to reach 100% of tests passing before submission.

---

# Implementation Steps

Work through the steps in order — later classes depend on earlier ones.

---

# Step 1 — Implement Student

File:
`src/main/java/za/co/wethinkcode/model/Student.java`

The Student class represents a learner in the academy.

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| id | int | private | Unique student identifier |
| name | String | private | Student full name |
| level | int | private | Academic level |
| gpa | double | private | Grade point average |
| registeredCourses | List<Course> | private | Student courses |
| completedAssignments | List<Assignment> | private | Completed assignments |

---

## Constructor

| Signature | Access |
|----------|--------|
| Student(int id, String name) | public |

---

## Initial Values

| Field | Value |
|------|------|
| level | 1 |
| gpa | 0.0 |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getId() | int | public | Returns student ID |
| getName() | String | public | Returns name |
| getLevel() | int | public | Returns level |
| getGpa() | double | public | Returns GPA |
| registerCourse(Course) | void | public | Adds course |
| completeAssignment(Assignment) | void | public | Adds completed assignment |
| updateGpa(double) | void | public | Updates GPA |
| levelUp() | void | public | Increases level |
| getRegisteredCourses() | List<Course> | public | Defensive copy |
| getCompletedAssignments() | List<Assignment> | public | Defensive copy |
| toString() | String | public | Student summary |

---

## Validation Rules

| Rule |
|------|
| GPA cannot be negative |
| GPA cannot exceed 4.0 |
| Student name cannot be blank |

---

# Step 2 — Implement Course

File:
`src/main/java/za/co/wethinkcode/model/Course.java`

The Course class represents an academic course students may enrol into.

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| courseCode | String | private | Unique course code |
| courseName | String | private | Course name |
| maxCapacity | int | private | Maximum students |
| enrolledStudents | List<Student> | private | Enrolled students |

---

## Constructor

| Signature | Access |
|----------|--------|
| Course(String courseCode, String courseName, int maxCapacity) | public |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getCourseCode() | String | public | Returns course code |
| getCourseName() | String | public | Returns course name |
| enrolStudent(Student) | boolean | public | Adds student if capacity available |
| removeStudentById(int) | boolean | public | Removes student |
| getEnrolledStudents() | List<Student> | public | Defensive copy |
| getTotalStudents() | int | public | Number of students |
| hasStudent(String) | boolean | public | Checks student existence |
| toString() | String | public | Course summary |

---

## Validation Rules

| Rule |
|------|
| Course capacity must be positive |
| Duplicate enrolments not allowed |
| Capacity may not be exceeded |

---

# Step 3 — Implement Assignment

File:
`src/main/java/za/co/wethinkcode/model/Assignment.java`

The Assignment class represents academic tasks completed by students.

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| assignmentId | int | private | Assignment ID |
| title | String | private | Assignment title |
| totalMarks | int | private | Assignment marks |
| submissions | List<Submission> | private | Student submissions |

---

## Constructor

| Signature | Access |
|----------|--------|
| Assignment(int assignmentId, String title, int totalMarks) | public |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getAssignmentId() | int | public | Returns ID |
| getTitle() | String | public | Returns title |
| getTotalMarks() | int | public | Returns marks |
| addSubmission(Submission) | void | public | Adds submission |
| getSubmissions() | List<Submission> | public | Defensive copy |
| getSubmissionCount() | int | public | Number of submissions |
| toString() | String | public | Assignment summary |

---

## Validation Rules

| Rule |
|------|
| Marks cannot be negative |
| Marks cannot exceed 100 |

---

# Step 4 — Implement Submission

File:
`src/main/java/za/co/wethinkcode/model/Submission.java`

The Submission class stores assignment submissions made by students.

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| submissionId | int | private | Submission ID |
| studentId | int | private | Student ID |
| assignmentId | int | private | Assignment ID |
| marksAwarded | int | private | Marks earned |

---

## Constructor

| Signature | Access |
|----------|--------|
| Submission(int submissionId, int studentId, int assignmentId, int marksAwarded) | public |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getSubmissionId() | int | public | Returns submission ID |
| getStudentId() | int | public | Returns student ID |
| getAssignmentId() | int | public | Returns assignment ID |
| getMarksAwarded() | int | public | Returns awarded marks |
| updateMarks(int) | void | public | Updates marks |
| toString() | String | public | Submission summary |

---

## Validation Rules

| Rule |
|------|
| Marks cannot be negative |
| Marks cannot exceed 100 |

---

# Step 5 — Implement Classroom

File:
`src/main/java/za/co/wethinkcode/model/Classroom.java`

The Classroom class represents teaching venues.

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| roomNumber | String | private | Classroom number |
| assignedCourse | Course | private | Assigned course |
| seatingCapacity | int | private | Seating limit |

---

## Constructor

| Signature | Access |
|----------|--------|
| Classroom(String roomNumber, int seatingCapacity) | public |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| getRoomNumber() | String | public | Returns room number |
| getAssignedCourse() | Course | public | Returns course |
| assignCourse(Course) | void | public | Assigns course |
| getSeatingCapacity() | int | public | Returns capacity |
| toString() | String | public | Classroom summary |

---

# Step 6 — Implement Leaderboard

File:
`src/main/java/za/co/wethinkcode/model/Leaderboard.java`

The Leaderboard tracks top academic performers.

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| rankings | List<Student> | private | Ranked students |
| studentLookup | HashMap<Integer, Student> | private | Fast student lookup |

---

## Constructor

| Signature | Access |
|----------|--------|
| Leaderboard() | public |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| addStudent(Student) | void | public | Adds student |
| getStudentById(int) | Student | public | Returns student |
| getTopStudent() | Student | public | Highest GPA student |
| getRankings() | List<Student> | public | Defensive copy |
| updateRankings() | void | public | Sorts rankings |
| totalStudents() | int | public | Total students |
| toString() | String | public | Leaderboard summary |

---

## Ranking Rules

| Rule |
|------|
| Highest GPA ranks first |
| Ties maintain insertion order |

---

# Step 7 — Implement AcademySystem

File:
`src/main/java/za/co/wethinkcode/service/AcademySystem.java`

The AcademySystem manages:
- students
- registration queues
- classroom allocations
- assignment processing

---

## Fields

| Field | Type | Access | Description |
|------|------|--------|-------------|
| academyName | String | private | Academy name |
| students | List<Student> | private | Student list |
| registrationQueue | Queue<Student> | private | Registration queue |
| classroomMappings | HashMap<Student, Classroom> | private | Student → classroom |
| reverseMappings | HashMap<Classroom, Student> | private | Classroom → student |

---

## Constructor

| Signature | Access |
|----------|--------|
| AcademySystem(String academyName) | public |

---

## Methods

| Method | Return Type | Access | Description |
|--------|-------------|--------|-------------|
| addStudent(Student) | void | public | Adds student |
| removeStudentById(int) | boolean | public | Removes student |
| getStudentById(int) | Student | public | Finds student |
| getAllStudents() | List<Student> | public | Unmodifiable list |
| enqueueRegistration(Student) | void | public | Adds to queue |
| processNextRegistration() | Student | public | Processes queue |
| assignClassroom(Student, Classroom) | void | public | Maps student |
| getClassroom(Student) | Classroom | public | Lookup classroom |
| getStudent(Classroom) | Student | public | Reverse lookup |
| academyName() | String | public | Returns academy name |

---

## Collections Requirements

| Collection | Usage |
|------------|------|
| ArrayList | ordered storage |
| HashMap | fast lookups |
| Queue | registration processing |
| LinkedList | queue implementation |
| BiMap-style mappings | classroom relationships |

---

# Step 8 — Implement OnlineAcademySystem

File:
`OnlineAcademySystem.java`

Rules:
- Online registrations process instantly
- Print:

```text
Online registration processed for Student X
```

---

# Step 9 — Implement CampusAcademySystem

File:
`CampusAcademySystem.java`

Rules:
- Classroom availability determines processing
- Print:

```text
Campus registration processed for Student X
```

---

# Before Submission

Ensure:

```bash
mvn clean compile test
```

Your goal is to achieve:
- clean code
- proper OOP structure
- defensive copying
- full test coverage

---

# Good luck — build your academy 🎓