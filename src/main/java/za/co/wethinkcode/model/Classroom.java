package za.co.wethinkcode.model;

public class Classroom {

    // TODO: declare private fields:
    // roomNumber (String)
    // assignedCourse (Course)
    // seatingCapacity (int)
    private String roomNumber;
    private Course assignedCourse;
    private int seatingCapacity;

    // TODO: implement constructor:
    // Classroom(String roomNumber, int seatingCapacity)
    //
    // Rules:
    // - seatingCapacity must be greater than 0

    public Classroom(String roomNumber, int seatingCapacity) {
        this.roomNumber = roomNumber;
        if (seatingCapacity < 0) throw new IllegalArgumentException();
        this.seatingCapacity = seatingCapacity;
    }


    // TODO: implement getters:
    // String getRoomNumber()
    // Course getAssignedCourse()
    // int getSeatingCapacity()
    public String getRoomNumber() {return this.roomNumber;}

    public Course getAssignedCourse() {return this.assignedCourse;}

    public int getSeatingCapacity() {return this.seatingCapacity;}


    // TODO: implement assignCourse(Course course)
    // - assign course to classroom
    public void assignCourse(Course c){
        this.assignedCourse = c;
    }

    // TODO: override toString()
    // Example:
    // Classroom A12 (Capacity: 40)
    @Override
    public String toString(){
        return "Classroom" + getRoomNumber() + "(Capacity" + getSeatingCapacity() + ")";
    }
}