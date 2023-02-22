package com.sda.study.springbootpractice.repositories;

import com.sda.study.springbootpractice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to handle all Course DB operations
 *
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
