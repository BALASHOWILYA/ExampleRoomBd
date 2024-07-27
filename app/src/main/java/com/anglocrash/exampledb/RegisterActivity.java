package com.anglocrash.exampledb;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.anglocrash.exampledb.data.roombd.AppDatabase;
import com.anglocrash.exampledb.data.roombd.Course;
import com.anglocrash.exampledb.data.roombd.CourseDao;
import com.anglocrash.exampledb.data.roombd.Enrollment;
import com.anglocrash.exampledb.data.roombd.EnrollmentDao;
import com.anglocrash.exampledb.data.roombd.Student;
import com.anglocrash.exampledb.data.roombd.StudentDao;
import com.anglocrash.exampledb.data.roombd.StudentWithCourses;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RegisterActivity extends AppCompatActivity {


    private Button button;
    private Button secondButtom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        AppDatabase database = AppDatabase.getDatabase(getApplicationContext());

        button = findViewById(R.id.button_id);
        secondButtom = findViewById(R.id.button_db_room_id);
        button.setOnClickListener(v->{
            // Вставка данных
            insertDemoData(database);
        });

        secondButtom.setOnClickListener(
                v->{
                    displayData(database);
                  //  displayStudentsWithCourses(database);
                    displayStudentsWithCoursesLeftJoin(database);
                }
        );




    }



    private void displayData(AppDatabase database) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                List<Student> students = database.studentDao().getAllStudents();
                List<Course> courses = database.courseDao().getAllCourses();
                List<Enrollment> enrollments = database.enrollmentDao().getAllEnrollments();

                runOnUiThread(() -> {
                    for (Student student : students) {
                        Log.d("StudentInfo", "ID: " + student.getId() + ", Name: " + student.getName());
                    }
                    for (Course course : courses) {
                        Log.d("CourseInfo", "ID: " + course.getId() + ", Name: " + course.getName());
                    }
                    for (Enrollment enrollment : enrollments) {
                        Log.d("EnrollmentInfo", "StudentID: " + enrollment.getStudentId() + ", CourseID: " + enrollment.getCourseId() + ", Date: " + enrollment.getEnrollmentDate());
                    }
                });
            } catch (Exception e) {
                Log.e("DatabaseFetchError", "Error fetching data", e);
            }
        });
    }



    private void insertDemoData(AppDatabase database) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                // Вставка студентов
                Student student1 = new Student();
                student1.setName("John Doe");
                student1.setEmail("john@example.com");
                student1.setBirthDate("01031995");
                database.studentDao().insert(student1);

                Student student2 = new Student();
                student2.setName("Jane Smith");
                student2.setEmail("jane@example.com");
                student2.setBirthDate("01031995");
                database.studentDao().insert(student2);

                // Вставка курсов
                Course course1 = new Course();
                course1.setName("Mathematics");
                course1.setCourseCode(101);
                database.courseDao().insert(course1);

                Course course2 = new Course();
                course2.setName("History");
                course2.setCourseCode(102);
                database.courseDao().insert(course2);

                // Вставка записей об обучении
                Enrollment enrollment1 = new Enrollment();
                enrollment1.setStudentId(3);
                enrollment1.setCourseId(3);
                enrollment1.setEnrollmentDate("2023-07-01");
                database.enrollmentDao().insert(enrollment1);

                Enrollment enrollment2 = new Enrollment();
                enrollment1.setStudentId(4);
                enrollment1.setCourseId(4);
                enrollment2.setEnrollmentDate("2023-07-01");
                database.enrollmentDao().insert(enrollment2);

                Log.d("DatabaseInsert", "Demo data successfully inserted.");
            } catch (Exception e) {
                Log.e("DatabaseInsertError", "Error inserting demo data", e);
            }
        });
    }

    private void displayStudentsWithCourses(AppDatabase database) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                List<StudentWithCourses> studentsWithCourses = database.enrollmentDao().getStudentsWithCourses();

                runOnUiThread(() -> {
                    for (StudentWithCourses studentWithCourses : studentsWithCourses) {
                        Log.d("StudentCourseInfo", "Student: " + studentWithCourses.getStudentName() +
                                ", Course: " + studentWithCourses.getCourseName() +
                                ", Enrollment Date: " + studentWithCourses.getEnrollmentDate());
                    }
                });
            } catch (Exception e) {
                Log.e("DatabaseFetchError", "Error fetching students with courses", e);
            }
        });
    }

    private void displayStudentsWithCoursesLeftJoin(AppDatabase database) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                List<StudentWithCourses> studentsWithCourses = database.enrollmentDao().getStudentsWithCoursesLeftJoin();

                runOnUiThread(() -> {
                    for (StudentWithCourses studentWithCourses : studentsWithCourses) {
                        Log.d("StudentCourseInfo", "Student: " + studentWithCourses.getStudentName() +
                                ", Course: " + studentWithCourses.getCourseName() +
                                ", Enrollment Date: " + studentWithCourses.getEnrollmentDate());
                    }
                });
            } catch (Exception e) {
                Log.e("DatabaseFetchError", "Error fetching students with courses (left join)", e);
            }
        });
    }

}
