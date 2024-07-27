package com.anglocrash.exampledb.data.roombd;

import androidx.annotation.Nullable;
import androidx.room.Entity;

import java.util.Objects;

public class StudentWithCourses {
    private String studentName;
    private String courseName;
    private String enrollmentDate;

    // Getters and setters
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public StudentWithCourses(String studentName, String courseName, String enrollmentDate) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentWithCourses that = (StudentWithCourses) o;
        return Objects.equals(studentName, that.studentName) && Objects.equals(courseName, that.courseName) && Objects.equals(enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName, enrollmentDate);
    }
}