package com.anglocrash.exampledb;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.anglocrash.exampledb.data.roombd.AppDatabase;
import com.anglocrash.exampledb.data.roombd.Course;
import com.anglocrash.exampledb.data.roombd.Enrollment;
import com.anglocrash.exampledb.data.roombd.Student;
import com.anglocrash.exampledb.data.roombd.StudentDao;

public class MainActivity extends AppCompatActivity {
/*

    private void insertDemoData() {
        // Insert students
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setEmail("john@example.com");
        student1.setBirthDate("01031995");
        db.studentDao().insert(student1);

        Student student2 = new Student();
        student2.setName("Jane Smith");
        student2.setEmail("jane@example.com");
        student2.setBirthDate("01031995");
        db.studentDao().insert(student2);

        // Insert courses
        Course course1 = new Course();
        course1.setName("Mathematics");
        course1.setCourseCode(101);
        db.courseDao().insert(course1);

        Course course2 = new Course();
        course2.setName("History");
        course2.setCourseCode(102);
        db.courseDao().insert(course2);

        // Insert enrollments
        Enrollment enrollment1 = new Enrollment();
        enrollment1.setStudentId(1);
        enrollment1.setCourseId(1);
        enrollment1.setEnrollmentDate("2023-07-01");
        db.enrollmentDao().insert(enrollment1);

        Enrollment enrollment2 = new Enrollment();
        enrollment2.setStudentId(2);
        enrollment2.setCourseId(2);
        enrollment2.setEnrollmentDate("2023-07-01");
        db.enrollmentDao().insert(enrollment2); // Corrected this line
    }
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });






    }



}
