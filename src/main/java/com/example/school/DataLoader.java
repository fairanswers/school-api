package com.example.school;

import com.example.school.model.Course;
import com.example.school.model.Student;
import com.example.school.model.Teacher;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final TeacherRepository teacherRepo;

    public DataLoader(StudentRepository studentRepo, CourseRepository courseRepo, TeacherRepository teacherRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // create sample courses (classes)
        Course c1 = new Course("Algebra I", "Mathematics");
        Course c2 = new Course("Biology", "Science");
        Course c3 = new Course("World History", "Social Studies");
        Course c4 = new Course("English Literature", "Language Arts");
        Course c5 = new Course("Computer Science", "Technology");
        courseRepo.saveAll(List.of(c1,c2,c3,c4,c5));

        // create sample teachers
        Teacher t1 = new Teacher("Alice","Johnson","Mathematics",10);
        Teacher t2 = new Teacher("Bob","Smith","Science",7);
        Teacher t3 = new Teacher("Carol","Williams","Social Studies",12);
        Teacher t4 = new Teacher("David","Brown","Language Arts",8);
        Teacher t5 = new Teacher("Eve","Davis","Technology",5);
        teacherRepo.saveAll(List.of(t1,t2,t3,t4,t5));

        // create sample students and enroll them in all classes
        Student s1 = new Student("John","Doe","A");
        Student s2 = new Student("Jane","Smith","B");
        Student s3 = new Student("Michael","Brown","A-");
        Student s4 = new Student("Emily","Wilson","B+");
        Student s5 = new Student("Daniel","Garcia","A");
        List<Course> allCourses = courseRepo.findAll();

        s1.setCourses(Set.copyOf(allCourses));
        s2.setCourses(Set.copyOf(allCourses));
        s3.setCourses(Set.copyOf(allCourses));
        s4.setCourses(Set.copyOf(allCourses));
        s5.setCourses(Set.copyOf(allCourses));

        studentRepo.saveAll(List.of(s1,s2,s3,s4,s5));
    }
}
