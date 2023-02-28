package com.sda.study.springbootpractice.components;

import com.sda.study.springbootpractice.exceptions.CourseNotFoundException;
import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.exceptions.StudentNotFoundException;
import com.sda.study.springbootpractice.exceptions.TeacherNotFoundException;
import com.sda.study.springbootpractice.models.*;
import com.sda.study.springbootpractice.services.CourseService;
import com.sda.study.springbootpractice.services.SchoolService;
import com.sda.study.springbootpractice.services.StudentService;
import com.sda.study.springbootpractice.services.TeacherService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Component to initialize data on application startup
 *
 */
@Component
public class DataInit {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @PostConstruct
    public void Init() throws SchoolNotFoundException, CourseNotFoundException {
        initSchool();
        initCourse();
        initStudent();
        initTeacher();

    }

    //PRIVATE METHODS
    private void initSchool(){
        System.out.println("Starting School initialization...");
        School school = new School();
        school.setName("Tartu University");
        school.setAddress("Ülikooli 18, Tartu");
        school.setPhone("+3725644554");

        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            System.out.println("Cannot pre- initialize school: " + school.getName());
        } catch( SchoolNotFoundException e) {
            schoolService.createSchool(school);
        }
    }
    private void initCourse() throws SchoolNotFoundException {
        System.out.println("Starting Course initialization...");
        Course course = new Course();
        course.setName("Java fundamentals");
        course.setSchool(schoolService.findSchoolByName("Tartu University"));
        course.setStartDate(LocalDate.parse("2013-01-12"));
        course.setDurationInDays(40);


        try{
            Course searchCourse = courseService.findCourseByName((course.getName()));

        } catch (CourseNotFoundException e) {
            courseService.createCourse(course);
        }

    }

    private void initStudent() {
        System.out.println("Starting Student initialization...");
        Student student = new Student();
        student.setName("Kalle Kool");
        student.setAge(68);
        student.setGender(Gender.MALE);
        student.setEmail("Kalle.Kool@mail.ee");

        try {
            Student searchStudent = studentService.findStudentByName((student.getName()));

        } catch (StudentNotFoundException e) {
            studentService.createStudent(student);
        }
    }

        private void initTeacher() {
            System.out.println("Starting Teacher initialization...");

            try {
                Course course = courseService.findCourseByName("Java fundamentals");
                Teacher teacher = new Teacher();
                teacher.setName("Mikey Mouse");
                teacher.setEmail("mickeymouse@gmail.com");
                teacher.setGender(Gender.MALE);
                teacher.setSpecializedCourses(Collections.singletonList(course));


                try {
                    Teacher searchTeacher = teacherService.findTeacherByName(teacher.getName());
                    System.out.println("Cannot pre-initialize teacher: " + teacher.getName());
                } catch (TeacherNotFoundException e) {
                    teacherService.createTeacher(teacher);
                }
            } catch (CourseNotFoundException e) {
                System.out.println("Cannot pre-initialize teacher! Reason:" + e.getLocalizedMessage());
            }
        }

        }

