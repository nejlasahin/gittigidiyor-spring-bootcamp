package spring.bootcamp.week2.model;


import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
public class PermanentInstructor extends Instructor{
    private double fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(int id, String name, String address, String phoneNumber, List<Course> courseList, double fixedSalary) {
        super(id, name, address, phoneNumber, courseList);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return Double.compare(that.fixedSalary, fixedSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fixedSalary);
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
