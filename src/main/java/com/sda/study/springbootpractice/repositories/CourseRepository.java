package com.sda.study.springbootpractice.repositories;
import com.sda.study.springbootpractice.models.Course;
import com.sda.study.springbootpractice.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository to handle all Course DB operations
 *
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);
List<Course> findAllBySchool(School school);
}
