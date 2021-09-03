package spring.bootcamp.week2.model;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
public class VisitingResearcher extends Instructor{
    private double hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(int id, String name, String address, String phoneNumber, List<Course> courseList, double hourlySalary) {
        super(id, name, address, phoneNumber, courseList);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return Double.compare(that.hourlySalary, hourlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary);
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
