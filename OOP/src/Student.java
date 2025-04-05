import java.io.Serializable;

public class Student extends Human implements Serializable
{
    String speciality;
    String group;
    double rating;
    double attendance;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public Student(String lastName, String firstName, int age, String speciality, String group, double rating, double attendance) {
        super(lastName, firstName, age);
        this.speciality = speciality;
        this.group = group;
        this.rating = rating;
        this.attendance = attendance;
        System.out.println("SConstructor:\t" + Integer.toHexString(this.hashCode()));
    }

    @Override
    public String toString() {
        return super.toString() + ' ' +
                speciality + ' ' +
                group + ' ' +
                rating + ' ' +
                attendance;
    }
}
